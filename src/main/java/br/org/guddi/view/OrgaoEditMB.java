package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.domain.Orgao;
import javax.inject.Inject;

import org.jboss.weld.exceptions.UnsupportedOperationException;

/**
 *
 * @author escritorio
 */
@ViewController
@PreviousView("./orgao_list.jsf")
public class OrgaoEditMB extends AbstractEditPageBean<Orgao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrgaoBC orgaoBC;

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
    	throw new UnsupportedOperationException();
		//this.orgaoBC.delete(getId());
		//return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.orgaoBC.insert(getBean());
		return getPreviousView();
	}

	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.orgaoBC.update(getBean());
		return getPreviousView();
	}

	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.orgaoBC.load(getId()));
	}


}