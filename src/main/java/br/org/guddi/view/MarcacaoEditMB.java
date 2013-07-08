package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.domain.Marcacao;
import javax.inject.Inject;

@ViewController
@PreviousView("./marcacao_list.jsf")
public class MarcacaoEditMB extends AbstractEditPageBean<Marcacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcacaoBC marcacaoBC;

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
		this.marcacaoBC.delete(getId());
		return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.marcacaoBC.insert(getBean());
		return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.marcacaoBC.update(getBean());
		return getPreviousView();
	}

	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.marcacaoBC.load(getId()));
	}

}