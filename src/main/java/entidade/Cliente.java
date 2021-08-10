package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@Column(name = "CPF", nullable = false)
	private String cpf;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "SEXO", nullable = false)
	private String sexo;
	@Column(name = "IDADE", nullable = false)
	private int idade;
	@Column(name = "INTERESSE", nullable = false)
	private String interesse;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private List<Contato> listaContatos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getInteresse() {
		return interesse;
	}

	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}
}
