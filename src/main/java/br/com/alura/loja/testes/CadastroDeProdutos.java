package br.com.alura.loja.testes;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProdutos {


    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.create();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.salva(celular);
        em.getTransaction().commit();
        em.close();
    }
}
