package excecoes;

public class DomainException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msn){
		super(msn);
	}
}
