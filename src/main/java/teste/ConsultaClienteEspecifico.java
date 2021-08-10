package teste;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;

public class ConsultaClienteEspecifico {

	public static void main(String[] args) {
		
	
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		
		Cliente cliente = clienteDAO.pesquisar("89889");
		Contato contato = clienteDAO.pesquisarContato(5);
		
		System.out.println("Nome: " + cliente.getNome() + " E-mail: " 
		+ contato.getEmail() + " Telefone: " + contato.getTelefone());
		

}
}
