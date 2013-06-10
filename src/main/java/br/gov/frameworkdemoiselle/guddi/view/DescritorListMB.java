package br.gov.frameworkdemoiselle.guddi.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.DescritorBC;
import br.gov.frameworkdemoiselle.guddi.domain.Descritor;

@ViewController
@NextView("./descritor_edit.jsf")
@PreviousView("./descritor_list.jsf")
public class DescritorListMB extends AbstractListPageBean<Descritor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DescritorBC descritorBC;
	
	@Override
	protected List<Descritor> handleResultList() {
		return this.descritorBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				descritorBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}