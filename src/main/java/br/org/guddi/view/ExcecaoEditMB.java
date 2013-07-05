package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.ExcecaoBC;
import br.org.guddi.domain.Excecao;
import javax.inject.Inject;

@ViewController
@PreviousView("./excecao_list.jsf")
public class ExcecaoEditMB extends AbstractEditPageBean<Excecao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ExcecaoBC excecaoBC;

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
		this.excecaoBC.delete(getId());
		return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.excecaoBC.insert(getBean());
		return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.excecaoBC.update(getBean());
		return getPreviousView();
	}

	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.excecaoBC.load(getId()));
	}


}