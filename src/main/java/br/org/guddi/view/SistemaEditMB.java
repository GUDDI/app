package br.org.guddi.view;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.Orgao;
import br.org.guddi.domain.Sistema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ViewController
public class SistemaEditMB {

	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;
	
	@Inject
	private OrgaoBC orgaoBC;
	
	private Descritor descritor;

	@Inject
	private Orgao orgao;

	@Inject
	private Sistema sistema;
	
	private List<Descritor> desc;
	
	
	
	/**
     *
     */
    @PostConstruct
	public void inicia(){
		this.descritor = new Descritor();
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
            desc = new ArrayList<>();
        }
		return Collections.unmodifiableList(desc);
	}
	
	/**
     *
     */
    public void adicionaDescritor() {
		desc.add(this.descritor);
		this.descritor = new Descritor();
		
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
    public void removeDescritor(Integer index){
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
    private static final Logger LOG = Logger.getLogger(SistemaEditMB.class.getName());
	
	


}
