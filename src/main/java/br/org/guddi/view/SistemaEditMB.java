package br.org.guddi.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.Orgao;
import br.org.guddi.domain.Servico;
import br.org.guddi.domain.Sistema;
import br.org.guddi.domain.Marcacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ViewController
public class SistemaEditMB {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;

	@Inject
	private OrgaoBC orgaoBC;

	@Inject
	private Orgao orgao;

	@Inject
	private Sistema sistema;
	
	@Inject
	private ServicoBC servicoBC;
	

	private Descritor descritor;
	
	private List<Descritor> desc;
	
	private List<Marcacao> marcacacoes; 

	/**
     *
     */
    @PostConstruct
	public void inicia(){
		this.descritor = new Descritor();
	}

    public boolean updateMode(){
    	if(sistema.getId() != null)
    		return true;
    	
    	return false;
    }
    
	/**
     *
     */
    public void delete(){
	}

	/**
     *
     */
    public void insert(){
	}
    
    public void update(){
    	
    }

	/**
     *
     * @return
     */
    public List<Orgao> getOrgaos() {
		return orgaoBC.findAll();
	}

	/**
     *
     * @return
     */
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
    public Sistema getSistema() {
		return sistema;
	}

	/**
     *
     * @param sistema
     */
    public void setSistema(Sistema sistema) {
		this.sistema = sistema;
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


	public List<Servico> getServicos(){
		return servicoBC.findAll();
	}


}
