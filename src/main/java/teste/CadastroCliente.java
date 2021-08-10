package teste;

import java.util.ArrayList;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;

public class CadastroCliente {

	public static void main(String[] args) {

		
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		
		Cliente cliente = new Cliente();
		
		Contato contato = new Contato();
		
		cliente.setListaContatos(new ArrayList<Contato>());
		
		cliente.setCpf("12345");
		cliente.setIdade(25);
		cliente.setInteresse("jornais");
		cliente.setNome("Renato Pascoal");
		cliente.setSexo("Masculino");
		
		contato.setCliente(cliente);
		
		contato.setEmail("aaaaaa@gmail.com");
		contato.setTelefone("8888888");
		
		cliente.getListaContatos().add(contato);
		
		clienteDAO.inserir(cliente);

	}

}
