package br.edu.ifal.lembretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LembreteControler {

    @Autowired
    LembreteRepositorio lr; 

    @RequestMapping("/cadastra")
    public ModelAndView cadastra(){
       ModelAndView mv = new ModelAndView("formLembrete.html");
       mv.addObject("lembrete", new Lembrete());
       return mv;
    }
    
    @RequestMapping("/salva")
    public ModelAndView salvar(Lembrete lembrete){
        lr.save(lembrete);
        return new ModelAndView("redirect:/lista");
    }

    @RequestMapping("/lista")
    public ModelAndView lista(){
        ModelAndView resposta = new ModelAndView("listaLembrete.html");
        resposta.addObject("lembretes", lr.findAll());
        return resposta;
    }
}