package com.petsho.repository;

import com.petsho.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Clientes implements Serializable {
    //Responsavel por gerenciar o cilo de vida das Entidades

    @Inject
    private EntityManager em;
    public List<Cliente> pequisarTodos;

    //COnstrutor
    public Clientes() {
    }

    //Recebe por parametro o EntityManager -> Gerenciador
    public Clientes(EntityManager em) {
        this.em = em;
    }

    //localizar cliente por id
    public Cliente porId(Integer id) {
        return em.find(Cliente.class, id);

    }

    public List<Cliente> pesquisarPorNome(String nome) {
         TypedQuery<Cliente> query = em.createQuery("from Cliente where nome like: nome", Cliente.class);
     query.setParameter("nome",nome+"%");
         return query.getResultList();

    }
    public List<Cliente> pesquisarTodos() {
        return em.createQuery("from Cliente", Cliente.class).getResultList();

    }

    //Salvar ou Alterar um cliente
    public Cliente salvar(Cliente cliente){
    return em.merge(cliente);
    
    }
    
    public void excluir(Cliente cliente){
    cliente = porId(cliente.getId());
    em.remove(cliente);
    }

    
}
