package controle.manuntencao2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao2.entidades.Enderecos;

@Stateless
public class EnderecosServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager EnderecoManager;
	
	public List<Enderecos> getTodasEnderecos() throws Exception{
		List<Enderecos> listaEnderecos = EnderecoManager.createQuery("select e From Enderecos e", Enderecos.class).getResultList();
		if(listaEnderecos == null || listaEnderecos.isEmpty()) {
			throw new Exception("Nenhum Endereco cadastrado no banco de dados!!");
		}
		return listaEnderecos;
	}
	
	public Enderecos getEnderecoById(Integer id) throws Exception {
		Enderecos enderecoEncontrado = EnderecoManager.find(Enderecos.class, id);
		if (enderecoEncontrado == null) {
			throw new Exception("Endereco não Encontrado!!");
		}
		return enderecoEncontrado;
		
	}
	
	public List<Enderecos> getEnderecoByCep(String nome) throws Exception {
		TypedQuery<Enderecos> query = EnderecoManager.createQuery("select e from Enderecos e where e.cep like :cep ", Enderecos.class);
		query.setParameter("cep", nome);
		List<Enderecos> enderecoEncontrado = query.getResultList();
	if (enderecoEncontrado == null) {
			throw new Exception("Endereco não Encontrado!!");
		}
		return enderecoEncontrado;
		
	}
	
	public Enderecos saveEndereco(Enderecos endereco) throws Exception {
		validarNome(endereco);
		EnderecoManager.persist(endereco);
		return endereco;
	}
	
	public Enderecos atualizarEndereco(Enderecos endereco) throws Exception {
		validarNome(endereco);
		return EnderecoManager.merge(endereco);
	}
	
	public Enderecos deleteEndereco(Integer id) throws Exception {
		Enderecos endereco = getEnderecoById(id);
		EnderecoManager.remove(endereco);
		return null;
	}

	private void validarNome(Enderecos endereco) throws Exception {
		if(endereco.getCep() == null || endereco.getCep().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}

}
