package com.github.lucasjalves.livrosshop.core.util;

import java.lang.reflect.Field;

public final class StringGenerator {
	private StringGenerator() {
		
	}
	public static String gerarNomeMetodoGetSet(Field atributo, String tipo)
	{
		return tipo + atributo.getName().substring(0, 1).toUpperCase() + atributo.getName().substring(1); 
	}

	public static String firstUpperCase(String nome)
	{
		return nome.substring(0,1).toUpperCase() + nome.substring(1);
	}
}
