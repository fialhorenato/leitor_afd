package dados;

public class Usuario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String afd = args[0];
		String entrada = args[1];
		AFD.lerAfd(afd);
		AFD.reconhece(entrada);
	}

}
