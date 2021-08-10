package teste;

import java.util.ArrayList;
import java.util.List;

import entidade.Contato;

public class TesteLista {

	public static void main(String[] args) {
		List<Contato> lista = new ArrayList<Contato>();
		
		Contato c1 = new Contato();
		c1.setEmail("email@email");
		
		Contato c2 = new Contato();
		c2.setEmail("eeeeee@email");
		
		Contato c3 = new Contato();
		c3.setTelefone("8255252552525");
		
		Contato c4 = new Contato();
		c4.setTelefone("3333333333333");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		
		Contato achou = null;
		
		for (Contato contato : lista) {
			if(contato.getEmail() != null && 
					contato.getEmail().equals("eeeeee@email")) {
				achou = contato;
			}
//			System.out.println(contato.getEmail() +" - "+ contato.getTelefone() );
		}
		
		lista.remove(achou);
		
//		System.out.println(lista.get(3).getTelefone() + " ==================");
		
		for (int i = 0; i < lista.size(); i++) {
			Contato contato = lista.get(i);
			System.out.println(i + " - "+ contato.getEmail() +" - "+ contato.getTelefone() );
		}

	}

}
