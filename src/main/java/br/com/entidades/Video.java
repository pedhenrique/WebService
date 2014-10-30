package br.com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQuery(
		name = "consulta.listarTodosVideos",
		query = "select v from Video v")
public class Video {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String path;
	

	private boolean pronto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isPronto() {
		return pronto;
	}


	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}

	
}
