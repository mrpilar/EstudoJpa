package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import util.JpaUtil;

public class AtualizaCliente {

	public static void main(String[] args) {

		EntityManager ent = JpaUtil.getEntityManager();

		EntityTransaction ts = ent.getTransaction();

		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente cliente = new Cliente();

		cliente.setCpf("5678");

		Cliente clienteAtualizar = ent.find(Cliente.class, cliente.getCpf());

		clienteAtualizar.setNome("Paulo de Tarso");
		
		clienteDAO.alterar(clienteAtualizar);

	}

}
