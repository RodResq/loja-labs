package br.com.alura.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private final EntityManager entityManegar;

    public ProdutoDao(EntityManager em) {
        this.entityManegar = em;
    }

    public void salva(Produto produto) {
        entityManegar.persist(produto);
    }
}
