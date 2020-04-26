package com.angular.sistema.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.angular.sistema.ejb.bo.IUsuarioBO;

public class ServiciosEjb {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiciosEjb.class);
	
	public static final String jndiIUsuarioEjb = "java:global/angular-sistema-api/UsuarioBOImpl!com.angular.sistema.ejb.bo.IUsuarioBO";
	
	/**
	 * Retorna EJB de Seguridad
	 * @return
	 */
	public static IUsuarioBO getUsuarioEjb() {
		Context context;
		try {
			context = new InitialContext();
			return (IUsuarioBO) context.lookup(jndiIUsuarioEjb);
		} catch (NamingException e) {
			logger.error(null, e);
		}
		return null;
	}
	
}