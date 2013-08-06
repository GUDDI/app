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
	
	private List<Marcacao> marcacaoFiltro;

	@Inject
	private MarcacaoBC marcacaoBC;

    @Override
	protected List<Marcacao> handleResultList() {
		return this.marcacaoBC.findAll();
	}

	public List<Marcacao> getMarcacaoFiltro() {
		return marcacaoFiltro;
	}

	public void setMarcacaoFiltro(List<Marcacao> marcacaoFiltro) {
		this.marcacaoFiltro = marcacaoFiltro;
	}


}