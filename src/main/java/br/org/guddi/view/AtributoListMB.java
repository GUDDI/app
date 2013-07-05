package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.AtributoBC;
import br.org.guddi.domain.Atributo;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@ViewController
@NextView("./atributo_edit.jsf")
@PreviousView("./atributo_list.jsf")
public class AtributoListMB extends AbstractListPageBean<Atributo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AtributoBC atributoBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Atributo> handleResultList() {
		return this.atributoBC.findAll();
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
				atributoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}


}