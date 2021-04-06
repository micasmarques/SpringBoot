package com.accenture.api.javaspringboot.domain.servicoscontabeis.controller;

import com.accenture.api.javaspringboot.domain.servicoscontabeis.dto.ContabilDTO;
import com.accenture.api.javaspringboot.domain.servicoscontabeis.service.ContabilService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping(value = "/servicosContabeis/data/{codigo}")
    public @ResponseBody ContabilDTO getList(@PathVariable Integer codigo, @RequestParam(value = "start") String start,
                                                  @RequestParam(value = "end") String end) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date endDate = f.parse(end);
        Date startDate = f.parse(start);
        return cs.contabilByIdAndDate(codigo, startDate, endDate);
    }
}