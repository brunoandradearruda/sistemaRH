package com.seplagpb.recursoshumanos.view;
import com.seplagpb.recursoshumanos.model.Servidor;
import com.seplagpb.recursoshumanos.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServidorViewController {

    @Autowired
    private ServidorRepository servidorRepository;


    @GetMapping("/servidorlista")
    public String listarServidor(Model model) {
        model.addAttribute("servidor", new Servidor());
        model.addAttribute("servidorlista", servidorRepository.findAll());
        return "servidorListar";

    }

}