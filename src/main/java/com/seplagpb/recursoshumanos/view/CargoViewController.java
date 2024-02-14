package com.seplagpb.recursoshumanos.view;
import com.seplagpb.recursoshumanos.model.Cargo;
//import com.seplagpb.recursoshumanos.model.Setor;
import com.seplagpb.recursoshumanos.repository.CargoRepository;
//import com.seplagpb.recursoshumanos.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CargoViewController {

    @Autowired
    private CargoRepository cargoRepository;
   
//    @Autowired
//    private SetorRepository setorRepository; // Repositório para Setores

    @GetMapping("/cargos")
    public String listarCargos(Model model) {
        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", cargoRepository.findAll());
        return "cargos";
    }

    @GetMapping("/cargoslista")
    public String listarCargo(Model model) {
        List<Cargo> cargos = cargoRepository.findAll();
        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", cargos);
        return "cargoListar";
    }


    @GetMapping("/servidorCadastro")
    public String prepararFormularioServidor(Model model) {
        List<Cargo> cargos = cargoRepository.findAll();
//        List<Setor> setores = setorRepository.findAll(); // Obtém lista de setores

        model.addAttribute("cargos", cargos);

//        model.addAttribute("setores", setores); // Adiciona lista de setores ao modelo

        return "servidor"; // Nome da view que contém o formulário de servidor
    }

}