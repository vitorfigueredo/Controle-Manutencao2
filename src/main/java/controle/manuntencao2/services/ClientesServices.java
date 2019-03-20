package controle.manuntencao2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao2.entidades.Clientes;

@Stateless
public class ClientesServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager ClienteManager;
	
	public List<Clientes> getTodasClientes() throws Exception{
		List<Clientes> listaClientes = ClienteManager.createQuery("select c From Clientes c", Clientes.class).getResultList();
		if(listaClientes == null || listaClientes.isEmpty()) {
			throw new Exception("Nenhum Cliente cadastrado no banco de dados!!");
		}
		return listaClientes;
	}
	
	public Clientes getClienteById(Integer id) throws Exception {
		Clientes clienteEncontrado = ClienteManager.find(Clientes.class, id);
		if (clienteEncontrado == null) {
			throw new Exception("Cliente não Encontrado!!");
		}
		return clienteEncontrado;
		
	}
	
	public List<Clientes> getClienteByName(String nome) throws Exception {
		TypedQuery<Clientes> query = ClienteManager.createQuery("select c from Clientes c where upper(c.nome) like :nome ", Clientes.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		List<Clientes> clienteEncontrado = query.getResultList();
	if (clienteEncontrado == null) {
			throw new Exception("Cliente não Encontrado!!");
		}
		return clienteEncontrado;
		
	}
	
	public Clientes saveCliente(Clientes cliente) throws Exception {
		validarNome(cliente);
		ClienteManager.persist(cliente);
		return cliente;
	}
	
	public Clientes atualizarCliente(Clientes cliente) throws Exception {
		validarNome(cliente);
		return ClienteManager.merge(cliente);
	}
	
	public Clientes deleteCliente(Integer id) throws Exception {
		Clientes cliente = getClienteById(id);
		ClienteManager.remove(cliente);
		return null;
	}

	private void validarNome(Clientes cliente) throws Exception {
		if(cliente.getNome() == null || cliente.getNome().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}

}
