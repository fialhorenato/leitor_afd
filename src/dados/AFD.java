package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AFD {
	private static int inicial;
	private static int[] finais;
	private static List<Estado> listadetransicoes;

	public static void lerAfd(String afdfile) {
		try {

			File afd = new File(afdfile);
			Reader in = new FileReader(afd);
			LineNumberReader reader = new LineNumberReader(in);

			reader.readLine();

			inicial = Integer.parseInt(reader.readLine().replace("i: ", ""));

			String[] vetorestadosfinais = reader.readLine().replace("F: ", "")
					.trim().split(" ");

			finais = new int[vetorestadosfinais.length];
			for (int i = 0; i < vetorestadosfinais.length; i++) {
				finais[i] = Integer.parseInt(vetorestadosfinais[i]);
			}

			reader.readLine();
			listadetransicoes = new ArrayList<Estado>();
			listadetransicoes = ListaTransicoes(reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<Estado> ListaTransicoes(LineNumberReader arquivo) {
		int fim = 0;
		List<Estado> transicoes = new ArrayList<Estado>();

		while (fim == 0) {
			String transicao = null;
			try {
				transicao = arquivo.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (transicao != null) {
				String a, b, c;
				a = transicao.charAt(4) + "";
				b = transicao.charAt(0) + "";
				c = transicao.charAt(2) + "";
				Estado x = new Estado(Integer.parseInt(a), Integer.parseInt(b),
						Integer.parseInt(c));
				transicoes.add(x);
			} else {
				fim = 1;
			}
		}

		return transicoes;
	}

	public static void reconhece(String entrada) {
		File afd = new File(entrada);
		Reader in;
		PrintWriter gravarArq = null;
		try {
			gravarArq = new PrintWriter("saida.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			in = new FileReader(afd);
			BufferedReader reader = new LineNumberReader(in);

			while (reader.ready()) {
				int estadoAtual = inicial;
				String str = reader.readLine();

				for (char ch : str.toCharArray()) {

					String a = "" + ch;
					int recebido = Integer.parseInt(a);

					for (Estado x : listadetransicoes) {
						if (recebido == x.getEstadoInicial()
								&& estadoAtual == x.getEstadoAtual()) {
							estadoAtual = x.getEstadoProximo();
							break;
						}
					}

				}

				String resultado = "";

				for (int i = 0; i < finais.length; i++) {
					if (estadoAtual == finais[i]) {
						resultado = "Aceita";
					} else if (resultado == "") {
						resultado = "Rejeita";
					}
				}

				gravarArq.printf(resultado + "\n");

				System.out.println(resultado);
			}
			gravarArq.close();
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
