package com.seplagpb.recursoshumanos.controller;

import com.seplagpb.recursoshumanos.model.Setor;
import com.seplagpb.recursoshumanos.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/setor")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    // Create
    @PostMapping
    public String criarSetor(@ModelAttribute Setor setor) {
        setorRepository.save(setor);
        return "redirect:/setor";
    }

    // Read
    @GetMapping
    public String listarSetores(Model model) {
        List<Setor> setores = setorRepository.findAll();
        model.addAttribute("setores", setores);
        return "setores"; // Retorne o nome correto do arquivo HTML
    }

    // Read
    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        Optional<Setor> setor = setorRepository.findById(id);
        if (setor.isPresent()) {
            model.addAttribute("setor", setor.get());
            return "setor"; // Retorne o nome correto do arquivo HTML
        } else {
            throw new RuntimeException("Setor não encontrado");
        }
    }

    // Update
    @PutMapping("/{id}")
    public String atualizarSetor(@PathVariable Long id, @ModelAttribute Setor setor) {
        Optional<Setor> setorExistente = setorRepository.findById(id);
        if (setorExistente.isPresent()) {
            setor.setId(id);
            setorRepository.save(setor);
            return "redirect:/setor";
        } else {
            throw new RuntimeException("Setor não encontrado");
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public String excluirSetor(@PathVariable Long id) {
        Optional<Setor> setor = setorRepository.findById(id);
        if (setor.isPresent()) {
            setorRepository.delete(setor.get());
            return "redirect:/setor";
        } else {
            throw new RuntimeException("Setor não encontrado");
        }
    }
}
