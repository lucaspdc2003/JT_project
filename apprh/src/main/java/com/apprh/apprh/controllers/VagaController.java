package com.apprh.apprh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apprh.apprh.models.Candidato;
import com.apprh.apprh.models.Vaga;
import com.apprh.apprh.repository.CandidatoRepository;
import com.apprh.apprh.repository.VagaRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VagaController {
    @Autowired
    private VagaRepository vr;
    @Autowired
    private CandidatoRepository cr;

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form(){
        return "vaga/formVaga";
    }
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(Vaga vaga, BindingResult resultado, RedirectAttributes atributos){
        if(resultado.hasErrors()){
            atributos.addFlashAttribute("mensagem", "verifique os campos");
            return "redirect:/cadastrarVaga";
        }
        vr.save(vaga);
        atributos.addFlashAttribute("mensagem", "Vaga cadastrada!");
        return "redirect:/cadastrarVaga";
    }

    @RequestMapping("/vagas")
    public ModelAndView listaVagas(){
        ModelAndView mv =  new ModelAndView("vaga/listaVaga");
        Iterable<Vaga> vagas = vr.findAll();
        mv.addObject("vagas", vagas);
        return mv;
        
    }
    
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesvaga (@PathVariable("codigo") long codigo){
        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("vaga/detalhesvaga");
        mv.addObject("vaga", vaga);

        Iterable<Candidato> candidatos = cr.findByVaga(vaga);
        mv.addObject("candidatos", candidatos);
        return mv;
    }
}
