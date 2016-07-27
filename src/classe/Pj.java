package classe;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.Dao;

@Entity
@Table(name="PJ")
@SequenceGenerator(name="SEQUENCIA_PJ",
				   sequenceName="SEQ_PJ",
				   allocationSize=1)
public class Pj extends Funcionario{
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_PJ")
	private Long id;
	
	@Inject
	Dao dao;
	
	@Basic(optional= false)
	@Column(name = "VALORHORA")
	private Double valorHora;
	
	@Basic(optional= false)
	@Column(name = "HORASTRABALHADAS")
	private Double horasTrabalhadas;
	
	public Pj() {
		super();
	}

	public Pj(String name, String endereco, Double salBase, int setor, Double valorHora, Double horasTrabalhadas) {
		super(name, endereco, salBase, setor);
		this.valorHora = valorHora;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public Double calculaSal() {
		Double sal = (this.valorHora * this.horasTrabalhadas);
		return sal;
	}

	@Override
	public void imprimeFP() {
		System.out.println(this.getName());
		System.out.println(calculaSal());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void imprimeSetor(int setor) {
		List<Pj> lista = null;
		try {
			lista = (List<Pj>) dao.pegaListaPorSetor(setor);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(lista != null){
			for (Pj pj : lista) {
				System.out.println(pj.getName());
				System.out.println(pj.calculaSal());
			}
		}else{
			System.out.println("Não foi possível encontrar o setor digitado");
		}
	}
	
}
