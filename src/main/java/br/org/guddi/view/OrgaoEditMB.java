package br.org.guddi.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.domain.Orgao;


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
	
	@Inject
	private MessageContext messageContext;

    @Override
	@Transactional
	public String delete() {
    	throw new UnsupportedOperationException();
	}

    @Override
	@Transactional
	public String insert() {
		this.orgaoBC.insert(getBean());
		messageContext.add("{orgao-insert-ok}", getBean().getNome());
		
		return getPreviousView();
	}

    @Override
	@Transactional
	public String update() {
		this.orgaoBC.update(getBean());
		messageContext.add("{orgao-update-ok}", getBean().getNome());
		
		return getPreviousView();
	}

    @Override
	protected void handleLoad() {
		setBean(this.orgaoBC.load(getId()));
	}

    @ExceptionHandler
	private void tratarExcecao(Exception e){
		messageContext.add("{guddi.erro.generico}", SeverityType.ERROR);
	}

}