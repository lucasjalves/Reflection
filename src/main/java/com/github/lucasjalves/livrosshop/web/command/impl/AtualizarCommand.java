package com.github.lucasjalves.livrosshop.web.command.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.web.command.AbstractCommand;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

public class AtualizarCommand extends AbstractCommand {

	public Resultado executar(Object object)
	{
		return facade.atualizar(object);
	}
	
}
