package com.fatec.leilaoEletronicoLp2.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Leilao;

import java.util.List;

@Repository

public interface LeilaoRepository extends JpaRepository<Leilao, Integer>{

	
	@Query(value = "SELECT DISTINCT DI.* " +
	           "FROM DISPOSITIVOS_INFORMATICA DI " +
	           "INNER JOIN (SELECT CLIDI_VALOR_LANCE, DISPOSITIVO_INFORMATICA, MIN(CLIDI_DATA_HORA_LANCE) AS DATALANCEINICIAL " +
	           "FROM CLIENTE_DISPOSITIVO_INFORMATICA GROUP BY DISPOSITIVO_INFORMATICA, CLIDI_VALOR_LANCE) LANCE " +
	           "ON LANCE.DISPOSITIVO_INFORMATICA = DI.DI_ID " +
	           "INNER JOIN CLIENTE_DISPOSITIVO_INFORMATICA CLIDI ON CLIDI.DISPOSITIVO_INFORMATICA = DI.DI_ID " +
	           "INNER JOIN LEILAO LEI ON LEI.LEI_ID = DI.LEILAO " +
	           "WHERE LEI.LEI_ID = ?1 " +
	           "AND LANCE.CLIDI_VALOR_LANCE >= ?2 AND LANCE.CLIDI_VALOR_LANCE <= ?3 " +
	           "AND CLIDI.CLIDI_VALOR_LANCE >= ?4 AND CLIDI.CLIDI_VALOR_LANCE <= ?5 "+ 
	           "AND DI.TIPO_DI = ?6 "+ 
	           "AND DI.DI_MARCA LIKE %?7% ", nativeQuery = true)		
	List<DispositivoInformatica> findAllWithParam(Integer id, Double valorMinimoInicial,Double valorMaximoInicial,Double valorMinimo,Double valorMaximo, Integer tipoProduto,String nome);
	
    //List<Leilao> findByLanceInicialBetween(Double valorMinimo, Double valorMaximo);



    //List<Leilao> findByValorTotalBetween(Double valorMinimo, Double valorMaximo);

    //List<Leilao> findByNomeDoProdutoContendo(String palavraChave);


    //List<Leilao> findByTipoDeProduto(String tipoDeProduto);

    //List<Leilao> findByTipoDeProduto(String tipoDeProduto);

	
}
