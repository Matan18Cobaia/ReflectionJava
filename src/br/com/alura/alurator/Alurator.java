package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private final String pacoteBase;

	public Alurator(final String pacoteBase) {
		this.pacoteBase = pacoteBase;

	}

	public Object executa(final String url) {
		final Request request = new Request(url);
		final String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();
		Object retorno = new Reflexao().refeleteClasse(pacoteBase + nomeControle).criaInstancia()
				.getMetodo(nomeMetodo, params).comTratamentoDeExcecao((metodo, ex) -> {
					System.out.println(
							"Erro do método " + metodo.getName() + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n");
					throw new RuntimeException("Erro no método!");
				}).invoca();

		System.out.println(retorno);
		return retorno;
	}
}
