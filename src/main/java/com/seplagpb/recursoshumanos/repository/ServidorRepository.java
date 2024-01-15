package com.seplagpb.recursoshumanos.repository;
import com.seplagpb.recursoshumanos.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

}
