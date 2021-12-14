package estacionamento.br.com.devinhouse.entidades;

import java.time.LocalTime;

public class Moto extends Veiculo {
	private final double FATOR_ESTACIONAMENTO = 0.85;

	public Moto(String placa, LocalTime horaEntrada) {
		super(placa, horaEntrada);
		this.setFatorEstacionamento(FATOR_ESTACIONAMENTO);
	}
}
