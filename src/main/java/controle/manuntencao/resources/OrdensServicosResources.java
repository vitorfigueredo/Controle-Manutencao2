package controle.manuntencao.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controle.manuntencao.entidades.OrdensServicos;
import controle.manuntencao.services.OrdensServicosServices;
import controle.manuntencao.utils.MensagemResposta;

@Path("ordens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdensServicosResources {
	
	@Inject
	OrdensServicosServices ordemService;
	
	@GET
	public Response getAll() {
		try {
			return Response.ok(ordemService.getTodasOrdensServicos()).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.OK).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getId(@PathParam("id") Integer idOrdensServicos) {
		try {
			return Response.ok(ordemService.getOrdensServicosById(idOrdensServicos)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	
	@POST
	public Response save(OrdensServicos ordem) {
		try {
			return Response.ok(ordemService.saveOrdensServicos(ordem)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	public Response update(OrdensServicos ordem) {
		try {
			return Response.ok(ordemService.atualizarOrdensServicos(ordem)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") Integer idOrdensServicos) {
		try {
			ordemService.deleteOrdensServicos(idOrdensServicos);
			return Response.ok(new MensagemResposta("Operação completada com sucesso!!")).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
