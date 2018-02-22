package com.github.lucasjalves.livrosshop.core.util;

public final class HtmlGeneratorUtil {
	private HtmlGeneratorUtil(){}
	public static String generateFormField(String texto, String nomeParametro)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<tr><td>");
		sb.append(texto);
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<input type='text' name='");
		sb.append(nomeParametro);
		sb.append("'/>");
		sb.append("</td></tr>");
		
		return sb.toString();
	}
}
