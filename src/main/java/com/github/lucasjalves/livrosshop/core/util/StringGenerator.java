package com.github.lucasjalves.livrosshop.core.util;

import java.lang.reflect.Field;

public final class StringGenerator {
	private StringGenerator() {
		
	}
	
	public static String gerarNomeMetodoGetSet(Field atributo, String tipo)
	{
		return tipo + atributo.getName().substring(0, 1).toUpperCase() + atributo.getName().substring(1); 
	}
}
