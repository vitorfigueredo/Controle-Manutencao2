package controle.manuntencao.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import controle.manuntencao.entidades.OrdensServicos;

@Stateless
public class OrdensServicosServices {

	@PersistenceContext(unitName = "primary")
	EntityManager OrdensServicosManager;

	public List<OrdensServicos> getTodasOrdensServicos() throws Exception {
		List<OrdensServicos> listaOrdensServicos = OrdensServicosManager
				.createQuery("select m From OrdensServicos m", OrdensServicos.class).getResultList();
		if (listaOrdensServicos == null || listaOrdensServicos.isEmpty()) {
			throw new Exception("Nenhuma OrdensServicos cadastrada no banco de dados!!");
		}
		return listaOrdensServicos;
	}

	public OrdensServicos getOrdensServicosById(Integer id) throws Exception {
		OrdensServicos ordemEncontrado = OrdensServicosManager.find(OrdensServicos.class, id);
		if (ordemEncontrado == null) {
			throw new Exception("OrdensServicos não Encontrada!!");
		}
		return ordemEncontrado;

	}

	public OrdensServicos saveOrdensServicos(OrdensServicos ordem) throws Exception {

		OrdensServicosManager.persist(ordem);
		return ordem;
	}

	public OrdensServicos atualizarOrdensServicos(OrdensServicos ordem) throws Exception {
		return OrdensServicosManager.merge(ordem);
	}

	public OrdensServicos deleteOrdensServicos(Integer id) throws Exception {
		OrdensServicos ordem = getOrdensServicosById(id);
		OrdensServicosManager.remove(ordem);
		return null;
	}

}
