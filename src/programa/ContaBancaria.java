package programa;

import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.ContaCorrente;
import excecoes.DomainException;

public class ContaBancaria {
	static boolean bClienteOK = false;
	static ContaCorrente conta;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean bFazerNovamente = true;
		
		System.out.printf("****************** CONTA BANCÁRIA ************\n\n\n");
		try {
			while (bFazerNovamente) {

				System.out.println("1 - Abrir conta:         ");
				System.out.println("2 - Ver saldo:           ");
				System.out.println("3 - Realizar depósito:   ");
				System.out.println("4 - Realizar saque:      ");
				System.out.println("0 - Sair do sistema:     ");
				System.out.print("Digite o numero da operação desejada: ");
				int opcao = input.nextInt();
				switch (opcao) {
				case 0:
					bFazerNovamente=false;
					break;
				case 1:
					cadstro(input);
					break;
				case 2:	// consultaSaldo();
					System.out.println("********* Consulta ainda não implentada.");
					break;
				case 3:
					if(bClienteOK) {
						System.out.print("entre com o valor do depósito: ");
						double dDeposito = input.nextDouble();
						conta.mDeposito(dDeposito);
					}else {
						throw new DomainException("Não há cliente cadastrado");
					}
					break;
				case 4:
					if(bClienteOK) {
						System.out.print("entre com o valor do saque: ");
						double dSaque = input.nextDouble();
						conta.mSaque(dSaque);
					}else {
						throw new DomainException("Não há cliente cadastrado");
					}
					break;
				default:
					bFazerNovamente = true;
					break;
				}
				System.out.printf("***************************************\n\n\n\n");
			}
		} 
		catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Erro: Dado digitado incorretamente. ");
		}
				
		input.close();
	}
//Metodo de cadastro
	public static void cadstro(Scanner input) throws DomainException {
		System.out.print("Digite o número da conta: ");
		int iNumeroDaConta = input.nextInt();
		System.out.print("Digite o nome do cliente: ");
		String sNomeDoCliente = input.next();
		System.out.println("Deseja fazer um depósito inicial? (s/n) ");
		String op = input.next();
		if (!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n"))) {
			throw new DomainException("Opção inválida!");
		} else if (op.equalsIgnoreCase("s")) {
			System.out.print("Digite o valor do depósito inicial: R$ ");
			double dDeposito = input.nextDouble();
			conta = new ContaCorrente(iNumeroDaConta, sNomeDoCliente, dDeposito);
		} else {
			conta = new ContaCorrente(iNumeroDaConta, sNomeDoCliente);
		}
		bClienteOK=true;
	}
}
