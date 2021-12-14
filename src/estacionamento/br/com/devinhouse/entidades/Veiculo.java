package estacionamento.br.com.devinhouse.entidades;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Veiculo {
	private double fatorEstacionamento;
	private String placa;
	LocalTime horaEntrada;
	LocalTime horaSaida;
	private double totalEstacionamento;
	
	public Veiculo(String placa, LocalTime horaEntrada) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
	}

	public void calcularValor(double valorHora) {
		double tempoPermanencia = (double) this.horaEntrada.until(horaSaida, ChronoUnit.MINUTES) / 60;
		
		this.totalEstacionamento += valorHora * Math.round(tempoPermanencia) * fatorEstacionamento;
	}

	public double getFatorEstacionamento() {
		return fatorEstacionamento;
	}

	public void setFatorEstacionamento(double fatorEstacionamento) {
		this.fatorEstacionamento = fatorEstacionamento;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getTotalEstacionamento() {
		return totalEstacionamento;
	}

	public void setTotalEstacionamento(double totalEstacionamento) {
		this.totalEstacionamento = totalEstacionamento;
	}
	
	
	
}
