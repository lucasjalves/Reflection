package com.github.lucasjalves.livrosshop.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MethodSelectorUtil {
    private MethodSelectorUtil(){}

    public static Object generateMethod(Field atributo, String atributoRequisicao )
    {
        Object o = null;
        Class<?> classe = null;
        if(atributo.getType().isPrimitive()) {
            String nomeMetodo = atributo.getType().getSimpleName().substring(0, 1).toUpperCase() + atributo.getType().getSimpleName().substring(1);
            String nomeClasse;
            if(atributo.getType().getCanonicalName().equals("int"))
            {
                nomeClasse = "java.lang.Integer";
            }
            else
            {
                nomeClasse = "java.lang." + nomeMetodo;
            }
            System.out.println(nomeClasse);
            System.out.println(nomeMetodo);
            nomeMetodo = "valueOf";
            try {
                classe = Class.forName(nomeClasse);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Method metodoConversao = classe.getDeclaredMethod(nomeMetodo, String.class);

                o = metodoConversao.invoke(classe, atributoRequisicao);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        else
        {
            return atributoRequisicao;
        }
        return o;
    }
}
