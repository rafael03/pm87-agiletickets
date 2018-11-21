package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.precos.CalculaPreco;
import br.com.caelum.agiletickets.domain.precos.CalculaPrecoBallet;
import br.com.caelum.agiletickets.domain.precos.CalculaPrecoCinema;
import br.com.caelum.agiletickets.domain.precos.CalculaPrecoOquestra;
import br.com.caelum.agiletickets.domain.precos.CalculaPrecoShow;
import br.com.caelum.agiletickets.domain.precos.CalculaPrecoTeatro;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public CalculaPreco calculador() {
			// TODO Auto-generated method stub
			return new CalculaPrecoCinema();
		}
	}, SHOW {
		@Override
		public CalculaPreco calculador() {
			// TODO Auto-generated method stub
			return new CalculaPrecoShow();
		}
	}, TEATRO {
		@Override
		public CalculaPreco calculador() {
			// TODO Auto-generated method stub
			return new CalculaPrecoTeatro();
		}
	}, BALLET {
		@Override
		public CalculaPreco calculador() {
			// TODO Auto-generated method stub
			return new CalculaPrecoBallet();
		}
	}, ORQUESTRA {
		@Override
		public CalculaPreco calculador() {
			// TODO Auto-generated method stub
			return new CalculaPrecoOquestra();
		}
	};
	
	public abstract CalculaPreco calculador();
	
	public CalculaPreco getCalculadorDePreco() {
		return this.calculador();
	}
	
}
