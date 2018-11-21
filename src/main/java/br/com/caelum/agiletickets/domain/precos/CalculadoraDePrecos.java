package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;

		CalculaPreco calculador = sessao.getEspetaculo().getTipo().getCalculadorDePreco();
		calculador.aplicaPorcentagem(sessao, quantidade);
		BigDecimal precoUnitario = calculador.getPreco();
		
		return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
	}
}