package com.fatec.leilaoEletronicoLp2.repositorys;

import com.fatec.leilaoEletronicoLp2.controllers.EntidadesFinanceirasController;
import com.fatec.leilaoEletronicoLp2.models.EntidadeFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntidadesFinanceirasRepository extends JpaRepository <EntidadeFinanceira,Integer> {


}


