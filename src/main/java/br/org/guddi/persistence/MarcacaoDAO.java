package br.org.guddi.persistence;

import javax.persistence.NoResultException;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Marcacao;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class MarcacaoDAO extends JPACrud<Marcacao, Long> {

	private static final long serialVersionUID = 1L;

	public Marcacao findByMarcacao(String marcacao) {
		
		try{
			return (Marcacao) getEntityManager().createNamedQuery("Marcacao.findByMarcacao").setParameter("marcacao", marcacao).getSingleResult();
		}
		catch(NoResultException e){
			
		}
		
		return null;
		
	}



}
