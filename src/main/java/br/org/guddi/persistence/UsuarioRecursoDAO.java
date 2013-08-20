package br.org.guddi.persistence;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.UsuarioRecurso;

/**
 *
 * @author Clovis Lemes Ferreira Junior
 */
@PersistenceController
public class UsuarioRecursoDAO extends JPACrud<UsuarioRecurso, Long> {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
	public List<UsuarioRecurso> findByUsuario(Long idUsuario){
    	return getEntityManager().createNamedQuery("UsuarioRecurso.findByIdUsuario").setParameter("idUsuario", idUsuario).getResultList();
    }
    
   
}
