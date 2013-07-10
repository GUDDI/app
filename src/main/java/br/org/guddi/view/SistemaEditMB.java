package br.org.guddi.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.DescritorType;
import br.org.guddi.domain.Excecao;
import br.org.guddi.domain.Marcacao;
import br.org.guddi.domain.Orgao;
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
	private Orgao orgao;

	@Inject
	private ServicoBC servicoBC;
	
	@Inject
	private Identity identity;
	
	private DescritorType tipoDescritor;
	
	private Descritor descritor;
	
	private List<Descritor> desc;
	
	private List<Marcacao> marcacacoes;
	
	@Inject
	private Atributo atributo;
	
	@Inject
	private Excecao excecao;
	
	/**
     *
     */
    @PostConstruct
	public void inicia(){
    	setOrgao(orgaoBC.load(identity.getId()));
		this.descritor = new Descritor();
	}

    public List<Descritor> getDescritores() {
		if(desc == null) {
            desc = new ArrayList<Descritor>();
        }
		return Collections.unmodifiableList(desc);
	}

	/**
     *
     */
    public void adicionaDescritor() {
		desc.add(this.descritor);
		this.descritor = new Descritor();
		System.out.println("Processando");

	}

	/**
     *
     * @return
     */
    public Descritor getDescritor() {
		return descritor;
	}

	/**
     *
     * @param descritor
     */
    public void setDescritor(Descritor descritor) {
		this.descritor = descritor;
	}

	/**
     *
     * @param index
     */
    public void removeDescritor(int index){
		this.desc.remove(index);
	}

	/**
     *
     * @return
     */
    public Orgao getOrgao() {
		return orgao;
	}

	/**
     *
     * @param orgao
     */
    public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

    /**
     * 
     * @return
     */
	public List<Marcacao> getMarcacoes() {
		return marcacacoes;
	}

	/**
	 * 
	 * @param marcacoes
	 */
	public void setMarcacao(Marcacao marcacoes) {
		this.marcacacoes.add(marcacoes);
	}

	public DescritorType getTipoDescritor() {
		return tipoDescritor;
	}

	public void setTipoDescritor(DescritorType tipoDescritor) {
		this.tipoDescritor = tipoDescritor;
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

	/**
     *
     * @return
     */
    public List<Servico> getServicos(){
		return servicoBC.findAll();
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
		this.sistemaBC.delete(getId());
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
