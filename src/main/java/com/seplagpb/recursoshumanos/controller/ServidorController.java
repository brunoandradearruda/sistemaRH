package com.seplagpb.recursoshumanos.controller;
import com.seplagpb.recursoshumanos.model.Servidor;
import com.seplagpb.recursoshumanos.model.Setor;
import com.seplagpb.recursoshumanos.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/servidor")
public class ServidorController {

    @Autowired
    private ServidorRepository servidorRepository;

//    //Create
//    @PostMapping
//    public Servidor gravar(@RequestBody Servidor servidor) {
//        return servidorRepository.save(servidor);
//    }


    @PostMapping
    public String adicionarServidor(@ModelAttribute Servidor servidor) {
        servidorRepository.save(servidor);
        return "redirect:/servidor";
    }


    //Read
    @GetMapping
    public String listar(Model model) {
        List<Servidor> servidores = servidorRepository.findAll();
        model.addAttribute("servidores", servidores);
        return "servidor"; // Retorne o nome correto do arquivo HTML
    }

    //Read
    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        Optional<Servidor> servidor = servidorRepository.findById(id);
        if (servidor.isPresent()) {
            model.addAttribute("servidor", servidor.get());
            return "servidor"; // Retorne o nome correto do arquivo HTML
        } else {
            throw new RuntimeException("Servidor não encontrado");
        }
    }

    //Update
    @PutMapping("/{id}")
    public Servidor atualizar(@PathVariable Long id, @RequestBody Servidor servidor) {
        Optional<Servidor> servidorExistente = servidorRepository.findById(id);
        if (servidorExistente.isPresent()) {
            servidor.setId(id);
            return servidorRepository.save(servidor);
        } else {
            throw new RuntimeException("Servidor não encontrado");
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        Optional<Servidor> servidor = servidorRepository.findById(id);
        if (servidor.isPresent()) {
            servidorRepository.delete(servidor.get());
        } else {
            throw new RuntimeException("Servidor não encontrado");
        }
    }

}
