package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		CalculaPreco evento = null;
		switch(sessao.getEspetaculo().getTipo()) {
		case BALLET:
			evento = new CalculaPrecoBallet();
			break;
		case CINEMA:
			evento = new CalculaPrecoCinema();
			break;
		case ORQUESTRA:
			evento = new CalculaPrecoOquestra();
			break;
		case SHOW:
			evento = new CalculaPrecoShow();
			break;
		case TEATRO:
			evento = new CalculaPrecoTeatro();
			break;
		default:
			break;
		
		}
		
		evento.aplicaPorcentagem(sessao, quantidade);
		preco = evento.getPreco();
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
}