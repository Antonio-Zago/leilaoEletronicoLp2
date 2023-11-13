package com.fatec.leilaoEletronicoLp2.dtos;



import com.fatec.leilaoEletronicoLp2.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeilaoDetalhesDto {

    private Integer leiId;
    private LocalDateTime leiDataOcorrencia;
    private LocalDateTime leiDataVisitacao;
    private String leiEndereco;
    private String leiCidade;
    private String leiestado;
    private String leiEnderecoWeb;
    private List<String> entidadesFinanceirasNomes;

    // New lists for vehicles, electronic devices, and clients
    private List<Veiculos> veiculos;
    private List<DispositivoInformatica> dispositivosInformatica;
    private List<Cliente> clientes;
    private List<ClienteVeiculos> clientesVeiculos;


    public LeilaoDetalhesDto(Leilao leilao) {
        // Initialize your lists here if needed
    }
}
