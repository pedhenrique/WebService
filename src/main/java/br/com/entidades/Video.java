package br.com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(
			name = "consulta.listarTodosVideos",
			query = "select v from Video v WHERE v.pronto2 = true"),
    @NamedQuery(
    		name="consulta.buscaNovo",
            query="select v from Video v WHERE v.path = 'novo'"),
}) 

public class Video {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String path;
	

	private boolean pronto;
	
	private boolean pronto2;
	
	
	public boolean isPronto2() {
		return pronto2;
	}

	public void setPronto2(boolean pronto2) {
		this.pronto2 = pronto2;
	}

	private String nome;
	
	public Video() {
		this.path = "novo";
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
