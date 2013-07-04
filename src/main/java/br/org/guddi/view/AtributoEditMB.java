package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.AtributoBC;
import br.org.guddi.domain.Atributo;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@PreviousView("./atributo_list.jsf")
public class AtributoEditMB extends AbstractEditPageBean<Atributo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AtributoBC atributoBC;
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
		this.atributoBC.delete(getId());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.atributoBC.insert(getBean());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.atributoBC.update(getBean());
		return getPreviousView();
	}
	
	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.atributoBC.load(getId()));
	}
    private static final Logger LOG = Logger.getLogger(AtributoEditMB.class.getName());

}