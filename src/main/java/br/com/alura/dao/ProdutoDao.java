package br.com.alura.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

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

    public List<Produto> buscarPorTodos() {
        String jpql = "select p from Produto p";
        return this.entityManegar.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "select p from Produto p where p.nome = :nome";
        return this.entityManegar.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPoNomeDaCategoria(String nome) {
        String jpql = "select p from Produto p where p.categoria.nome = :nome";
        return this.entityManegar.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoPorNome(String nome) {
        String jpql = "select p.preco from Produto p where p.nome = :nome";
        return this.entityManegar.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
