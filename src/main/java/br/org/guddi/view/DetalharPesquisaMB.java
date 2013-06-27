package br.org.guddi.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.guddi.business.PesquisarBC;
import br.org.guddi.domain.Pesquisa;

@ViewController
@PreviousView("./pesquisa_list.jsf")
@NextView("./pesquisa_detalhe.jsf")
public class DetalharPesquisaMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private PesquisarBC pesquisarBC;

	
	 public String delalhar(Pesquisa pesquisa) {
    	
		 System.out.println(pesquisa);
		 
        return getNextView();
    }

}