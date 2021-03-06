package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoTeatro implements CalculaPreco{
	BigDecimal preco;
	
	@Override
	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public void aplicaPorcentagem(Sessao sessao, Integer quantidade) {
		preco = sessao.getPreco();
	}

}
