package br.com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("application/json")
public class Teste {
	
	@GET
	public String teste(){
		
		return "it Wors!";
	}
}
