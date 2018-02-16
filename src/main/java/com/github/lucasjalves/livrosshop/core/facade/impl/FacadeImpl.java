package com.github.lucasjalves.livrosshop.core.facade.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.core.facade.Facade;
import com.github.lucasjalves.livrosshop.core.repository.AbstractRepository;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import org.reflections.Reflections;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacadeImpl implements Facade {

    private Map<String, AbstractRepository> repositories = new HashMap<>();


    private List<Class<? extends AbstractRepository>> classesRepositorios = new ArrayList<>(new Reflections().getSubTypesOf(AbstractRepository.class));

    public FacadeImpl()
    {
        classesRepositorios.forEach(n -> {
            ParameterizedType parameterizedType = (ParameterizedType) n.getGenericSuperclass();
            Type actualType = parameterizedType.getActualTypeArguments()[0];
            try {
                repositories.put(actualType.getTypeName(), n.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public Resultado atualizar(AbstractEntidade entidade) {

        return null;
    }
    @Override
    public Resultado deletar(AbstractEntidade entidade) {

        return null;
    }
    @Override
    public Resultado salvar(AbstractEntidade entidade) {
        repositories.get(entidade.getClass().getName()).salvar(entidade);

        return null;
    }

    @Override
    public Resultado consultar(AbstractEntidade entidade) {

        return null;
    }

}
