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

import controle.manuntencao2.entidades.Clientes;
import controle.manuntencao2.services.ClientesServices;
import controle.manuntencao2.utils.MensagemResposta;

@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientesResources {
	
	@Inject
	ClientesServices ClientesService;
	
	@GET
	public Response getAll() {
		try {
			return Response.ok(ClientesService.getTodasClientes()).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.OK).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getId(@PathParam("id") Integer idCliente) {
		try {
			return Response.ok(ClientesService.getClienteById(idCliente)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/busca")
	public Response getNome(@QueryParam("nome") String nomeCliente) {
		try {
			return Response.ok(ClientesService.getClienteByName(nomeCliente)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	public Response save(Clientes cliente) {
		try {
			return Response.ok(ClientesService.saveCliente(cliente)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	public Response update(Clientes cliente) {
		try {
			return Response.ok(ClientesService.atualizarCliente(cliente)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") Integer idCliente) {
		try {
			ClientesService.deleteCliente(idCliente);
			return Response.ok(new MensagemResposta("Operação completada com sucesso!!")).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
