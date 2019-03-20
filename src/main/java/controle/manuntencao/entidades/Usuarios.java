package controle.manuntencao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Tabela para cadastrar Clientes
@Entity
@Table(name = "Usuarios")
@SequenceGenerator(name = "USUARIOS_SEQ", sequenceName = "USUARIOS_SEQ", allocationSize = 1)
public class Usuarios {

	@Id
	@Column(name = "id_Usuario")
	@GeneratedValue(generator = "USUARIOS_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idUsuario;

	@Column(nullable = false)
	private String nomeUsuarios;
	
	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	private String celular;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuarios() {
		return nomeUsuarios;
	}

	public void setNomeUsuarios(String nomeUsuarios) {
		this.nomeUsuarios = nomeUsuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
