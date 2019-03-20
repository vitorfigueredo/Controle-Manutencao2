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

import controle.manuntencao2.entidades.EstadosServ;
import controle.manuntencao2.services.EstadosServServices;
import controle.manuntencao2.utils.MensagemResposta;

@Path("estadoservs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadosServResources {
	
	@Inject
	EstadosServServices EstadoServService;
	
	@GET
	public Response getAll() {
		try {
			return Response.ok(EstadoServService.getTodasEstadosServ()).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.OK).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getId(@PathParam("id") Integer idEstadoServ) {
		try {
			return Response.ok(EstadoServService.getEstadoServById(idEstadoServ)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/busca")
	public Response getNome(@QueryParam("nome") String nomeEstadoServ) {
		try {
			return Response.ok(EstadoServService.getEstadoServByName(nomeEstadoServ)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	public Response save(EstadosServ estadoserv) {
		try {
			return Response.ok(EstadoServService.saveEstadoServ(estadoserv)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	public Response update(EstadosServ estadoserv) {
		try {
			return Response.ok(EstadoServService.atualizarEstadoServ(estadoserv)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") Integer idEstadoServ) {
		try {
			EstadoServService.deleteEstadoServ(idEstadoServ);
			return Response.ok(new MensagemResposta("Operação completada com sucesso!!")).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
