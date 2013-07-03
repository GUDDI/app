package br.org.guddi.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.Orgao;
import br.org.guddi.domain.Sistema;

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
	
	
	
	@PostConstruct
	public void inicia(){
		this.descritor = new Descritor();
	}

	public void delete(){
	}
	
	public void insert(){
	}
	
	public List<Orgao> getOrgaos() {
		return orgaoBC.findAll();
	}

	public List<Descritor> getDescritores() {
		if(desc == null)
			desc = new ArrayList<Descritor>();
		return desc;
	}
	
	public void adicionaDescritor() {
		desc.add(this.descritor);
		this.descritor = new Descritor();
		
	}

	public Descritor getDescritor() {
		return descritor;
	}

	public void setDescritor(Descritor descritor) {
		this.descritor = descritor;
	}
	
	public void removeDescritor(Integer index){
		this.desc.remove(index);
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	


}
