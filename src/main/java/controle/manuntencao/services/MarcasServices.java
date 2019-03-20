package controle.manuntencao.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao.entidades.Marcas;

@Stateless
public class MarcasServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager MarcaManager;
	
	public List<Marcas> getTodasMarcas() throws Exception{
		List<Marcas> listaMarcas = MarcaManager.createQuery("select m From Marcas m", Marcas.class).getResultList();
		if(listaMarcas == null || listaMarcas.isEmpty()) {
			throw new Exception("Nenhuma Marca cadastrada no banco de dados!!");
		}
		return listaMarcas;
	}
	
	public Marcas getMarcaById(Integer id) throws Exception {
		Marcas marcaEncontrado = MarcaManager.find(Marcas.class, id);
		if (marcaEncontrado == null) {
			throw new Exception("Marca não Encontrada!!");
		}
		return marcaEncontrado;
		
	}
	
	public List<Marcas> getMarcaByName(String nome) throws Exception {
		TypedQuery<Marcas> query = MarcaManager.createQuery("select m from Marcas m where upper(m.nome) like :nome ", Marcas.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		List<Marcas> marcaEncontrado = query.getResultList();
	if (marcaEncontrado == null) {
			throw new Exception("Marca não Encontrado!!");
		}
		return marcaEncontrado;
		
	}
	
	public Marcas saveMarca(Marcas marca) throws Exception {
		validarNome(marca);
		MarcaManager.persist(marca);
		return marca;
	}
	
	public Marcas atualizarMarca(Marcas marca) throws Exception {
		validarNome(marca);
		return MarcaManager.merge(marca);
	}
	
	public Marcas deleteMarca(Integer id) throws Exception {
		Marcas marca = getMarcaById(id);
		MarcaManager.remove(marca);
		return null;
	}

	private void validarNome(Marcas marca) throws Exception {
		if(marca.getNome() == null || marca.getNome().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}

}
