package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
@SequenceGenerator(name="SEQUENCIA_PESSOA",
				   sequenceName="SEQ_PESS",
				   allocationSize=1)
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_PESSOA")
	private Long id;
	
	@Basic(optional= false)
	@Column(name = "NOME")
	private String name;
	
	@Basic(optional= false)
	@Column(name = "ENDERECO")
	private String endereco;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String name, String endereco) {
		super();
		this.name = name;
		this.endereco = endereco;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

}
