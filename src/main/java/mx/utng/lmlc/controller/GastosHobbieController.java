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
import mx.utng.lmlc.model.entity.GastosHobbie;
import mx.utng.lmlc.model.service.IGastosHobbieService;

@Controller
@SessionAttributes("gastosHobbie")
public class GastosHobbieController {
    
    @Autowired
    private IGastosHobbieService service;

    @GetMapping({"/gastosHobbie", "/gastosHobbie/", "/gastosHobbie/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Gastos Hobbies");
        model.addAttribute("gastosHobbies", service.list()); 
        return "gastosHobbie-list";
    }

    @GetMapping("/gastosHobbie/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Gastos Hobbies");
        model.addAttribute("gastosHobbie", new GastosHobbie());
        return "gastosHobbie-form";
    }

    @PostMapping("/gastosHobbie/form")
    public String save(@Valid GastosHobbie gastosHobbie, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos hobbies");
            return "gastosHobbie-form";
        }
        service.save(gastosHobbie);
        return "redirect:/gastosHobbie/list";
    }

    @GetMapping("/gastosHobbie/form/{id}")
    public String update(@PathVariable Long id, Model model){
        GastosHobbie gastosHobbie = null;
        if(id>0){
            gastosHobbie = service.getById(id);
        }else{
            return "redirect:/gastosHobbie/list";
        }
        model.addAttribute("title", "Editar Gastos");
        model.addAttribute("gastosHobbie", gastosHobbie);
        return "gastosHobbie-form";
    }

    @GetMapping("/gastosHobbie/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/gastosHobbie/list";
    }



}