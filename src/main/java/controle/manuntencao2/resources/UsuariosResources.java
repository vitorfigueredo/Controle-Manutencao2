package controle.manuntencao2.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controle.manuntencao2.entidades.Usuarios;
import controle.manuntencao2.services.UsuariosServices;
import controle.manuntencao2.utils.MensagemResposta;

@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosResources {
	
	@Inject
	UsuariosServices UsuariosService;
	
	@GET
	public Response getAll() {
		try {
			return Response.ok(UsuariosService.getTodasUsuarios()).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.OK).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getId(@PathParam("id") Integer idUsuario) {
		try {
			return Response.ok(UsuariosService.getUsuarioById(idUsuario)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/busca")
	public Response getNome(@QueryParam("nome") String nomeUsuario) {
		try {
			return Response.ok(UsuariosService.getUsuarioByName(nomeUsuario)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	public Response save(Usuarios usuario) {
		try {
			return Response.ok(UsuariosService.saveUsuario(usuario)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	public Response update(Usuarios usuario) {
		try {
			return Response.ok(UsuariosService.atualizarUsuario(usuario)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") Integer idUsuario) {
		try {
			UsuariosService.deleteUsuario(idUsuario);
			return Response.ok(new MensagemResposta("Operação completada com sucesso!!")).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
