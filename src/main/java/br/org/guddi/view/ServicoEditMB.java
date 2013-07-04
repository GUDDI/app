package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.domain.Servico;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@PreviousView("./servico_list.jsf")
public class ServicoEditMB extends AbstractEditPageBean<Servico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicoBC servicoBC;
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
		this.servicoBC.delete(getId());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.servicoBC.insert(getBean());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.servicoBC.update(getBean());
		return getPreviousView();
	}
	
	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.servicoBC.load(getId()));
	}
    private static final Logger LOG = Logger.getLogger(ServicoEditMB.class.getName());

}