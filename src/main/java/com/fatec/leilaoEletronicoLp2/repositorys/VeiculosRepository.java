package com.fatec.leilaoEletronicoLp2.repositorys;


import com.fatec.leilaoEletronicoLp2.models.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository <Veiculos, Integer> {


}

