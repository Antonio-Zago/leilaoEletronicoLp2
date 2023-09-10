package com.fatec.leilaoEletronicoLp2.dtos;

import com.fatec.leilaoEletronicoLp2.models.TiposVeiculos;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;

import java.util.Date;

public class VeiculosForm {

    private String veiPlaca;

    private String veiMarca;

    private Integer veiAnoFabricacao;

    private Double veiDistanciaRodada;

    private String veiCambio;

    private String veiCombustivel;

    private String veiCor;

    private Double veiPeso;


    private Integer tipoVeiculo;
    
    private Integer leilao;
    
    


    public Integer getLeilao() {
		return leilao;
	}

	public void setLeilao(Integer leilao) {
		this.leilao = leilao;
	}

	public String getVeiPlaca() {
        return veiPlaca;
    }

    public void setVeiPlaca(String veiPlaca) {
        this.veiPlaca = veiPlaca;
    }

    public String getVeiMarca() {
        return veiMarca;
    }

    public void setVeiMarca(String veiMarca) {
        this.veiMarca = veiMarca;
    }

    public Integer getVeiAnoFabricacao() {
        return veiAnoFabricacao;
    }

    public void setVeiAnoFabricacao(Integer veiAnoFabricacao) {
        this.veiAnoFabricacao = veiAnoFabricacao;
    }

    public Double getVeiDistanciaRodada() {
        return veiDistanciaRodada;
    }

    public void setVeiDistanciaRodada(Double veiDistanciaRodada) {
        this.veiDistanciaRodada = veiDistanciaRodada;
    }

    public String getVeiCambio() {
        return veiCambio;
    }

    public void setVeiCambio(String veiCambio) {
        this.veiCambio = veiCambio;
    }

    public String getVeiCombustivel() {
        return veiCombustivel;
    }

    public void setVeiCombustivel(String veiCombustivel) {
        this.veiCombustivel = veiCombustivel;
    }

    public String getVeiCor() {
        return veiCor;
    }

    public void setVeiCor(String veiCor) {
        this.veiCor = veiCor;
    }

    public Double getVeiPeso() {
        return veiPeso;
    }

    public void setVeiPeso(Double veiPeso) {
        this.veiPeso = veiPeso;
    }

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }


}
