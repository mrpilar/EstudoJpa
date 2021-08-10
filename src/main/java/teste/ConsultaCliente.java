package teste;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;
import util.JpaUtil;

public class ConsultaCliente {

	public static void main(String[] args) {

		EntityManager ent = JpaUtil.getEntityManager();

		ClienteDAO clienteDAO = new ClienteDAOImpl();

		String jpql = "SELECT cl FROM Cliente cl";

		ent.createQuery(jpql).getResultList();

		List<Cliente> listaClientes = clienteDAO.listarTodos();

		for (Cliente cl : listaClientes) {
			System.out.println("CPF: " + cl.getCpf() + " -- " + "Nome: " + cl.getNome());

			System.out.println("===========================================");

			if (cl.getListaContatos() != null && cl.getListaContatos().size() > 0) {
				for (Contato ct : cl.getListaContatos()) {
					System.out.println("Id: " + ct.getId() + " E-mail: " + ct.getEmail() + " - " + "Telefone: " + ct.getTelefone());
					System.out.println("===========================================");
				}

			}

		}

	}
}
