package br.gov.frameworkdemoiselle.guddi.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.ServicoBC;
import br.gov.frameworkdemoiselle.guddi.domain.Servico;

@ViewController
@NextView("./servico_edit.jsf")
@PreviousView("./servico_list.jsf")
public class ServicoListMB extends AbstractListPageBean<Servico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicoBC servicoBC;
	
	@Override
	protected List<Servico> handleResultList() {
		return this.servicoBC.findAll();
	}
	
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