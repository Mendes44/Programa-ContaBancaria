package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entre com as informações da conta:");
			System.out.print("Numero da Conta: ");
			Integer number = sc.nextInt();
			System.out.print("Titular da Conta: ");
			sc.next();
			String titular = sc.nextLine();
			System.out.print("Saldo Inicial: ");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de Saque: ");
			Double limiteSaque = sc.nextDouble();
			
			Account conta = new Account(number,titular,saldo,limiteSaque);
					
			System.out.println();
			System.out.print("Entre com valor para sacar: ");
			Double valorSaque = sc.nextDouble();

			conta.saque(valorSaque);
			System.out.println(conta);
		}
		catch(RuntimeException erro) {
			System.out.println("::::::::: ERRO INESPERADO! :::::::");
		}
		catch(DomainException erro) {
			System.out.println(erro.getMessage());
		}
		
		sc.close();
	}

}
