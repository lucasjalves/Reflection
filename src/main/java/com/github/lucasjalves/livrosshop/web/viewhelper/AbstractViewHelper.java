package com.github.lucasjalves.livrosshop.web.viewhelper;

import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import net.vidageek.mirror.dsl.Mirror;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;

import static com.github.lucasjalves.livrosshop.core.util.MethodSelectorUtil.*;

public abstract class AbstractViewHelper implements ViewHelper {
    protected AbstractEntidade getParameters(List<Field> todosAtributos,
                                             AbstractEntidade entidade, HttpServletRequest request)
    {
        todosAtributos.forEach(atributo -> {
            Object atributoRequisicao = generateMethod(atributo, request.getParameter("txt" + atributo.getName()));

            new Mirror().on(entidade).invoke().setterFor(atributo).withValue(atributoRequisicao);
        });
        return entidade;
    }
}
