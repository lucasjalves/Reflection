package com.github.lucasjalves.livrosshop.web.command.impl;


import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import com.github.lucasjalves.livrosshop.web.command.AbstractCommand;

public class ConsultarCommand extends AbstractCommand {

	public Resultado executar(Object object)
    {
		return facade.consultar(object);
	}
}
