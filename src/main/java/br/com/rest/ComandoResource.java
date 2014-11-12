package br.com.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.dao.ComandoDAO;
import br.com.dao.VideoDAO;
import br.com.entidades.Comando;
import br.com.entidades.Video;
import br.com.util.LocalShell;

@Path("/comando")
@Stateless
public class ComandoResource {
	@EJB
	private ComandoDAO comandoDAO;
	@EJB
	private VideoDAO videoDAO;
	
	@GET
	@Path("/produzirVideo")
	public void atualizar() throws IOException{
		Video video = new Video();
		video.setPronto(false);
		videoDAO.insere(video);
		
		Comando comando = new Comando();
		comando.setId(1);
		int idVideo = videoDAO.buscarNovo();
		comando.setIdVideo(idVideo);
		comando.setComando(true);			
		comandoDAO.atualizar(comando);
				
//		LocalShell shell = new LocalShell();
//		video = videoDAO.buscar(idVideo);
//		String cmd = "ffmpeg -i " + video.getPath() + " -acodec libfaac -b:a 128k -vcodec mpeg4 -b:v 1200k -flags +aic+mv4 /var/www/html/" + video.getId() + ".mp4";
//		shell.executeCommand(cmd);
//		cmd = "rm " + video.getPath();
//		shell.executeCommand(cmd);
	}

	@GET
	public String oi(){
		
		return "Oi!";
	}
}
