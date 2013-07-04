package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.domain.Servico;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@NextView("./servico_edit.jsf")
@PreviousView("./servico_list.jsf")
public class ServicoListMB extends AbstractListPageBean<Servico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicoBC servicoBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Servico> handleResultList() {
		return this.servicoBC.findAll();
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
				servicoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}


}