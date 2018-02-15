package com.github.lucasjalves.livrosshop.core.facade;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

public interface Facade<T> {
    Resultado consultar(T t);
    Resultado atualizar(AbstractEntidade entidade);
    Resultado deletar(AbstractEntidade entidade);
    Resultado salvar(AbstractEntidade entidade);
}
