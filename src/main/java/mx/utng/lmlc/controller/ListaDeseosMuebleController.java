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
import mx.utng.lmlc.model.entity.ListaDeseosMueble;
import mx.utng.lmlc.model.service.IListaDeseosMuebleService;

@Controller
@SessionAttributes("listaDeseosMueble")
public class ListaDeseosMuebleController {
    
    @Autowired
    private IListaDeseosMuebleService service;

    @GetMapping({"/listaDeseosMueble", "/listaDeseosMueble/", "/listaDeseosMueble/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Lista Deseos Muebles");
        model.addAttribute("listaDeseosMuebles", service.list());
        return "listaDeseosMueble-list";
    }

    @GetMapping("/listaDeseosMueble/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Lista Deseos Muebles");
        model.addAttribute("listaDeseosMueble", new ListaDeseosMueble());
        return "listaDeseosMueble-form";
    }

    @PostMapping("/listaDeseosMueble/form")
    public String save(@Valid ListaDeseosMueble listaDeseosMueble, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de lista deseos muebles");
            return "listaDeseosMueble-form";
        }
        service.save(listaDeseosMueble);
        return "redirect:/listaDeseosMueble/list";
    }

    @GetMapping("/listaDeseosMueble/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaDeseosMueble listaDeseosMueble = null;
        if(id>0){
            listaDeseosMueble = service.getById(id);
        }else{
            return "redirect:/listaDeseosMueble/list";
        }
        model.addAttribute("title", "Editar Lista Deseos Regalos");
        model.addAttribute("listaDeseosMueble", listaDeseosMueble);
        return "listaDeseosMueble-form";
    }

    @GetMapping("/listaDeseosMueble/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/listaDeseosMueble/list";
    }



}
