package controle.manuntencao.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao.entidades.Equipamentos;

@Stateless
public class EquipamentosServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager EquipamentoManager;
	
	
	public List<Equipamentos> getTodasEquipamentos() throws Exception{
		List<Equipamentos> listaEquipamentos = EquipamentoManager.createQuery("select p From Equipamentos p", Equipamentos.class).getResultList();
		if(listaEquipamentos == null || listaEquipamentos.isEmpty()) {
			throw new Exception("Nenhum Equipamento cadastrado no banco de dados!!");
		}
		return listaEquipamentos;
	}
	
	public Equipamentos getEquipamentoById(Integer id) throws Exception {
		Equipamentos equipamentoEncontrado = EquipamentoManager.find(Equipamentos.class, id);
		if (equipamentoEncontrado == null) {
			throw new Exception("Equipamento não Encontrado!!");
		}
		return equipamentoEncontrado;
		
	}
	
	public List<Equipamentos> getEquipamentoByName(String nome) throws Exception {
		TypedQuery<Equipamentos> query = EquipamentoManager.createQuery("select p from Equipamentos p where upper(p.nome) like :nome ", Equipamentos.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		List<Equipamentos> equipamentoEncontrado = query.getResultList();
	if (equipamentoEncontrado == null) {
			throw new Exception("Equipamento não Encontrado!!");
		}
		return equipamentoEncontrado;
		
	}
	
	public Equipamentos saveEquipamento(Equipamentos equipamento) throws Exception {
		validarNome(equipamento);
		EquipamentoManager.persist(equipamento);
		return equipamento;
	}
	
	public Equipamentos atualizarEquipamento(Equipamentos equipamento) throws Exception {
		validarNome(equipamento);
		return EquipamentoManager.merge(equipamento);
	}
	
	public Equipamentos deleteEquipamento(Integer id) throws Exception {
		Equipamentos equipamento = getEquipamentoById(id);
		EquipamentoManager.remove(equipamento);
		return null;
	}

	private void validarNome(Equipamentos equipamento) throws Exception {
		if(equipamento.getNome() == null || equipamento.getNome().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}
	
	
	

}
