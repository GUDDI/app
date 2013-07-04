package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.ExcecaoBC;
import br.org.guddi.domain.Excecao;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@NextView("./excecao_edit.jsf")
@PreviousView("./excecao_list.jsf")
public class ExcecaoListMB extends AbstractListPageBean<Excecao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ExcecaoBC excecaoBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Excecao> handleResultList() {
		return this.excecaoBC.findAll();
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
				excecaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}


}