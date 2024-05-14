package com.apprh.apprh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apprh.apprh.models.Candidato;
import com.apprh.apprh.models.Vaga;
import com.apprh.apprh.repository.CandidatoRepository;
import com.apprh.apprh.repository.VagaRepository;

@Controller
public class VagaController {

    private VagaRepository vr;
    private CandidatoRepository cr;

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form(){
        return "vaga/formVaga";
    }
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(){
        return "";
    }
}
