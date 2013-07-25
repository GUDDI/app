package br.org.guddi.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.domain.Marcacao;

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

    @Override
	protected List<Marcacao> handleResultList() {
		return this.marcacaoBC.findAll();
	}


}