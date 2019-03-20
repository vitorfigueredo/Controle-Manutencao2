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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controle.manuntencao.entidades.Enderecos;
import controle.manuntencao.services.EnderecosServices;
import controle.manuntencao.utils.MensagemResposta;

@Path("enderecos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecosResources {
	
	@Inject
	EnderecosServices EnderecosService;
	
	@GET
	public Response getAll() {
		try {
			return Response.ok(EnderecosService.getTodasEnderecos()).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.OK).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getId(@PathParam("id") Integer idEndereco) {
		try {
			return Response.ok(EnderecosService.getEnderecoById(idEndereco)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/busca")
	public Response getNome(@QueryParam("nome") String nomeEndereco) {
		try {
			return Response.ok(EnderecosService.getEnderecoByCep(nomeEndereco)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	public Response save(Enderecos endereco) {
		try {
			return Response.ok(EnderecosService.saveEndereco(endereco)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	public Response update(Enderecos endereco) {
		try {
			return Response.ok(EnderecosService.atualizarEndereco(endereco)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") Integer idEndereco) {
		try {
			EnderecosService.deleteEndereco(idEndereco);
			return Response.ok(new MensagemResposta("Operação completada com sucesso!!")).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
