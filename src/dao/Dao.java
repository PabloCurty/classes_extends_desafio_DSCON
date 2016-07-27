package dao;

import java.util.List;

import javax.persistence.EntityManager;

public class Dao {

	
	@SuppressWarnings("unchecked")
	public List<?> pegaListaPorSetor(int setor)	{	
		try	{	
			EntityManager em = JPAUtil.getEntityManager();

			List<?> funcionarios = em
				.createQuery("select f from Funcionario f " +
						     "where f.setor =" + setor +		
						     "order by f.id asc")
				.getResultList();

			return funcionarios;
		}catch(RuntimeException e){	
			throw new RuntimeException(e);
		}
	}
}
