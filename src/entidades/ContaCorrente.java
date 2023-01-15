package entidades;

import excecoes.DomainException;

public class ContaCorrente {
	private int iNumeroDaConta;
	private String sTitularDaConta;
	private Double dSaldoDaConta;
	private double dLimiteDeSaque = 300.00;
	
	public ContaCorrente(int iNumeroDaConta,String sNomeDoTitular, double dDeposito) {
		this.iNumeroDaConta = iNumeroDaConta;
		this.sTitularDaConta = sNomeDoTitular;
		this.dSaldoDaConta = dDeposito;
	}
	public ContaCorrente(int iNumeroDaConta,String sNomeDoTitular) {
		this.iNumeroDaConta = iNumeroDaConta;
		this.sTitularDaConta = sNomeDoTitular;
		this.dSaldoDaConta = 0.0;
	}
	
	public void mDeposito(double dValoDoDeposito) {
		this.dSaldoDaConta += dValoDoDeposito;
	}
	
	public void mSaque(double dValorDoSaque) throws DomainException {
		if(dValorDoSaque > dLimiteDeSaque ) {
			throw new DomainException("Valor peretendido superior ao limite diário");
		}else if(dValorDoSaque> dSaldoDaConta) {
			throw new DomainException("Saldo insificiente!");
		}else {
			this.dSaldoDaConta -= dValorDoSaque;
		}
		
	}
}
