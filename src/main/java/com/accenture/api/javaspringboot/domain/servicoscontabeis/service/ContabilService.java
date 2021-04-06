package com.accenture.api.javaspringboot.domain.servicoscontabeis.service;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;
import com.accenture.api.javaspringboot.domain.livrocaixa.dto.LivroCaixaDTO;
import com.accenture.api.javaspringboot.domain.servicoscontabeis.dto.ContabilDTO;
import com.accenture.api.javaspringboot.repository.ClienteRepository;
import com.accenture.api.javaspringboot.repository.LivroCaixaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContabilService {
    private final LivroCaixaRepository lcr;
    private final ClienteRepository cr;

    public ContabilService(ClienteRepository cr, LivroCaixaRepository lcr) {
        this.cr = cr;
        this.lcr = lcr;
    }

    public ContabilDTO contabilById(int id){
        ContabilDTO filtro = new ContabilDTO();
        Cliente cliente = cr.findById(id).
                orElseThrow(()->new RuntimeException("Cliente não encontrado"));
        List<LivroCaixa> livroCaixaList = lcr.findByClienteId(cliente.getId());
        return getContabilDTO(filtro, cliente, livroCaixaList);
    }

    public ContabilDTO contabilByIdAndDate(int id, Date inicio, Date fim){
        ContabilDTO filtro = new ContabilDTO();
        Cliente cliente = cr.findById(id).
                orElseThrow(()->new RuntimeException("Cliente não encontrado"));
        List<LivroCaixa> livroCaixaList = lcr.findByDataLancamentoBetweenAndClienteId(inicio, fim, cliente.getId());
        return getContabilDTO(filtro, cliente, livroCaixaList);
    }

    @NotNull
    private ContabilDTO getContabilDTO(ContabilDTO filtro, Cliente cliente, List<LivroCaixa> livroCaixaList) {
        filtro.setId(cliente.getId());
        filtro.setNome(cliente.getNome());
        filtro.setCpfCnpj(cliente.getCpfCnpj());
        filtro.setTelefone(cliente.getTelefone());
        List<LivroCaixaDTO> livroCaixaDTOS = fromLivroCaixaDTO(livroCaixaList);

        for(LivroCaixaDTO lv: livroCaixaDTOS){
            filtro.getContabil().add(lv);
        }
        return filtro;
    }

    private List<LivroCaixaDTO> fromLivroCaixaDTO(List<LivroCaixa> livroCaixaList) {
        List<LivroCaixaDTO> livroCaixaDTOList = new ArrayList<>();
        double total = 0.0;

        for(LivroCaixa lv : livroCaixaList){
            if(lv.getTipo().equals("C")){
                total += lv.getValor();
                LivroCaixaDTO livroCaixaDTO = new LivroCaixaDTO(lv.getId(), lv.getDataLancamento(),
                        lv.getDescricao(), lv.getTipo(),lv.getValor(),total);
                livroCaixaDTOList.add(livroCaixaDTO);
            }
            else{
                total -= lv.getValor();
                LivroCaixaDTO livroCaixaDTO = new LivroCaixaDTO(lv.getId(), lv.getDataLancamento(),
                        lv.getDescricao(), lv.getTipo(),lv.getValor(),total);
                livroCaixaDTOList.add(livroCaixaDTO);
            }
        }
        return livroCaixaDTOList;
    }
}
