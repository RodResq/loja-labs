package br.com.alura.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private final EntityManager entityManegar;

    public ProdutoDao(EntityManager em) {
        this.entityManegar = em;
    }

    public void cadastrar(Produto produto) {
        entityManegar.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.entityManegar.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.entityManegar.merge(produto);
        this.entityManegar.remove(produto);
    }

    public Produto buscarPorId(long id) {
        return this.entityManegar.find(Produto.class, id);
    }
}
