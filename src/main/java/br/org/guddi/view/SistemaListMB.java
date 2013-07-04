package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Sistema;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@NextView("./sistema_edit.jsf")
@PreviousView("./sistema_list.jsf")
public class SistemaListMB extends AbstractListPageBean<Sistema, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Sistema> handleResultList() {
		return this.sistemaBC.findAll();
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
				sistemaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}