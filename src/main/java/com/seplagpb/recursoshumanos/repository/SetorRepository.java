package com.seplagpb.recursoshumanos.repository;
import com.seplagpb.recursoshumanos.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
