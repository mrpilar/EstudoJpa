package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;

public class Teste2 {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAOImpl();

		Scanner scNum = new Scanner(System.in);
		Scanner scText = new Scanner(System.in);

		Cliente cliente = new Cliente();
		cliente.setListaContatos(new ArrayList<Contato>());

		int opcao = 0;

		System.out.println("=====Bem-Vindo!====");
		System.out.println("Cadastro de Clientes da Sorveteria Igarapé");
		System.out.println("Qual operação você deseja realizar: ");

		do {
			System.out.println("=====================================================");
			System.out.println("Escolha uma opção: ");
			System.out.println("=====================================================");
			System.out.println("[1] - Adicionar clientes e seus contatos");
			System.out.println("[2] - Lista de contatos dos clientes");
			System.out.println("[3] - Remover Cliente");
			System.out.println("[4] - Alterar Cliente");
			System.out.println("[5] - Sair");
			opcao = scNum.nextInt();
			switch (opcao) {

			case 1: // Insere novos clientes e seus contatos

				System.out.println("Por favor, informe o nome do cliente: ");
				String nome = scText.nextLine();
				cliente.setNome(nome);

				System.out.println("Digite o CPF: ");
				String cpf = scText.nextLine();
				cliente.setCpf(cpf);

				System.out.println("Digite o sexo: ");
				String sexo = scText.nextLine();
				cliente.setSexo(sexo);

				System.out.println("Digite a idade: ");
				int idade = scNum.nextInt();
				cliente.setIdade(idade);

				System.out.println("Informe o interesse: ");
				String interesse = scText.nextLine();
				cliente.setInteresse(interesse);

				int opcaoContato = 0;
				// loop de cadastro de contatos -------------------------------
				while (opcaoContato != 6) {

					System.out.println("== Escolha uma opção ==");
					System.out.println("(5) Inserir Contato");
					System.out.println("(6) Sair dos contatos");
					System.out.println("=======================");

					opcaoContato = scNum.nextInt();

					switch (opcaoContato) {
					case 5:
						Contato contato = new Contato();
						System.out.println("Digite o e-mail: ");
						String email = scText.nextLine();
						contato.setEmail(email);
						System.out.println("Digite o telefone: ");
						contato.setTelefone(scText.nextLine());

						contato.setCliente(cliente);

						cliente.getListaContatos().add(contato);

						break;
					case 6:
						System.out.println("##### Saindo do cadastro de contato #####");

					default:
						System.out.println("-- Opção invalida --");
						break;
					}
				} // fim do loop de cadastro de contatos ---------

				// Ao salvar verificar se retorna true ou false

				if (clienteDAO.inserir(cliente)) {
					System.out.println("=== Cliente Salvo com Sucesso! ===");
				} else {
					System.out.println("=== Cliente Falhou ;( ===");
				}

				break;

			case 2: // LISTAR TODOS OS Clientes com contatos

				List<Cliente> listaClientes = clienteDAO.listarTodos();

				for (Cliente cl : listaClientes) {
					System.out.println("CPF: " + cl.getCpf() + " -- " + "Nome: " + cl.getNome());
					System.out.println("===========================================");

					if (cl.getListaContatos() != null && cl.getListaContatos().size() > 0) {
						for (Contato ct : cl.getListaContatos()) {
							System.out.println("E-mail: " + ct.getEmail() + " - " + "Telefone: " + ct.getTelefone());
							System.out.println("===========================================");
						}
					} else {
						System.out.println("-- Cliente sem contatos -- ");
					}
				}

				break;

			case 3: // Remover Cliente
				System.out.println("Remover Cliente");
				List<Cliente> listaClientes2 = clienteDAO.listarTodos();

				for (Cliente cl : listaClientes2) {
					System.out.println("CPF: " + cl.getCpf() + " - " + "Nome: " + cl.getNome());
					System.out.println("====================================================================");
				}
				System.out.println("Digite o CPF do Cliente a remover: ");
				String cpf2 = scText.nextLine();

				Cliente clienteRemover = new Cliente();
				clienteRemover.setCpf(cpf2);

				if (clienteDAO.remover(clienteRemover)) {
					System.out.println("==== Cliente removido ====");
				} else {
					System.out.println("==== Cliente Falha não removido ====");
				}

				break;

			case 4: // Alterar Cliente
				System.out.println("Alterar Cliente");
				List<Cliente> listaCli = clienteDAO.listarTodos();

				for (Cliente cl : listaCli) {
					System.out.println("CPF: " + cl.getCpf() + " - " + "Nome: " + cl.getNome());
					System.out.println("====================================================================");
				}

				System.out.println("Digite o CPF do Cliente a alterar: ");
				Cliente clienteAlterar = new Cliente();
				clienteAlterar.setCpf(scText.nextLine());

				clienteAlterar = clienteDAO.pesquisar(clienteAlterar.getCpf());

				if (clienteAlterar == null) {
					System.out.println("== Cliente não existe na base ==");
				} else {
					// Inicia a alteração dos campos do cliente
					System.out.println("Informe o nome:");
					clienteAlterar.setNome(scText.nextLine());

					System.out.println("Informe a idade:");
					clienteAlterar.setIdade(scNum.nextInt());

					System.out.println("Informe o sexo:");
					clienteAlterar.setSexo(scText.nextLine());

					System.out.println("Informe o interesse:");
					clienteAlterar.setInteresse(scText.nextLine());

					clienteDAO.alterar(clienteAlterar);

					int opcaoC = 0;

					do {
						System.out.println("==================================");
						System.out.println(" ====== Escolha uma opção ======");
						System.out.println("(1) Inserir Contato");
						System.out.println("(2) Remover Contato");
						System.out.println("(3) Sair dos contatos");
						System.out.println("==================================");

						opcaoC = scNum.nextInt();

						switch (opcaoC) {
						case 1:
							Contato contato = new Contato();
							System.out.println("Digite o e-mail: ");
							contato.setEmail(scText.nextLine());
							System.out.println("Digite o telefone: ");
							contato.setTelefone(scText.nextLine());

							contato.setCliente(clienteAlterar);
							clienteAlterar.getListaContatos().add(contato);

							clienteDAO.inserir(contato);
							System.out.println(" == Contato Inserido ==");
							break;
						case 2:

							clienteAlterar = clienteDAO.pesquisar(clienteAlterar.getCpf());

							if (clienteAlterar.getListaContatos() != null
									&& clienteAlterar.getListaContatos().size() > 0) {
								for (Contato ct : clienteAlterar.getListaContatos()) {
									System.out.println("ID:" + ct.getId() + " E-mail: " + ct.getEmail() + " - "
											+ "Telefone: " + ct.getTelefone());
									System.out.println("===========================================");
								}

								System.out.println("Informe o id do contato a remover:");
								Contato contatoRemover = new Contato();
								contatoRemover.setId(scNum.nextInt());

								contatoRemover = clienteDAO.pesquisarContato(contatoRemover.getId());

								if (contatoRemover != null) {
									clienteDAO.removerContato(contatoRemover);
									System.out.println(" == Contato Removido ==");
								} else {
									System.out.println(" == Contato não existe ==");
								}
							} else {
								System.out.println("-- Cliente sem contatos -- ");
							}

							break;
						case 3:
							System.out.println(" == Saindo dos Contatos ==");
							break;

						default:
							System.out.println(" == Codigo invalido ==");
							break;
						}

					} while (opcaoC != 3);

				}

				break;

			case 5:
				System.out.println("FIM!");
				break;

			default:
				System.out.println("Opção inválida, tente novamente!");
			}
		} while (opcao != 5);

		scNum.close();
		scText.close();
	}

}
