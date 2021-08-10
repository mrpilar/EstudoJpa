package teste;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;

public class AtualizaCliente {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente clienteAlterar = new Cliente();
		Cliente cliente = new Cliente();
		
		cliente.setCpf("12345");
		
		clienteAlterar = clienteDAO.pesquisar(cliente.getCpf());

		clienteAlterar.setNome("Bruno Coxinha");
		
		clienteDAO.alterar(clienteAlterar);

	}

}
