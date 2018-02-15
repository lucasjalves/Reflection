package com.github.lucasjalves.livrosshop.web.viewhelper.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import com.github.lucasjalves.livrosshop.domain.entities.Livro;
import com.github.lucasjalves.livrosshop.web.viewhelper.AbstractViewHelper;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LivroViewHelper extends AbstractViewHelper {

	@Override
	public AbstractEntidade getEntidades(HttpServletRequest request) {
		Field[] fields = Livro.class.getDeclaredFields();
		Livro l = (Livro) getParameters(fields, new Livro(), request);
		return l;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher d= null;
		d = request.getRequestDispatcher("index.jsp");
		try {
			d.forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
