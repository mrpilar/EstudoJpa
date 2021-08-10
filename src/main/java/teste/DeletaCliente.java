package teste;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;

public class DeletaCliente {
	public static void main(String[] args) {
		
		//EntityManager ent = JpaUtil.getEntityManager();
		//EntityTransaction ts = ent.getTransaction();
		
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente clienteDeletar = new Cliente();
		Cliente cliente = new Cliente();
		
		cliente.setCpf("12345");
		
		clienteDeletar = clienteDAO.pesquisar(cliente.getCpf());

		clienteDAO.remover(clienteDeletar);
	}
}
