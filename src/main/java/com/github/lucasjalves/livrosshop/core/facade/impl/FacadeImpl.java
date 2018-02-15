package com.github.lucasjalves.livrosshop.core.facade.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.core.facade.Facade;
import com.github.lucasjalves.livrosshop.core.repository.AbstractRepository;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import org.reflections.Reflections;
import java.lang.reflect.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacadeImpl implements Facade<AbstractEntidade> {


    private Map<String, AbstractRepository> repositories = new HashMap<>();

    private List<Class<? extends AbstractRepository>> classesRepositorios =
            new ArrayList<>(new Reflections().getSubTypesOf(AbstractRepository.class));

    
    public FacadeImpl()
    {
        classesRepositorios.forEach( n -> {
            System.out.println( (Class<?>)((ParameterizedType)
            n.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[0]);
        });


    }


    public static void main(String[] args) {
        new FacadeImpl();
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
    public Resultado consultar(AbstractEntidade abstractEntidade) {
        return null;
    }
}
