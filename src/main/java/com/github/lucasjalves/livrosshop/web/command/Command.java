package com.github.lucasjalves.livrosshop.web.command;


import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

public interface Command<T> {
	Resultado executar(T t);
}
