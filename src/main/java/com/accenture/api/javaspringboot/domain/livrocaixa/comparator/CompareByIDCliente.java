package com.accenture.api.javaspringboot.domain.livrocaixa.comparator;

import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;

import java.util.Comparator;

public class CompareByIDCliente implements Comparator<LivroCaixa> {
    @Override
    public int compare(LivroCaixa o1, LivroCaixa o2) {
        if (o1.getCliente().getId() < o2.getCliente().getId()) return -1;
        else if (o1.getCliente().getId() > o2.getCliente().getId()) return +1;
        else return 0;       }
}
