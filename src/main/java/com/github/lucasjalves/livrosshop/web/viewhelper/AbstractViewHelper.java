package com.github.lucasjalves.livrosshop.web.viewhelper;

import com.github.lucasjalves.livrosshop.core.util.StringGenerator;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractViewHelper implements  ViewHelper {
    protected AbstractEntidade getParameters(Field[] todosAtributos, AbstractEntidade entidade, HttpServletRequest request)
    {
        Class<?> classe = null;
        Method method;
        String nomeMetodoClasse;
        String atributoRequisicao;

        try {
            classe  = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        for(Field atributo: todosAtributos)
        {
            try {
                i++;
                nomeMetodoClasse = StringGenerator.gerarNomeMetodoGetSet(atributo, "set"); // gera o nome do metodo da classe de entidade
                if(atributo.getType().isPrimitive())
                {
                    method = classe.getDeclaredMethod(nomeMetodoClasse, atributo.getType());
                }
                else
                {
                    method = classe.getDeclaredMethod(nomeMetodoClasse, String.class); // pega o metodo da classe
                }
                atributoRequisicao = request.getParameter("txt" + atributo.getName());

                method.invoke(entidade, atributoRequisicao); //chama o metodo set da classe e atribui o retorno do getParameter
            } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return entidade;
    }
}
