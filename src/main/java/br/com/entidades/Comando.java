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
	
	
	
}
