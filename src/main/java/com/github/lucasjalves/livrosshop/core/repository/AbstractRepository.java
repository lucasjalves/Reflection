package com.github.lucasjalves.livrosshop.core.repository;

import com.github.lucasjalves.livrosshop.core.util.DatabaseUtil;
import net.vidageek.mirror.dsl.Mirror;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import static com.github.lucasjalves.livrosshop.core.util.DatabaseUtil.*;

public abstract class AbstractRepository<AbstractEntidade> implements Repository {
    protected Connection conn;
    public void openConnection()
    {
        conn = addConnection("jdbc:mysql://localhost/livrosdb?useSSL=false", "root", "");
    }



    protected PreparedStatement prepareStatement(AbstractEntidade entidade, PreparedStatement pst, List<Field> atributos)
    {
        atributos.forEach(atributo -> {
            String nomeMetodoPst = null;
            if(atributo.getType().isPrimitive())
            {
                nomeMetodoPst = "set" + atributo.getType().getSimpleName().substring(0, 1).toUpperCase() + atributo.getType().getSimpleName().substring(1);
            } else {
                nomeMetodoPst = "set" + atributo.getType().getSimpleName();
            }
            Object object = new Mirror().on(entidade).invoke().getterFor(atributo);
            new Mirror().on(pst).invoke().method(nomeMetodoPst).withArgs(atributos.indexOf(atributo) + 1, object);
        });
        return pst;
    }

    public String buildQueryInsert(List<Field> fields, String tableName) {
        StringBuilder sql1 = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();

        sql1.append("INSERT INTO " + tableName + " (");
        sql2.append("VALUES (");
        int i = 0;

        for(Field f: fields)
        {
            if(i == 0)
            {
                sql1.append(f.getName() + ",");
                sql2.append("?,");
            }
            if(i == 1)
            {
                sql1.append(f.getName());
                sql2.append("?");
            }
            if(i > 1)
            {
                sql1.append("," +f.getName());
                sql2.append(",?");
            }
            i++;
        }
        sql1.append(")");
        sql2.append(")");
        sql1.append(sql2);

        return sql1.toString();
    }
}
