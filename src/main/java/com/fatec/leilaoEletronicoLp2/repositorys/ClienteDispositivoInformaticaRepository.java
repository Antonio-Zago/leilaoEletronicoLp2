package com.fatec.leilaoEletronicoLp2.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;

@Repository
public interface ClienteDispositivoInformaticaRepository extends JpaRepository<ClienteDispositivoInformatica, Integer>{

}
