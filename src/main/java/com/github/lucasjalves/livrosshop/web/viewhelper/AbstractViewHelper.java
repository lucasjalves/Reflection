package com.github.lucasjalves.livrosshop.web.viewhelper;

import com.github.lucasjalves.livrosshop.core.util.MethodSelectorUtil;
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
        Method metodoClasse;

        String nomeMetodoClasse;
        Object atributoRequisicao = null;

        try {
            classe  = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Field atributo: todosAtributos)
        {
            try {
                nomeMetodoClasse = StringGenerator.gerarNomeMetodoGetSet(atributo, "set"); // gera o nome do metodo da classe de entidade

                metodoClasse = classe.getDeclaredMethod(nomeMetodoClasse, atributo.getType());
                atributoRequisicao = MethodSelectorUtil.generateMethod(atributo, request.getParameter("txt" + atributo.getName()));

                metodoClasse.invoke(entidade, atributoRequisicao); //chama o metodo set da classe e atribui o retorno do getParameter
            } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return entidade;
    }
}
