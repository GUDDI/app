package br.gov.frameworkdemoiselle.guddi.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.AtributoBC;
import br.gov.frameworkdemoiselle.guddi.domain.Atributo;

@ViewController
@NextView("./atributo_edit.jsf")
@PreviousView("./atributo_list.jsf")
public class AtributoListMB extends AbstractListPageBean<Atributo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AtributoBC atributoBC;
	
	@Override
	protected List<Atributo> handleResultList() {
		return this.atributoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				atributoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}