package com.github.lucasjalves.livrosshop.core.facade.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.core.facade.Facade;
import com.github.lucasjalves.livrosshop.core.repository.AbstractRepository;
import com.github.lucasjalves.livrosshop.core.util.ClassCreatorUtil;
import com.github.lucasjalves.livrosshop.core.util.DatabaseUtil;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import org.reflections.Reflections;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.*;

public final class FacadeImpl implements Facade {

    private Map<String, AbstractRepository> repositories = new HashMap<>();


    private Set<Class<? extends AbstractRepository>> classesRepositorios =
            new Reflections().getSubTypesOf(AbstractRepository.class);

    private final static FacadeImpl INSTANCE = new FacadeImpl();

    private <T> T noCast(Object object){
        return (T)object;
    }

    private FacadeImpl()
    {
        classesRepositorios.forEach(repository -> {
            ParameterizedType parameterizedType = noCast(repository.getGenericSuperclass());
            Type actualType = parameterizedType.getActualTypeArguments()[0];
            try {
                repositories.put(actualType.getTypeName(), repository.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }

    public static FacadeImpl getInstance()
    {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Connection connection = DatabaseUtil.addConnection("jdbc:mysql://localhost/livrosdb?useSSL=false", "root", "");
        ClassCreatorUtil.createClasses(DatabaseUtil.scanTables(connection));
    }
    @Override
    public Resultado consultar(Object o) {
        return null;
    }

    @Override
    public Resultado atualizar(Object o) {
        return null;
    }

    @Override
    public Resultado deletar(Object o) {
        return null;
    }

    @Override
    public Resultado salvar(Object object) {
        AbstractEntidade entidade = noCast(object);
        repositories.get(object.getClass().getName()).salvar(entidade);
        return null;
    }
}
