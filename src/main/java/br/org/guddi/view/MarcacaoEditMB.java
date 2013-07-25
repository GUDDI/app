package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.domain.Marcacao;
import javax.inject.Inject;

/**
 *
 * @author escritorio
 */
@ViewController
@PreviousView("./marcacao_list.jsf")
public class MarcacaoEditMB extends AbstractEditPageBean<Marcacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcacaoBC marcacaoBC;
	
	@Inject
	private MessageContext messageContext;

    @Override
	public String delete() {
    	throw new UnsupportedOperationException();
	}

    @Override
	@Transactional
	public String insert() {
		this.marcacaoBC.insert(getBean());
		
		messageContext.add("{marcacao-insert-ok}", getBean().getMarcacao());
		
		return getPreviousView();
	}

    @Override
	@Transactional
	public String update() {
		this.marcacaoBC.update(getBean());
		
		messageContext.add("{marcacao-update-ok}", getBean().getMarcacao());
		
		return getPreviousView();
	}

    @Override
	protected void handleLoad() {
		setBean(this.marcacaoBC.load(getId()));
	}
    
    @ExceptionHandler
	private void tratarExcecao(Exception e){
		messageContext.add("{guddi.erro.generico}", SeverityType.ERROR);
	}
    

}