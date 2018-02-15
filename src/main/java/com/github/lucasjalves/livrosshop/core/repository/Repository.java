package com.github.lucasjalves.livrosshop.core.repository;

import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import java.util.List;

public interface Repository {
    List<AbstractEntidade> buscar(AbstractEntidade entidade);
    void atualizar(AbstractEntidade entidade);
    void deletar(AbstractEntidade entidade);
    void salvar(AbstractEntidade entidade);
}
