package com.github.lucasjalves.livrosshop.core.repository;

import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import java.util.List;

public interface Repository<Entity extends AbstractEntidade> {
    List<Entity> buscar(Entity entidade);
    void atualizar(Entity entidade);
    void deletar(Entity entidade);
    void salvar(Entity entidade);
}
