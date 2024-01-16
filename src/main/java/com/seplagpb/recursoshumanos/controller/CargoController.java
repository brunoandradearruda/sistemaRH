package com.seplagpb.recursoshumanos.controller;

import com.seplagpb.recursoshumanos.model.Cargo;
import com.seplagpb.recursoshumanos.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public String listarCargos(Model model) {
        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", cargoRepository.findAll());
        return "cargos";
    }


    @GetMapping("/{id}")
    public String getCargo(@PathVariable Long id, Model model) {
        Cargo cargo = cargoRepository.findById(id).orElse(new Cargo());
        model.addAttribute("cargo", cargo);
        return "cargo";
    }

    @PostMapping
    public String adicionarCargo(@ModelAttribute Cargo cargo) {
        cargoRepository.save(cargo);
        return "redirect:/cargo";
    }


    @GetMapping("/editar/{id}")
    public String editarCargo(@PathVariable Long id, Model model) {
        Cargo cargo = cargoRepository.findById(id).orElse(new Cargo());
        model.addAttribute("cargo", cargo);
        return "editar_cargo";
    }

    @PostMapping("/editar/{id}")
    public String atualizarCargo(@PathVariable Long id, @ModelAttribute Cargo cargo) {
        if (cargoRepository.existsById(id)) {
            cargo.setId(id);
            cargoRepository.save(cargo);
            return "redirect:/cargo";
        } else {
            return "redirect:/cargo";
        }
    }

//    @GetMapping("/buscar")
//    public String buscarCargo(@RequestParam Long id, Model model) {
//        Cargo cargo = cargoRepository.findById(id).orElse(null);
//        model.addAttribute("cargo", cargo);
//        return "buscar_cargo";
//    }

    @GetMapping("/excluir/{id}")
    public String excluirCargo(@PathVariable Long id) {
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        }
        return "redirect:/cargo";
    }


    @GetMapping("/cargos/{id}")
    public String detalhesCargo(@PathVariable Long id, Model model) {
        Cargo cargo = cargoRepository.findById(id).orElse(null);

        if (cargo != null) {
            model.addAttribute("cargo", cargo);
            return "cargobusca";
        } else {
            // Lide com a situação em que o cargo não foi encontrado
            return "redirect:/cargos";
        }

    }

}
