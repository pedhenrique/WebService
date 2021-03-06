package br.com.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	@Produces("application/json")
	public Comando atualizar() throws IOException {
		Video video = new Video();
		video.setPronto(false);
		videoDAO.insere(video);

		Comando comando = new Comando();
		comando.setId(1);
		final int idVideo = videoDAO.buscarNovo();
		comando.setIdVideo(idVideo);
		comando.setComando(true);
		comandoDAO.atualizar(comando);

		
		new Thread() {

			@Override
			public void run() {
				super.run();
				Video v;
				boolean executaThread = true;
				do {
					try {
						v = videoDAO.buscar(idVideo);
						if (v.isPronto()) {
							 LocalShell shell = new LocalShell();
							 String cmd = "ffmpeg -i " + v.getPath() +
							 " -acodec libfaac -b:a 128k -vcodec mpeg4 -b:v 1200k -flags +aic+mv4 /var/www/html/"
							 + v.getNome();
							 shell.executeCommand(cmd);
							 sleep(2000);
							 cmd = "rm " + v.getPath();
							 shell.executeCommand(cmd);
							 sleep(2000);
							 v.setPronto2(true);
							 videoDAO.atualizar(v);
							 executaThread = false;					
						}
						sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} while (executaThread);
			}
		}.start();
		
		Comando c = comandoDAO.buscar();
		return c;
	}
	
	
}
