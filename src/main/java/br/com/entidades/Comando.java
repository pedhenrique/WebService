package br.com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Comando {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private boolean comando;
	
	private Integer idVideo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isComando() {
		return comando;
	}

	public void setComando(boolean comando) {
		this.comando = comando;
	}

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}
		
}
