package br.com.alura.playground.reflexao;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.playground.controle.*;

public class TesteInstanciaObjeto {

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    Class<Controle> controleClasse1 = Controle.class;
    Controle controle = new Controle();
    Class<? extends Controle> controleClasse2 = controle.getClass();
    Class<?> controleClasse3 = Class.forName("br.com.alura.playground.controle.Controle");

    Object ob1 = controleClasse1.getDeclaredConstructor().newInstance();
    Object ob2 = controleClasse2.getDeclaredConstructor().newInstance();
    Object ob3 = controleClasse3.getDeclaredConstructor().newInstance();

    System.out.println(ob1 instanceof Controle);
    System.out.println(ob2 instanceof Controle);
    System.out.println(ob3 instanceof Controle);
  }
}