package com.fatec.leilaoEletronicoLp2.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.TiposDi;

@Repository
public interface TiposDiRepository extends JpaRepository<TiposDi, Integer>{

}
