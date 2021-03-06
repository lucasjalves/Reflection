package com.github.lucasjalves.livrosshop.web.viewhelper;


import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ViewHelper<T>  {
	T getEntidades(HttpServletRequest request);
	void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response);
	
}	
