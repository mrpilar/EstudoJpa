package teste;

import javax.persistence.EntityManager;

import util.JpaUtil;

public class TesteConexao {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		System.out.println(ent.isOpen());
	}

}
