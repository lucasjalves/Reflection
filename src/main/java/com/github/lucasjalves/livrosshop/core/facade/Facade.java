package com.github.lucasjalves.livrosshop.core.facade;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

public interface Facade<T> {
    Resultado consultar(T t);
    Resultado atualizar(T t);
    Resultado deletar(T t);
    Resultado salvar(T t);
}
