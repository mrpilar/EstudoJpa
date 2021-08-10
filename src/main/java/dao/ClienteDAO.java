package dao;

import java.util.List;

import entidade.Cliente;
import entidade.Contato;

public interface ClienteDAO {

	public boolean inserir(Object obj);
	
	public boolean alterar(Cliente cliente);
	
	public boolean remover(Cliente cliente);
	
	public Cliente pesquisar(String cpf);
	
	public List<Cliente> listarTodos();
	
	public Contato pesquisarContato(int id);
	
	public boolean removerContato(Contato contato);
}
