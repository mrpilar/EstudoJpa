package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidade.Cliente;
import entidade.Contato;
import util.JpaUtil;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public boolean inserir(Object obj) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction ts = ent.getTransaction();
		ts.begin();

		ent.persist(obj);

		ts.commit();
		ent.close();

		return true;
	}

	@Override
	public boolean alterar(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction ts = ent.getTransaction();

		Cliente clienteBase = ent.find(Cliente.class, cliente.getCpf());

		if (clienteBase != null) {

			ts.begin();

			clienteBase.setIdade(cliente.getIdade());
			clienteBase.setInteresse(cliente.getInteresse());
			clienteBase.setNome(cliente.getNome());
			clienteBase.setSexo(cliente.getSexo());

			ent.merge(clienteBase);

			ts.commit();
			ent.close();

			return true;
		} else {
			ent.close();
			return false;
		}
	}

	@Override
	public boolean remover(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction ts = ent.getTransaction();

		Cliente clienteBase = ent.find(Cliente.class, cliente.getCpf());

		if (clienteBase != null) {

			ts.begin();

			ent.remove(clienteBase);

			ts.commit();
			ent.close();

			return true;
		} else {
			ent.close();
			return false;
		}
	}

	@Override
	public Cliente pesquisar(String cpf) {

		EntityManager ent = JpaUtil.getEntityManager();
		Cliente retorno = ent.find(Cliente.class, cpf);
		ent.close();
		return retorno;
	}

	@Override
	public List<Cliente> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		String sql = "Select cl from Cliente cl";

		TypedQuery<Cliente> query = ent.createQuery(sql, Cliente.class);

		List<Cliente> listaClientes = query.getResultList();

		ent.close();

		return listaClientes;
	}

	@Override
	public Contato pesquisarContato(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		Contato retorno = ent.find(Contato.class, id);
		ent.close();
		return retorno;
	}

	@Override
	public boolean removerContato(Contato contato) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction ts = ent.getTransaction();

		Contato contatoBase = ent.find(Contato.class, contato.getId());

		if (contatoBase != null) {

			ts.begin();

			contatoBase.setCliente(null);
			ent.remove(contatoBase);

			ts.commit();
			ent.close();

			return true;
		} else {
			ent.close();
			return false;
		}
	}

}
