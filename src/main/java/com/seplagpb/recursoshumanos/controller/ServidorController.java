package com.seplagpb.recursoshumanos.controller;

import com.seplagpb.recursoshumanos.model.Cargo;
import com.seplagpb.recursoshumanos.model.Servidor;
import com.seplagpb.recursoshumanos.repository.CargoRepository;
import com.seplagpb.recursoshumanos.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


@Controller
@RequestMapping("/servidor")
public class ServidorController {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private CargoRepository cargoRepository;


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


    @GetMapping("/elegiveis-ferias")
    public String listarElegiveisParaFerias(Model model) {
        List<Servidor> todosServidores = servidorRepository.findAll();
        List<Servidor> elegiveisParaFerias = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (Servidor servidor : todosServidores) {
            if (servidor.getDataAdmissao() != null) {
                long mesesTrabalhados = Period.between(servidor.getDataAdmissao(), hoje).toTotalMonths();
                long mesesAposPrimeiroAno = mesesTrabalhados - 12;

                if (mesesTrabalhados >= 12 && (mesesAposPrimeiroAno % 11 == 0 || mesesAposPrimeiroAno == 0)) {
                    elegiveisParaFerias.add(servidor);
                }
            }
        }

        model.addAttribute("servidoresElegiveis", elegiveisParaFerias);
        return "elegiveis-ferias";
    }


//    @GetMapping("/servidorCadastro")
//    public String prepararFormularioServidor(Model model) {
//        List<Cargo> cargos = cargoRepository.findAll();
//        model.addAttribute("cargos", cargos); // Lista para o combobox
//        // Aqui você pode adicionar outras informações necessárias para a página
//        return "servidor"; // Nome da view que contém o formulário de servidor
//    }


}
