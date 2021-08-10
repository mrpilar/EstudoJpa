package teste;

import java.util.List;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;

public class ConsultaCliente {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAOImpl();

		List<Cliente> listaClientes = clienteDAO.listarTodos();

		for (Cliente cl : listaClientes) {
			System.out.println("CPF: " + cl.getCpf() + " -- " + "Nome: " + cl.getNome());

			System.out.println("===========================================");

			if (cl.getListaContatos() != null && cl.getListaContatos().size() > 0) {
				for (Contato ct : cl.getListaContatos()) {
					System.out.println("Id: " + ct.getId() + " E-mail: " + ct.getEmail() + " - " + "Telefone: "
							+ ct.getTelefone());
					System.out.println("===========================================");
				}

			}

		}

	}

}