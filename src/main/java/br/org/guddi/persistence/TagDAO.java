package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Tag;
import java.util.logging.Logger;

@PersistenceController
public class TagDAO extends JPACrud<Tag, Long> {

	private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(TagDAO.class.getName());
	

}
