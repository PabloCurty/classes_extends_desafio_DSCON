package classe;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FUNCIONARIO")
@SequenceGenerator(name="SEQUENCIA_FUNCIONARIO",
				   sequenceName="SEQ_FUNC",
				   allocationSize=1)
public abstract class Funcionario extends model.Pessoa{

	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_FUNCIONARIO")
	private Long id;
	
	@Basic(optional= false)
	@Column(name = "SALBASE")
	private Double salBase;
	
	@Basic(optional= false)
	@Column(name = "SETOR")
	private int setor;

	public Funcionario() {
		super();
	}

	public Funcionario(String name, String endereco, Double salBase, int setor) {
		super(name, endereco);
		this.salBase = salBase;
		this.setor = setor;
	}

	public abstract Double calculaSal();
	
	public abstract void imprimeFP();
	
	public abstract void imprimeSetor(int setor);

	public Double getSalBase() {
		return salBase;
	}


	public void setSalBase(Double salBase) {
		this.salBase = salBase;
	}


	public int getSetor() {
		return setor;
	}


	public void setSetor(int setor) {
		this.setor = setor;
	}
	
	
	
}
