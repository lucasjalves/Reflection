package com.github.lucasjalves.livrosshop.core.facade.impl;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.core.facade.Facade;
import com.github.lucasjalves.livrosshop.core.repository.AbstractRepository;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import org.reflections.Reflections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacadeImpl implements Facade {
    int i = 0;
    private Map<String, AbstractRepository> repositories = new HashMap<>();

    private List<Class<? extends AbstractEntidade>> classesEntidades = new ArrayList<>(new Reflections().getSubTypesOf(AbstractEntidade.class));
    private List<Class<? extends AbstractRepository>> classesRepositorios = new ArrayList<>(new Reflections().getSubTypesOf(AbstractRepository.class));

    public FacadeImpl()
    {
        classesEntidades.forEach(n -> {
            try {
                repositories.put(n.getName(), classesRepositorios.get(i).newInstance());
                i++;
            } catch (InstantiationException | IllegalAccessException e) {
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
        System.out.println("Operação salvar... facade");
        System.out.println(entidade.getClass().getName());
        repositories.get(entidade.getClass().getName()).salvar(entidade);

        return null;
    }

    @Override
    public Resultado consultar(AbstractEntidade entidade) {

        return null;
    }

}
