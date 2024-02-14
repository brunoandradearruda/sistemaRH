//package com.seplagpb.recursoshumanos.repository;
//import java.time.LocalDate;
//import java.util.List;
//
//import com.seplagpb.recursoshumanos.model.Ferias;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface FeriasRepository extends JpaRepository<Ferias, Long> {
//    @Query("SELECT f FROM Ferias f WHERE f.servidor.id = :servidorId AND (f.dataInicio <= :dataFim AND f.dataFim >= :dataInicio)")
//    List<Ferias> findFeriasOverlappingWithPeriod(Long servidorId, LocalDate dataInicio, LocalDate dataFim);
//}
