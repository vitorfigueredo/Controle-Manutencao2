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

//Tabela de cadastro de equipamentos, sem informar quantidade
@Entity
@Table(name = "Equipamentos")
@SequenceGenerator(name = "EQUIPAMENTOS_SEQ", sequenceName = "EQUIPAMENTOS_SEQ", allocationSize = 1)
public class Equipamentos {

	@Id
	@Column(name = "id_Equipamento")
	@GeneratedValue(generator = "EQUIPAMENTOS_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idEquipamento;

	@Column(nullable = false, length = 150)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_Marca")
	private Marcas marca;

	public Integer getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

}
