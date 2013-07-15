package br.org.guddi.view;

import java.util.HashSet;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.DescritorType;
import br.org.guddi.domain.Excecao;
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
	private Identity identity;
	
	@Inject
	private Atributo atributo;
	
	@Inject
	private Excecao excecao;
	
	private Descritor descritorNovo;
	
	private DescritorType tipoDescritor;
	
    public void adicionaDescritor() {
    	setDescritorNovo(new Descritor());
		getDescritorNovo().setTipo(getTipoDescritor());
		getDescritorNovo().setSistema(getBean());
		
		if(getBean().getDescritores() == null){
			getBean().setDescritores(new HashSet<Descritor>());
		}
		
		getBean().getDescritores().add(getDescritorNovo());
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

	@Override
	protected void handleLoad() {
		setBean(this.sistemaBC.load(getId()));
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
