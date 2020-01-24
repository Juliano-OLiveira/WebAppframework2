
package com.petsho.util;

import com.petsho.model.Cliente;
import com.petsho.repository.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("frameworks");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Clientes clientes = new Clientes(em);
        List<Cliente> listaDeCLientes = clientes.pesquisarTodos();  
        
        Cliente c = new Cliente();
        c.setNome("Juliano Oliveira");
        c.setEndereco("Benjamim Domingues");
        c.setCPF("037.876.651.10");
       
        
        
        clientes.salvar(c);
        
        
        em.getTransaction().commit();
        em.close();
        em.close();
        
        
    }
}
