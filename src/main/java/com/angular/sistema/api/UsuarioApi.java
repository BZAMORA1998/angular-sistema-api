package com.angular.sistema.api;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.angular.sistema.dto.ResponseOk;
import com.angular.sistema.ejb.dto.DatosUsuarioDTO;
import com.angular.sistema.ejb.exception.BOException;
import com.angular.sistema.ejb.model.Usuario;
import com.angular.sistema.exceptions.CustomExceptionHandler;
import com.angular.sistema.util.ServiciosEjb;

@Path("/usuario/v1/")
public class UsuarioApi {

	
	@POST
	@Path("ingresar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ingresarUsuario(DatosUsuarioDTO du) {
		try {
			Usuario user=ServiciosEjb.getUsuarioEjb().persist(du);
			return Response.status(200).entity(new ResponseOk("Se ha registrado el usuario:", user)).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getMessage());
		}
	}
	
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@PathParam("id") int id) {
		try {
			ServiciosEjb.getUsuarioEjb().delete(id);
			return Response.status(200).entity(new ResponseOk("Se ha eliminado con exito.", null)).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getMessage());
		}
	}
	
	@GET
	@Path("buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(@PathParam("id") int id) {
		try {
			Usuario user=ServiciosEjb.getUsuarioEjb().find(id);
			return Response.status(200).entity( new ResponseOk("Usuario encontrado:", user)).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getMessage());
		}
	}
	
}