package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
  public static void main(String[] args) throws Exception {
    Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.Controle");

    Constructor<?> contrutorPadrao = controleClasse.getDeclaredConstructor();
    Object controle = contrutorPadrao.newInstance();
    Method m = controleClasse.getDeclaredMethod("metodoControle2");
    Object retorno = m.invoke(controle);
    System.out.println(retorno);
  }
}