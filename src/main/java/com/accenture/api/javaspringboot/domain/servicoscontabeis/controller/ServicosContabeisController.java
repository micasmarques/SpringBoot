package com.accenture.api.javaspringboot.domain.servicoscontabeis.controller;

import com.accenture.api.javaspringboot.domain.servicoscontabeis.dto.ContabilDTO;
import com.accenture.api.javaspringboot.domain.servicoscontabeis.service.ContabilService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServicosContabeisController {
    private final ContabilService cs;

    public ServicosContabeisController(ContabilService cs) {
        this.cs = cs;
    }

    @GetMapping(value = "/servicosContabeis/{codigo}")
    public @ResponseBody ContabilDTO getContabil(@PathVariable Integer codigo){
        return cs.contabilById(codigo);
    }
}