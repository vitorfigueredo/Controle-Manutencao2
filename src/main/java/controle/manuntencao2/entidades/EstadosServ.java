package controle.manuntencao2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Tabela que criar todos os estados de ordens de serviço
@Entity
@Table(name = "EstadosDoServico")
@SequenceGenerator(name = "ESTADOSERV_SEQ", sequenceName = "ESTADOSERV_SEQ", allocationSize = 1)
public class EstadosServ {

	// Colunas do banco de dados/Variáveis
	@Id
	@Column(name = "id_EstadoServ")
	@GeneratedValue(generator = "ESTADOSERV_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idEstadoServ;

	@Column(nullable = false)
	private String nome;

	private String descricao;

	public Integer getIdEstadoServ() {
		return idEstadoServ;
	}

	public void setIdEstadoServ(Integer idEstadoServ) {
		this.idEstadoServ = idEstadoServ;
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
