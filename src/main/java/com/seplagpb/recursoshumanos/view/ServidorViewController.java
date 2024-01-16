package com.seplagpb.recursoshumanos.view;
import com.seplagpb.recursoshumanos.model.Servidor;
import com.seplagpb.recursoshumanos.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ServidorViewController {

    @Autowired
    private ServidorRepository servidorRepository;

//    @GetMapping("/cargos")
//    public String listarCargos(Model model) {
//        model.addAttribute("cargo", new Cargo());
//        model.addAttribute("cargos", cargoRepository.findAll());
//        return "cargos";
//    }

    @GetMapping("/servidorlista")
    public String listarServidor(Model model) {
        model.addAttribute("servidor", new Servidor());
        model.addAttribute("servidorlista", servidorRepository.findAll());
        return "servidorListar";

    }

//    @GetMapping("/servidorlista")
//    public String listarServidor(Model model) {
//        model.addAttribute("servidor", new Servidor());
//
//        // Obter todos os servidores
//        List<Servidor> servidores = servidorRepository.findAll();
//
//        // Agrupar servidores por setor
//        Map<String, List<Servidor>> servidoresPorSetor = servidores.stream()
//                .collect(Collectors.groupingBy(Servidor::getSetor));
//
//        model.addAttribute("servidoresPorSetor", servidoresPorSetor);
//
//        return "servidorListar";
//    }


}