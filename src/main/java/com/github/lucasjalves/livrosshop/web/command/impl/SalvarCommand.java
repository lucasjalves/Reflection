package com.github.lucasjalves.livrosshop.web.command.impl;


import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import com.github.lucasjalves.livrosshop.web.command.AbstractCommand;

public class SalvarCommand extends AbstractCommand {

	public Resultado executar(AbstractEntidade entidade)
    {
		return facade.salvar(entidade);
	}

}
