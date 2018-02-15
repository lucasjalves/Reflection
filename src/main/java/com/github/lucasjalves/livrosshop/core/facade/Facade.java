package com.github.lucasjalves.livrosshop.core.facade;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

public interface Facade {
    Resultado consultar(AbstractEntidade entidade);
    Resultado atualizar(AbstractEntidade entidade);
    Resultado deletar(AbstractEntidade entidade);
    Resultado salvar(AbstractEntidade entidade);
}
