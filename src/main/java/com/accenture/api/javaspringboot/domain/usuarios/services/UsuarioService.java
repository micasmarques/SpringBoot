package com.accenture.api.javaspringboot.domain.usuarios.services;

import com.accenture.api.javaspringboot.domain.usuarios.domain.Usuario;
import com.accenture.api.javaspringboot.repository.UsuarioRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String verificaLoginAndSenha(String usuario, String senha){
        Usuario obj = usuarioRepository.findByLoginAndSenha(usuario, senha);
        if (obj == null){
            return "Usuario e/ou senha invalida!";
        }
        if (obj.getStatus().equals("C")) {
            return "Usuario está inativo no sistema!";
        } return "Usuario "+ obj.getNome() + " logado com sucesso!";
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\micael.marques.silva\\Downloads\\jasper";
        List<Usuario> employees = usuarioRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:usuarios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\usuarios.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\usuarios.pdf");
        }

        return "report generated in path : " + path;
    }
}
