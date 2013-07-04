package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.DescritorBC;
import br.org.guddi.domain.Descritor;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@NextView("./descritor_edit.jsf")
@PreviousView("./descritor_list.jsf")
public class DescritorListMB extends AbstractListPageBean<Descritor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DescritorBC descritorBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Descritor> handleResultList() {
		return this.descritorBC.findAll();
	}

	/**
     *
     * @return
     */
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