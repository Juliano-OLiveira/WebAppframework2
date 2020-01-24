package br.petshop.services;

import com.petsho.model.Cliente;
import com.petsho.repository.Clientes;
import com.petsho.util.Transacional;
import javax.inject.Inject;

public class ClientesService {

    @Inject
    private Clientes clientes;
    
    @Transacional
    public void salvar(Cliente cliente){
    clientes.salvar(cliente);
    
    }
    
    @Transacional
    public void excluir(Cliente cliente){
    clientes.excluir(cliente);
    
    }
}
