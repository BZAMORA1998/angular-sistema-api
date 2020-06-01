package com.angular.sistema.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.angular.sistema.dto.ResponseOk;
import com.angular.sistema.ejb.dto.AutenticacionDTO;
import com.angular.sistema.exceptions.CustomExceptionHandler;
import com.angular.sistema.util.ServiciosEjb;

@Path("/usuario/v1/")
public class UsuarioSistemaApi {

	@POST
	@Path("/autenticacion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(AutenticacionDTO objAutenticacion) {
		try {
			ServiciosEjb.getUsuarioEjb().autenticacion(objAutenticacion);
			return Response.status(200).entity(new ResponseOk("Usuario y contrasena correcta",null)).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getMessage());
		}
	}
}
