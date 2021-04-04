package br.com.alura.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManegar;

    public CategoriaDao(EntityManager em) {
        this.entityManegar = em;
    }

    public void cadastrar(Categoria categoria) {
        entityManegar.persist(categoria);
    }
}
