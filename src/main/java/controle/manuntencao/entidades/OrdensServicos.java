package controle.manuntencao.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Tabela para criar e modificar todas as ordens de serviço
@Entity
@Table(name = "OrdensServicos")
@SequenceGenerator(name = "ORDENS_SEQ", sequenceName = "ORDENS_SEQ", allocationSize = 1)
public class OrdensServicos {

	// Colunas do banco de dados/Variáveis
	@Id
	@Column(name = "id_Ordem")
	@GeneratedValue(generator = "ORDENS_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idOrdem;

	private Date aberturaOrdem;

	private Date inicioServico;

	private Date terminoServico;

	private Date fechamentoOrdem;

	private String pedidoManutencao;

	private String reparado;

	// Dados do Clientes importados de outra Tabela
	@ManyToOne
	@JoinColumn(name = "id_Cliente", nullable = false)
	private Clientes cliente;

	// Dados sobre equipamento importados de outra tabela
	@ManyToOne
	@JoinColumn(name = "id_Equipamento", nullable = false)
	private Equipamentos equipamento;

	// Status da ordem de serviço
	@ManyToOne
	@JoinColumn(name = "id_EstadoServ", nullable = false)
	private EstadosServ estadoServ;

	// Quando existe necessidade de informar motivo de pausa no reparo de um
	// equipamento
	private String aguardando;

	public Integer getIdOrdem() {
		return idOrdem;
	}

	public void setIdOrdem(Integer idOrdem) {
		this.idOrdem = idOrdem;
	}

	public Date getAberturaOrdem() {
		return aberturaOrdem;
	}

	public void setAberturaOrdem(Date aberturaOrdem) {
		this.aberturaOrdem = aberturaOrdem;
	}

	public Date getInicioServico() {
		return inicioServico;
	}

	public void setInicioServico(Date inicioServico) {
		this.inicioServico = inicioServico;
	}

	public Date getTerminoServico() {
		return terminoServico;
	}

	public void setTerminoServico(Date terminoServico) {
		this.terminoServico = terminoServico;
	}

	public Date getFechamentoOrdem() {
		return fechamentoOrdem;
	}

	public void setFechamentoOrdem(Date fechamentoOrdem) {
		this.fechamentoOrdem = fechamentoOrdem;
	}

	public String getPedidoManutencao() {
		return pedidoManutencao;
	}

	public void setPedidoManutencao(String pedidoManutencao) {
		this.pedidoManutencao = pedidoManutencao;
	}

	public String getReparado() {
		return reparado;
	}

	public void setReparado(String reparado) {
		this.reparado = reparado;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Equipamentos getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}

	public EstadosServ getEstadoServ() {
		return estadoServ;
	}

	public void setEstadoServ(EstadosServ estadoServ) {
		this.estadoServ = estadoServ;
	}

	public String getAguardando() {
		return aguardando;
	}

	public void setAguardando(String aguardando) {
		this.aguardando = aguardando;
	}

}
