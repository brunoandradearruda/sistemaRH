package com.seplagpb.recursoshumanos.view;
import com.seplagpb.recursoshumanos.model.Servidor;
import com.seplagpb.recursoshumanos.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

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



    @GetMapping("/elegiveis-ferias")
    public String listarElegiveisParaFerias(Model model) {
        List<Servidor> todosServidores = servidorRepository.findAll();
        List<Servidor> elegiveisParaFerias = new ArrayList<>();
//        LocalDate hoje = LocalDate.of(2024, 01, 19);
        LocalDate hoje = LocalDate.now();

        for (Servidor servidor : todosServidores) {
            if (servidor.getDataAdmissao() != null) {
                long mesesTrabalhados = Period.between(servidor.getDataAdmissao(), hoje).toTotalMonths();

                if ((mesesTrabalhados >= 12 && (mesesTrabalhados - 12) % 11 == 0) || mesesTrabalhados == 12) {
                    elegiveisParaFerias.add(servidor);
                }
            }
        }

        model.addAttribute("servidoresElegiveis", elegiveisParaFerias);
        return "elegiveis-ferias"; // Nome do arquivo Thymeleaf
    }
}