package com.github.lucasjalves.livrosshop.core.repository.impl;

import com.github.lucasjalves.livrosshop.core.repository.AbstractRepository;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import com.github.lucasjalves.livrosshop.domain.entities.Livro;


import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class LivroRepository extends AbstractRepository<Livro> {
    @Override
    public List<AbstractEntidade> buscar(AbstractEntidade entidade) {
        return null;
    }

    @Override
    public void atualizar(AbstractEntidade entidade) {

    }

    @Override
    public void deletar(AbstractEntidade entidade) {

    }

    @Override
    public void salvar(AbstractEntidade entidade) {

        openConnection();
        PreparedStatement pst = null;
        try {
            List<Field> atributos = Arrays.asList(Livro.class.getDeclaredFields());
            String query = buildQueryInsert(atributos, "livros");

            pst = conn.prepareStatement(query);
            pst = prepareStatement((Livro) entidade, pst, atributos);

            pst.executeUpdate();
            System.out.println("commitando no banco...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
