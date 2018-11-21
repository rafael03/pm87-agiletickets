package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoCinema implements CalculaPreco {

	BigDecimal preco;

	@Override
	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public void aplicaPorcentagem(Sessao sessao, Integer quantidade) {
		if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
				/ sessao.getTotalIngressos().doubleValue() <= 0.05) {
			preco = sessao.getPreco().add(
					sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		} else {
			preco = sessao.getPreco();
		}
	}

}
