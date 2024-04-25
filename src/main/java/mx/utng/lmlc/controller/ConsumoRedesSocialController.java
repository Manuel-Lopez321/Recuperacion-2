package mx.utng.lmlc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.lmlc.model.entity.ConsumoRedesSocial;
import mx.utng.lmlc.model.service.IConsumoRedesSocialService;

@Controller
@SessionAttributes("consumoRedesSocial")
public class ConsumoRedesSocialController {
    
    @Autowired
    private IConsumoRedesSocialService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Consumo Redes Sociales");
        model.addAttribute("consumoRedesSocials", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Consumo Redes Sociales");
        model.addAttribute("consumoRedesSocial", new ConsumoRedesSocial());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid ConsumoRedesSocial consumoRedesSocial, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de consumo redes sociales");
            return "form";
        }
        service.save(consumoRedesSocial);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ConsumoRedesSocial consumoRedesSocial = null;
        if(id>0){
            consumoRedesSocial = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Consumo");
        model.addAttribute("consumoRedesSocial", consumoRedesSocial);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
