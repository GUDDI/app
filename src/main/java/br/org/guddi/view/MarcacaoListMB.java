package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.domain.Marcacao;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author escritorio
 */
@ViewController
@NextView("./marcacao_edit.jsf")
@PreviousView("./marcacao_list.jsf")
public class MarcacaoListMB extends AbstractListPageBean<Marcacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcacaoBC marcacaoBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Marcacao> handleResultList() {
		return this.marcacaoBC.findAll();
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
				marcacaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}