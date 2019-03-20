package controle.manuntencao.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao.entidades.EstadosServ;

@Stateless
public class EstadosServServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager EstadoServManager;
	
	public List<EstadosServ> getTodasEstadosServ() throws Exception{
		List<EstadosServ> listaEstadosServ = EstadoServManager.createQuery("select m From EstadosServ m", EstadosServ.class).getResultList();
		if(listaEstadosServ == null || listaEstadosServ.isEmpty()) {
			throw new Exception("Nenhuma EstadoServ cadastrada no banco de dados!!");
		}
		return listaEstadosServ;
	}
	
	public EstadosServ getEstadoServById(Integer id) throws Exception {
		EstadosServ estadoServEncontrado = EstadoServManager.find(EstadosServ.class, id);
		if (estadoServEncontrado == null) {
			throw new Exception("EstadoServ não Encontrada!!");
		}
		return estadoServEncontrado;
		
	}
	
	public List<EstadosServ> getEstadoServByName(String nome) throws Exception {
		TypedQuery<EstadosServ> query = EstadoServManager.createQuery("select m from EstadosServ m where upper(m.nome) like :nome ", EstadosServ.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		List<EstadosServ> estadoServEncontrado = query.getResultList();
	if (estadoServEncontrado == null) {
			throw new Exception("EstadoServ não Encontrado!!");
		}
		return estadoServEncontrado;
		
	}
	
	public EstadosServ saveEstadoServ(EstadosServ estadoServ) throws Exception {
		validarNome(estadoServ);
		EstadoServManager.persist(estadoServ);
		return estadoServ;
	}
	
	public EstadosServ atualizarEstadoServ(EstadosServ estadoServ) throws Exception {
		validarNome(estadoServ);
		return EstadoServManager.merge(estadoServ);
	}
	
	public EstadosServ deleteEstadoServ(Integer id) throws Exception {
		EstadosServ estadoServ = getEstadoServById(id);
		EstadoServManager.remove(estadoServ);
		return null;
	}

	private void validarNome(EstadosServ estadoServ) throws Exception {
		if(estadoServ.getNome() == null || estadoServ.getNome().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}

}
