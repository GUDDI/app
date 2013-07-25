package br.org.guddi.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
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
	
	private Integer abaDescritorAtual = 0;
	
	private Integer abaServicoAtual = 0;
	
	private Integer abaComplementarAtual = 0;
	
	private List<Descritor> descritores;
	
	private DescritorType tipoDescritor;
	
	@Inject
	private MessageContext messageContext;
	
    public void adicionaDescritor() {
    	Descritor descritor = new Descritor();
    	descritor.setTipo(getTipoDescritor());
    	descritor.setSistema(getBean());
		
    	if(getDescritores() == null){
    		setDescritores(new ArrayList<Descritor>());
    	}
    	
    	
    	Boolean existeDescritorNovo = Boolean.FALSE;
    	for(Descritor descritorNovo : getDescritores()){
    		if(descritorNovo.getId() == null){
    			existeDescritorNovo = Boolean.TRUE;
    		}
    	}
    	
    	if(!existeDescritorNovo){
    		getDescritores().add(descritor);
    		setAbaDescritorAtual(getDescritores().size() - 1);
    		setAbaServicoAtual(new Integer(0));
    		setAbaComplementarAtual(new Integer(0));
    	}
	}
    
    @Transactional
    public void salvarDescritor(Descritor descritor) {
    	
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
		
		if(descritor.getId() == null){
			descritorBC.insert(descritor);
			messageContext.add("{descritor-insert-ok}", descritor.getNome());
		}
		else{
			descritorBC.update(descritor);
			messageContext.add("{descritor-update-ok}", descritor.getNome());
		}
		
		ajustarAbas(descritor, null);
		
    	adicionarNovoServico();
    }
    
    private void ajustarAbas(Descritor descritor, Servico servico) {
		
    	int posicaoDescritor = 0;
		for(Descritor desc: getDescritores()){
			if(desc.getId() != null){
				if(desc.getId().equals(descritor.getId())){
					setAbaDescritorAtual(posicaoDescritor);
					break;
				}
			}
			posicaoDescritor++;
		}
		
		if(servico != null){
						
			Integer posicaoServico = new Integer(0);
			for(Servico serv : descritor.getServicos()){
				if(serv.getId() != null){
					if(serv.getId().equals(servico.getId())){
						setAbaServicoAtual(posicaoServico);
						break;
					}
				}
				posicaoServico++;
			}
		}
		else{
			setAbaServicoAtual(new Integer(0));
		}
		
		setAbaComplementarAtual(new Integer(0));
		
	}

	private void adicionarNovoServico() {
    	for(Descritor descritor : getDescritores()){
	    	if(descritor.getServicos() == null){
				descritor.setServicos(new ArrayList<Servico>());
			}
			
			Boolean existeServicoNovo = Boolean.FALSE; 
			for(Servico servico : descritor.getServicos()){
				
				if(servico.getAtributos() == null){
	    			servico.setAtributos(new ArrayList<Atributo>());
	    		}
	    		
	    		if(servico.getExcecoes() == null){
	    			servico.setExcecoes(new ArrayList<Excecao>());
	    		}
	    		
				if(servico.getId() == null){
					existeServicoNovo = Boolean.TRUE;					
				}
				
				Boolean existeNovoAtributo = Boolean.FALSE;
    			for(Atributo atributo : servico.getAtributos()){
    				if(atributo.getId() == null){
    					existeNovoAtributo = Boolean.TRUE;
    				}
    			}
    			
    			if(!existeNovoAtributo){
    				servico.getAtributos().add(new Atributo());
    			}
    			
    			Boolean existeNovaExcecao = Boolean.FALSE;
    			for(Excecao excecao : servico.getExcecoes()){
    				if(excecao.getId() == null){
    					existeNovaExcecao = Boolean.TRUE;
    				}
    			}
    			
    			if(!existeNovaExcecao){
    				servico.getExcecoes().add(new Excecao());
    			}
			}
			
			if(!existeServicoNovo){
				descritor.getServicos().add(new Servico());
				setAbaServicoAtual(descritor.getServicos().size() - 2);
				setAbaComplementarAtual(new Integer(0));
			}
    	}
	}

	@Transactional
    public void removerDescritor(Descritor descritor){
		
		descritor = descritorBC.load(descritor.getId());
    	
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
		
		getDescritores().remove(descritor);
		descritorBC.delete(descritor.getId());
		
		adicionarNovoServico();
    }
    
    @Transactional
    public void salvarServico(Descritor descritor){
    	
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
    	
		ajustarAbas(descritor, null);
		
		adicionarNovoServico();
    }
    
    @Transactional
    public void atualizarServico(Servico servico){
    		
		servicoBC.update(servico);
		
		ajustarAbas(servico.getDescritor(), servico);
		
    }
    
    @Transactional
    public void removerServico(Servico servico){
    	
    	servico = servicoBC.load(servico.getId());
    	
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
		
		ajustarAbas(servico.getDescritor(), servico);
		
		servicoBC.delete(servico.getId());
		
		adicionarNovoServico();
    }
    
    @Transactional
    public void salvarAtributo(Servico servico, Atributo atributo){
    	
    	atributo.setServico(servico);
    	
    	if(servico.getAtributos() == null){
    		servico.setAtributos(new ArrayList<Atributo>());
    	}
    	
    	atributoBC.insert(atributo);
    	
    	servico.getAtributos().add(new Atributo());
    	
    	ajustarAbas(servico.getDescritor(), servico);
    	
    }
    
    @Transactional
    public void removerAtributo(Servico servico, Atributo atributo){
    	
    	servico.getAtributos().remove(atributo);
    	atributoBC.delete(atributo.getId());
    	
    	ajustarAbas(servico.getDescritor(), servico);
    }
    
    @Transactional
    public void salvarExcecao(Servico servico, Excecao excecao){
    	
    	excecao.setServico(servico);
    	
    	if(servico.getExcecoes() == null){
    		servico.setExcecoes(new ArrayList<Excecao>());
    	}
    	
    	excecaoBC.insert(excecao);
    	
    	servico.getExcecoes().add(new Excecao());
    	
    	ajustarAbas(servico.getDescritor(), servico);
		
		setAbaComplementarAtual(new Integer(1));
    }
    
    @Transactional
    public void removerExcecao(Servico servico, Excecao excecao){
    	
    	servico.getExcecoes().remove(excecao);
    	excecaoBC.delete(excecao.getId());
    	
    	ajustarAbas(servico.getDescritor(), servico);
		
		setAbaComplementarAtual(new Integer(1));
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
		
		if(getDescritores() != null){
			Iterator<Descritor> itDescritor = getDescritores().iterator();
			
			while(itDescritor.hasNext()){
			
				Descritor descritor = itDescritor.next();
				
				if(descritor.getId() != null){
				
					if(descritor.getServicos() != null){
						
						Iterator<Servico> itServico = descritor.getServicos().iterator();
						while(itServico.hasNext()){
							
							Servico servico = itServico.next();
								
							if(servico.getId() != null){
								if(servico.getAtributos() != null){
									for(Atributo atributo : servico.getAtributos()){
										if(atributo.getId() != null){
											atributoBC.delete(atributo.getId());
										}
									}
									servico.getAtributos().clear();
								}
								
								if(servico.getExcecoes() != null){
									for(Excecao excecao : servico.getExcecoes()){
										if(excecao.getId() != null){
											excecaoBC.delete(excecao.getId());
										}
									}
									servico.getExcecoes().clear();
								}
								
								servicoBC.delete(servico.getId());
							}
						}
						
						descritor.getServicos().clear();
					}
					
					descritorBC.delete(descritor.getId());
				}
			}
		}
		
		this.sistemaBC.delete(getBean().getId());
		
		messageContext.add("{sistema-delete-ok}", getBean().getNome());
		
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		getBean().setOrgao(orgaoBC.load(identity.getOrgao()));
		this.sistemaBC.insert(getBean());
		
		messageContext.add("{sistema-insert-ok}", getBean().getNome());
		
		return "";
	}

	@Override
	@Transactional
	public String update() {
		getBean().setOrgao(orgaoBC.load(identity.getOrgao()));
		this.sistemaBC.update(getBean());
		
		messageContext.add("{sistema-update-ok}", getBean().getNome());
		
		return "";
	}
	
	public Integer getAbaDescritorAtual() {
		return abaDescritorAtual;
	}

	public void setAbaDescritorAtual(Integer abaDescritorAtual) {
		this.abaDescritorAtual = abaDescritorAtual;
	}

	public Integer getAbaServicoAtual() {
		return abaServicoAtual;
	}

	public void setAbaServicoAtual(Integer abaServicoAtual) {
		this.abaServicoAtual = abaServicoAtual;
	}

	public Integer getAbaComplementarAtual() {
		return abaComplementarAtual;
	}

	public void setAbaComplementarAtual(Integer abaComplementarAtual) {
		this.abaComplementarAtual = abaComplementarAtual;
	}
	
	@ExceptionHandler
	private void tratarExcecao(Exception e){
		messageContext.add("{guddi.erro.generico}", SeverityType.ERROR);
	}

}
