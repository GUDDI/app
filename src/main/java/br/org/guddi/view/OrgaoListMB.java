package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.domain.Orgao;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@ViewController
@NextView("./orgao_edit.jsf")
@PreviousView("./orgao_list.jsf")
public class OrgaoListMB extends AbstractListPageBean<Orgao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrgaoBC orgaoBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Orgao> handleResultList() {
		return this.orgaoBC.findAll();
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
				orgaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}