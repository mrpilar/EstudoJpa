package teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import entidade.Contato;
import util.JpaUtil;

public class TesteBancoJPA {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Cleiton Aguiar");
		cliente.setCpf("111111");
		cliente.setSexo("Masculino");
		cliente.setIdade(36);
		cliente.setInteresse("Todos de todos");
		
		Contato c1 = new Contato();
		c1.setEmail("email@email.com");
		c1.setCliente(cliente);
		
		Contato c2 = new Contato();
		c2.setTelefone("(81) 9999-6633");
		c2.setCliente(cliente);
		
		cliente.setListaContatos(new ArrayList<Contato>());
		
		cliente.getListaContatos().add(c1);
		cliente.getListaContatos().add(c2);

	// Bloco de persistencia de dados	INSERIR
		
//		EntityTransaction tr = ent.getTransaction();
//		tr.begin();
//		
//		ent.persist(cliente);
//		
//		tr.commit();
//		ent.close();
//		
//		System.out.println("=== salvo ===");
		
		
	// consultar via query
		
		String sql = "Select cl from Cliente cl";

		Query query = ent.createQuery(sql);

		List<Cliente> listaClientes = query.getResultList();

		ent.close();
		
		for (Cliente cliente2 : listaClientes) {
			System.out.println(cliente2.getCpf() +" -- "+ cliente2.getNome());
			for (Contato contato : cliente2.getListaContatos()) {
				System.out.println(contato.getEmail() +" - "+ contato.getTelefone());
			}
		}
		
	}

}
