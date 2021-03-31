package com.accenture.api.javaSpringBoot.domain.livroCaixa.comparator;

import com.accenture.api.javaSpringBoot.domain.livroCaixa.domain.LivroCaixa;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class CompareByIDCliente implements Comparator<LivroCaixa> {
    @Override
    public int compare(LivroCaixa o1, LivroCaixa o2) {
        if (o1.getCliente().getId() < o2.getCliente().getId()) return -1;
        else if (o1.getCliente().getId() > o2.getCliente().getId()) return +1;
        else return 0;       }
}
