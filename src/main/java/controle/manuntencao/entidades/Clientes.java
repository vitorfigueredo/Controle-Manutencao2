package controle.manuntencao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Tabela para cadastrar Clientes
@Entity
@Table(name = "Clientes")
@SequenceGenerator(name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ", allocationSize = 1)
public class Clientes {

	@Id
	@Column(name = "id_Cliente")
	@GeneratedValue(generator = "CLIENTES_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idCliente;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cnpj;

	private String celular;

	private String telefone;

	@Column(nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_Endereco")
	private Enderecos endereco;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}


}
