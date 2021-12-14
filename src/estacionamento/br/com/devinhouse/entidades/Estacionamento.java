package estacionamento.br.com.devinhouse.entidades;

import java.time.LocalTime;
import java.util.ArrayList;

public class Estacionamento {
	private double valorHora;
	private double totalFaturamentoCarro;
	private double totalFaturamentoUtilitario;
	private double totalFaturamentoMoto;
	private double totalFaturamento;
	ArrayList<Veiculo> veiculos;
	
	public Estacionamento(double valorHora) {
		this.valorHora = valorHora;
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	public Veiculo procuraVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	public void darEntrada(String placa, String tipoVeiculo, LocalTime horaEntrada) {
		Veiculo veiculo;
		
		switch(tipoVeiculo) {
		case "carro":
			veiculo = new Carro(placa, horaEntrada);
			break;
		case "utilitario":
			veiculo = new Utilitario(placa, horaEntrada);
			break;
		case "moto":
			veiculo = new Moto(placa, horaEntrada);
			break;
		default:
			veiculo = new Carro(placa, horaEntrada);
		}
		
		this.veiculos.add(veiculo);
	}
	
	public double darSaida(String placa, LocalTime horaSaida) {
		Veiculo veiculo = this.procuraVeiculo(placa);
		
		veiculo.setHoraSaida(horaSaida);
		
		veiculo.calcularValor(valorHora);
		
		if (veiculo instanceof Moto) {
			this.totalFaturamentoMoto += veiculo.getTotalEstacionamento();
		} else if (veiculo instanceof Utilitario) {
			this.totalFaturamentoUtilitario += veiculo.getTotalEstacionamento();
		} else {
			this.totalFaturamentoCarro += veiculo.getTotalEstacionamento();
		}
		
		this.totalFaturamento += veiculo.getTotalEstacionamento();
		
		this.veiculos.remove(veiculo);
		
		return veiculo.getTotalEstacionamento();
	}

	public double getTotalFaturamentoCarro() {
		return totalFaturamentoCarro;
	}

	public void setTotalFaturamentoCarro(double totalFaturamentoCarro) {
		this.totalFaturamentoCarro = totalFaturamentoCarro;
	}

	public double getTotalFaturamentoUtilitario() {
		return totalFaturamentoUtilitario;
	}

	public void setTotalFaturamentoUtilitario(double totalFaturamentoUtilitario) {
		this.totalFaturamentoUtilitario = totalFaturamentoUtilitario;
	}

	public double getTotalFaturamentoMoto() {
		return totalFaturamentoMoto;
	}

	public void setTotalFaturamentoMoto(double totalFaturamentoMoto) {
		this.totalFaturamentoMoto = totalFaturamentoMoto;
	}

	public double getTotalFaturamento() {
		return totalFaturamento;
	}

	public void setTotalFaturamento(double totalFaturamento) {
		this.totalFaturamento = totalFaturamento;
	}
	
	
}
