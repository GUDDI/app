package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.guddi.business.PesquisarBC;
import br.org.guddi.domain.Pesquisa;
import java.util.ArrayList;
import java.util.List;

@ViewController
@PreviousView("./index.jsf")
@NextView("./pesquisa_list.jsf")
public class PesquisarMB extends AbstractPageBean {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private PesquisarBC pesquisarBC;
    
    private String consulta;
    
    private List<Pesquisa> lista;

    public String buscar() {
    	this.lista = this.pesquisarBC.busca(consulta);
        return getNextView();
    }

	public String getConsulta() {
		return consulta;
	}
	
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	
	public List<Pesquisa> getLista() {
		return lista;
	}

	
	public void setLista(List<Pesquisa> lista) {
		this.lista = lista;
	}
	
	
}