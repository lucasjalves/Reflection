package com.github.lucasjalves.livrosshop.core.aplicacao;

import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import java.util.ArrayList;
import java.util.List;


public class Resultado {
    private List<AbstractEntidade> entidades = new ArrayList<>();
    private String msg;
    public String getMsg()
    {
        return msg;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    public List<AbstractEntidade> getEntidades()
    {
        return entidades;
    }
    public void setEntidades(List<AbstractEntidade> entidades)
    {
        this.entidades = entidades;
    }
}

