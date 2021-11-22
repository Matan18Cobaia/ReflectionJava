package br.com.alura.playground.controle;

import java.util.ArrayList;
import java.util.List;

public class Controle {
	private final List<String> lista = new ArrayList<>();

	public List<String> getLista() {
		lista.add("item 1");
		lista.add("item 2");
		lista.add("item 3");
		return lista;
	}
}
