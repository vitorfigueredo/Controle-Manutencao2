package controle.manuntencao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Tabela para cadastrar e gerar as marcas dos produtos
@Entity
@Table(name = "Marcas")
@SequenceGenerator(name = "MARCAS_SEQ", sequenceName = "MARCAS_SEQ", allocationSize = 1)
public class Marcas {

	@Id
	@Column(name = "id_Marca")
	@GeneratedValue(generator = "MARCAS_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idMarca;

	@Column(nullable = false, length = 150)
	private String nome;

	private String descricao;

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
