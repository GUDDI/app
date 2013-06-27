package br.org.guddi.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Sistema;

@ViewController
@NextView("./sistema_edit.jsf")
@PreviousView("./sistema_list.jsf")
public class SistemaListMB extends AbstractListPageBean<Sistema, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;
	
	@Override
	protected List<Sistema> handleResultList() {
		return this.sistemaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				sistemaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}