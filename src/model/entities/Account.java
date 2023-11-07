package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Account () {
		
	}

	public Account(Integer number, String titular, Double saldo, Double limiteSaque) {

		this.number = number;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposit(Double valor) {
		saldo += valor;
	}
	
	public void saque(Double valor) throws DomainException {
		
		if (valor > limiteSaque) {
			throw new DomainException (" ERRO -> VALOR MAIOR QUE O LIMITE DE SAQUE!");
		}
		else if(saldo < valor) {
			throw new DomainException (" ERRO -> SALDO INSUFICIENTE!");
		}
		
		saldo -= valor;
	}
	
	@Override
	public String toString() {
		return "NOVO SALDO: "
				+ saldo;
	}
}
