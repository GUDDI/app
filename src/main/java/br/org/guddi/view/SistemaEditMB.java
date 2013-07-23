package br.org.guddi.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.AtributoBC;
import br.org.guddi.business.DescritorBC;
import br.org.guddi.business.ExcecaoBC;
import br.org.guddi.business.MarcacaoBC;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.business.ServicoBC;
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
	private ServicoBC servicoBC;
	
	@Inject
	private AtributoBC atributoBC;
	
	@Inject
	private ExcecaoBC excecaoBC;
	
	@Inject
	private DescritorBC descritorBC;

	@Inject
	private Identity identity;
	
	@Inject
	private Atributo atributo;
	
	@Inject
	private Excecao excecao;
	
	private Integer abaDescritorAtual = 0;
	
	private List<Descritor> descritores;
	
	private DescritorType tipoDescritor;
	
    public void adicionaDescritor() {
    	Descritor descritor = new Descritor();
    	descritor.setTipo(getTipoDescritor());
    	descritor.setSistema(getBean());
		
		getDescritores().add(descritor);
		setAbaDescritorAtual(getDescritores().size() - 1);
	}
    
    @Transactional
    public void salvarDescritor() {
    	
    	for(Descritor descritor : getDescritores()){
    		if(!descritor.getMarcacoesFormatado().isEmpty()){

    			descritor.setMarcacoes(new ArrayList<Marcacao>());
    			
    			String[] marcacoes = descritor.getMarcacoesFormatado().split(",");
    			
    			for(String marcacaoStr : marcacoes){
    				if(!marcacaoStr.isEmpty()){
	    				Marcacao marcacao = marcacaoBC.findByMarcacao(marcacaoStr.trim());
	    				if(marcacao == null){
	    					marcacao = new Marcacao();
	    					marcacao.setMarcacao(marcacaoStr.trim());
	    					marcacaoBC.insert(marcacao);
	    				}
	    				
	    				descritor.getMarcacoes().add(marcacao);
    				}
    			}
    		}
    		
    	}
    	
    	getBean().getDescritores().clear();
    	getBean().getDescritores().addAll(getDescritores());
    	
    	sistemaBC.update(getBean());
    	
    	getBean().setDescritores(sistemaBC.load(getId()).getDescritores());
    	
		setDescritores(new ArrayList<Descritor>(getBean().getDescritores()));
    }
    
    private void adicionarNovoServico() {
    	for(Descritor descritor : getDescritores()){
	    	if(descritor.getServicos() == null){
				descritor.setServicos(new ArrayList<Servico>());
			}
			
			Boolean existeServicoNovo = Boolean.FALSE; 
			for(Servico servico : descritor.getServicos()){
				if(servico.getId() == null){
					existeServicoNovo = Boolean.TRUE;
					break;
				}
			}
			
			if(!existeServicoNovo){
				descritor.getServicos().add(new Servico());
			}
    	}
	}

	@Transactional
    public void removerDescritor(Descritor descritor){
    	
		if(descritor.getServicos() != null){
			
			for(Servico servico : descritor.getServicos()){
				if(servico.getId() != null){
					if(servico.getAtributos() != null){
						for(Atributo atributo : servico.getAtributos()){
							atributoBC.delete(atributo.getId());
						}
						servico.getAtributos().clear();
					}
					
					if(servico.getExcecoes() != null){
						for(Excecao excecao : servico.getExcecoes()){
							excecaoBC.delete(excecao.getId());
						}
						servico.getExcecoes().clear();
					}
					
					servicoBC.delete(servico.getId());
				}
			}
			
			descritor.getServicos().clear();
		}
		
		getBean().getDescritores().remove(descritor);
		descritorBC.delete(descritor.getId());
		
		sistemaBC.update(getBean());
		
		getBean().setDescritores(sistemaBC.load(getId()).getDescritores());
    	
		setDescritores(new ArrayList<Descritor>(getBean().getDescritores()));
    }
    
    @Transactional
    public void adicionarServico(Descritor descritor){
    	
    	for(Servico servico : descritor.getServicos()){
    		//Novo serviço
    		if(servico.getId() == null){
    			servico.setDescritor(descritor);
    			servicoBC.insert(servico);
    		}
    		else{
    			servicoBC.update(servico);
    		}
    	}
    	
		setDescritores(new ArrayList<Descritor>(sistemaBC.load(getId()).getDescritores()));
		
		int posicao = 0;
		for(Descritor desc: getDescritores()){
			if(desc.getId() != null){
				if(desc.getId().equals(descritor.getId())){
					setAbaDescritorAtual(posicao);
				}
			}
			posicao++;
		}
    	
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
		adicionarNovoServico();
	}

	@Override
	protected void handleLoad() {
		setBean(this.sistemaBC.load(getId()));
		setDescritores(new ArrayList<Descritor>(getBean().getDescritores()));
		adicionarNovoServico();
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

	public Integer getAbaDescritorAtual() {
		return abaDescritorAtual;
	}

	public void setAbaDescritorAtual(Integer abaDescritorAtual) {
		this.abaDescritorAtual = abaDescritorAtual;
	}


}
