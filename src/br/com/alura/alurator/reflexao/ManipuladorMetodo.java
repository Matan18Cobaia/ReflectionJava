package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ManipuladorMetodo {

  private final Object instancia;
  private final Method metodo;
  private final Map<String, Object> params;
  private BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;

  public ManipuladorMetodo(final Object instancia, final Method metodo, final Map<String, Object> params) {
    this.instancia = instancia;
    this.metodo = metodo;
    this.params = params;
  }

  public Object invoca() {
    List<Object> parametros = new ArrayList<>();
    Stream.of(metodo.getParameters()).forEach(p -> parametros.add(params.get(p.getName())));
    try {
      return metodo.invoke(instancia, parametros.toArray());
    } catch (IllegalAccessException | IllegalArgumentException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      if (tratamentoExcecao != null) {
        return tratamentoExcecao.apply(metodo, e);
      }
      e.printStackTrace();
      throw new RuntimeException("Erro dentro do metodo!", e);
    }
  }

  public ManipuladorMetodo comTratamentoDeExcecao(
      BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao) {
    this.tratamentoExcecao = tratamentoExcecao;
    return this;
  }
}
