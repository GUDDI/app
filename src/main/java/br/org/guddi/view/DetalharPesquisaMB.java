package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.domain.Servico;
import javax.inject.Inject;

/**
 *
 * @author thiago.soares
 */
@ViewController
@PreviousView("./pesquisa_list.jsf")
@NextView("./detalhamento_servico.jsf")
public class DetalharPesquisaMB extends AbstractEditPageBean<Servico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicoBC servicoBC;

	private Long idServico;
    @Override
	protected void handleLoad() {

		setBean(servicoBC.load(getId()));

	}
    public String detalharServico() {

		return getNextView();
	}


    public Long getIdServico() {
		return idServico;
	}

    public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}


    @Override
	public String delete() {
		return null;
	}

    @Override
	public String insert() {
		return null;
	}


    @Override
	public String update() {
		return null;
	}







}
