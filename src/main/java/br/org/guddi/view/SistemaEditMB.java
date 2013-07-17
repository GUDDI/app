package br.org.guddi.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.DescritorType;
import br.org.guddi.domain.Excecao;
import br.org.guddi.domain.Marcacao;
import br.org.guddi.domain.Servico;
import br.org.guddi.domain.Sistema;
import br.org.guddi.security.Identity;

/**
 *
 * @author escritorio
 */
@ViewController
@PreviousView("./sistema_list.jsf")
public class SistemaEditMB extends AbstractEditPageBean<Sistema, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;

	@Inject
	private OrgaoBC orgaoBC;
	
	@Inject
	private MarcacaoBC marcacaoBC;

	@Inject
	private Identity identity;
	
	@Inject
	private Atributo atributo;
	
	@Inject
	private Excecao excecao;
	
	private List<Descritor> descritores;
	
	private Descritor descritorNovo;
	
	private DescritorType tipoDescritor;
	
	private Servico servicoNovo;
	
    public void adicionaDescritor() {
    	setDescritorNovo(new Descritor());
		getDescritorNovo().setTipo(getTipoDescritor());
		getDescritorNovo().setSistema(getBean());
		
		getDescritores().add(0, getDescritorNovo());
		setServicoNovo(new Servico());
	}
    
    @Transactional
    public void salvarDescritor() {
    	
    	for(Descritor descritor : getDescritores()){
    		if(!descritor.getMarcacoesFormatado().isEmpty()){
    			
    		}
    	}
    	
    	getBean().setDescritores(getDescritores());
    	
    	sistemaBC.update(getBean());
    }
    
	public Servico getServicoNovo() {
		return servicoNovo;
	}

	public void setServicoNovo(Servico servicoNovo) {
		this.servicoNovo = servicoNovo;
	}

	public Descritor getDescritorNovo() {
		return descritorNovo;
	}

	public void setDescritorNovo(Descritor descritorNovo) {
		this.descritorNovo = descritorNovo;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}
	
	public Excecao getExcecao() {
		return excecao;
	}

	public void setExcecao(Excecao excecao) {
		this.excecao = excecao;
	}

	public DescritorType getTipoDescritor() {
		return tipoDescritor;
	}

	public void setTipoDescritor(DescritorType tipoDescritor) {
		this.tipoDescritor = tipoDescritor;
	}
	
    public DescritorType [] getTipoDescritores(){
    	return DescritorType.values();
    }
    
	public List<Descritor> getDescritores() {
		return descritores;
	}

	public void setDescritores(List<Descritor> descritores) {
		this.descritores = descritores;
	}

	@Override
	protected void handleLoad() {
		setBean(this.sistemaBC.load(getId()));
		setDescritores(new ArrayList<Descritor>(getBean().getDescritores()));
		setServicoNovo(new Servico());
	}

	@Override
	@Transactional
	public String delete() {
		//this.sistemaBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.sistemaBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.sistemaBC.update(getBean());
		return getPreviousView();
	}
	
	


}
