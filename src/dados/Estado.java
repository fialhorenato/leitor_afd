package dados;

public class Estado {
	private int estadoInicial;
	private int estadoAtual;
	private int estadoProximo;
	
	public Estado(int estadoInicial, int estadoAtual, int estadoProximo) {
		super();
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoAtual;
		this.estadoProximo = estadoProximo;
	}
	
	public int getEstadoInicial() {
		return estadoInicial;
	}
	
	public void setEstadoInicial(char estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	
	public int getEstadoAtual() {
		return estadoAtual;
	}
	
	public void setEstadoAtual(char estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
	public int getEstadoProximo() {
		return estadoProximo;
	}
	
	public void setEstadoProximo(char estadoProximo) {
		this.estadoProximo = estadoProximo;
	}
	
	public String toString() {
		return estadoAtual + " == " + estadoProximo + " == " + estadoInicial + "\n"; 
	}
	
	
}