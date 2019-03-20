package controle.manuntencao2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import controle.manuntencao2.entidades.Usuarios;

@Stateless
public class UsuariosServices {
	
	@PersistenceContext(unitName = "primary")
	EntityManager UsuarioManager;
	
	public List<Usuarios> getTodasUsuarios() throws Exception{
		List<Usuarios> listaUsuarios = UsuarioManager.createQuery("select c From Usuarios c", Usuarios.class).getResultList();
		if(listaUsuarios == null || listaUsuarios.isEmpty()) {
			throw new Exception("Nenhum Usuario cadastrado no banco de dados!!");
		}
		return listaUsuarios;
	}
	
	public Usuarios getUsuarioById(Integer id) throws Exception {
		Usuarios usuarioEncontrado = UsuarioManager.find(Usuarios.class, id);
		if (usuarioEncontrado == null) {
			throw new Exception("Usuario não Encontrado!!");
		}
		return usuarioEncontrado;
		
	}
	
	public List<Usuarios> getUsuarioByName(String nome) throws Exception {
		TypedQuery<Usuarios> query = UsuarioManager.createQuery("select c from Usuarios c where upper(c.nome) like :nome ", Usuarios.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		List<Usuarios> usuarioEncontrado = query.getResultList();
	if (usuarioEncontrado == null) {
			throw new Exception("Usuario não Encontrado!!");
		}
		return usuarioEncontrado;
		
	}
	
	public Usuarios saveUsuario(Usuarios usuario) throws Exception {
		validarNome(usuario);
		UsuarioManager.persist(usuario);
		return usuario;
	}
	
	public Usuarios atualizarUsuario(Usuarios usuario) throws Exception {
		validarNome(usuario);
		return UsuarioManager.merge(usuario);
	}
	
	public Usuarios deleteUsuario(Integer id) throws Exception {
		Usuarios usuario = getUsuarioById(id);
		UsuarioManager.remove(usuario);
		return null;
	}

	private void validarNome(Usuarios usuario) throws Exception {
		if(usuario.getNome() == null || usuario.getNome().isEmpty()) {
			throw new Exception("Campo Obrigatório em branco");
		}
	}

}
