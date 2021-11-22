package br.com.alura.alurator.reflexao;

public class Reflexao {

  public ManipuladorClasse refeleteClasse(String fqn) {
    try {
      Class<?> classe = Class.forName(fqn);
      return new ManipuladorClasse(classe);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

}
