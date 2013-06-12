package br.gov.frameworkdemoiselle.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.guddi.business.PesquisarBC;
import br.gov.frameworkdemoiselle.guddi.domain.Pesquisa;
import java.util.ArrayList;
import java.util.List;

@ViewController
@PreviousView("./index.jsf")
@NextView("./pesquisa_lista.jsf")
public class PesquisarMB extends AbstractEditPageBean<Pesquisa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PesquisarBC pesquisarBC;
	
       
        private List<Pesquisa> lista = new ArrayList<Pesquisa>();
		
	public String busca() {
		lista = this.pesquisarBC.busca(getBean().getConsulta());
                return getNextView();
	}

    @Override
    protected void handleLoad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}