package com.github.lucasjalves.livrosshop.core.repository;

import com.github.lucasjalves.livrosshop.core.util.ConexaoUtil;
import com.github.lucasjalves.livrosshop.core.util.StringGenerator;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AbstractRepository implements Repository {
    protected Connection conn;
    public void openConnection()
    {
        conn = ConexaoUtil.addConnection("jdbc:mysql://localhost/livrosdb?useSSL=false", "root", "");
    }



    protected PreparedStatement prepareStatement(AbstractEntidade entidade, PreparedStatement pst, Field[] atributosArray)
    {
        Class<?> classeEntidade = null;
        Class<?> classePreparedStatement = null;
        Class<?>[] tiposParametroPst = new Class<?>[2];
        String nomeMetodoPst = null;

        tiposParametroPst[0] = Integer.TYPE;
        int i = 0;
        try {
            classeEntidade  = Class.forName(entidade.getClass().getName());
            classePreparedStatement = Class.forName(PreparedStatement.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Field atributo: atributosArray)
        {

            try {
                i++;

                String nomeMetodoEntidade = StringGenerator.gerarNomeMetodoGetSet(atributo, "get");
                if(atributo.getType().isPrimitive())
                {
                    nomeMetodoPst = "set" + atributo.getType().getSimpleName().substring(0, 1).toUpperCase() + atributo.getType().getSimpleName().substring(1);
                }
                else
                {
                    nomeMetodoPst = "set" + atributo.getType().getSimpleName();
                }

                tiposParametroPst[1] = atributo.getType();

                Method metodoEntidade = classeEntidade.getMethod(nomeMetodoEntidade);
                Method metodoPst = classePreparedStatement.getDeclaredMethod(nomeMetodoPst, tiposParametroPst);

                metodoPst.invoke(pst, i, metodoEntidade.invoke(entidade));

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return pst;
    }

    public String buildQueryInsert(Field[] fields, String tableName) {
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
