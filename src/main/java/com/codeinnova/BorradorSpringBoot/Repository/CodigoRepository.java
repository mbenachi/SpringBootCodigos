package com.codeinnova.BorradorSpringBoot.Repository;

import com.codeinnova.BorradorSpringBoot.Entities.Codigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigoRepository extends JpaRepository <Codigo, Long> {

}
