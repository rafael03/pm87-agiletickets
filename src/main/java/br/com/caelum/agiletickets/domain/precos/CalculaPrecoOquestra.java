package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoOquestra implements CalculaPreco {

	BigDecimal preco;

	@Override
	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public void aplicaPorcentagem(Sessao sessao, Integer quantidade) {
		if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
				/ sessao.getTotalIngressos().doubleValue() <= 0.50) {
			preco = sessao.getPreco().add(
					sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
		} else {
			preco = sessao.getPreco();
		}

		if (sessao.getDuracaoEmMinutos() > 60) {
			preco = preco.add(sessao.getPreco().multiply(
					BigDecimal.valueOf(0.10)));
		}
	}

}
