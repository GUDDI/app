package br.org.guddi.view;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.guddi.business.PesquisarBC;
import br.org.guddi.business.ServicoBC;
import br.org.guddi.constant.Constants;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.domain.Servico;
import br.org.guddi.util.searh.SearchFilter;


//@Named
//@Controller
//@ConversationScoped

//@ViewController

//@Named
//@SessionScoped

@ViewController
@PreviousView("./pesquisa_list.jsf")
@NextView("./detalhamento_servico.jsf")
public class PesquisarMB extends AbstractPageBean {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private PesquisarBC pesquisarBC;
    
    
    private String searchParam;
    
    private LazyDataModel<Pesquisa> lazyModel;

	private int first, rows;

	 //TODO sera o objeto com o detalhamento da consulta
    
    //@Inject
	//private Conversation conversation;
    
    @Inject
	private MessageContext message;

	@Inject
	private Logger logger;
    
	
	public PesquisarMB() {
		super();
		first = 0;
		rows = 10;
	}
    
	/*Search*/
	
    public void clearSearch() {
    	searchParam = "";
		lazyModel = null;
	}

    public void searchFirst() {
		first = 0;
		search();
	}
    
    public void search() {
    	
    	//beginConversation();
    	
    	lazyModel = new LazyDataModel<Pesquisa>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<Pesquisa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
				/*
				logger.info("BEGIN: load");
				logger.warn("[first      ][" + first + "]");
				logger.warn("[pageSize   ][" + pageSize + "]");
				logger.warn("[sortField  ][" + sortField + "]");
				logger.warn("[sortOrder  ][" + sortOrder + "]");
				logger.warn("[filters    ][" + filters + "]");
				logger.warn("[searchParam         ][" + searchParam + "]");
				*/
				
				pesquisarBC.searhValidation(searchParam);
				
				int count = pesquisarBC.count(searchParam);
				lazyModel.setRowCount(count);
				if (count > 0) {
					if (first > count) {
						// Go to last page
						first = (count / pageSize) * pageSize;
					}
					SearchFilter parameters = new SearchFilter();
					parameters.setFirst(first);
					parameters.setPageSize(pageSize);
					List<Pesquisa> list = pesquisarBC.search(searchParam, parameters);
					logger.info("END: load");
					return list;
				} else {
					return null;
				}
			}
		};
	}


    /*Conversation and navigations Control*/
    
    public String init() {
		//beginConversation();
		clear();
		clearSearch();
		searchFirst();
		return getPreviousView();
	}
    
    /*private boolean beginConversation() {
		if (conversation.isTransient()) {
			conversation.setTimeout(Constants.CONVERSATION_TIMEOUT);
			conversation.begin();
			return true;
		}
		return false;
	}*/
    public void clear() {
		//model = null;
	}
    
    
    
    public String back() {
		clear();
		search();
		return getPreviousView();
	}
    
    /*Getters and Setters*/

	public LazyDataModel<Pesquisa> getLazyModel() {
		return lazyModel;
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public void setLazyModel(LazyDataModel<Pesquisa> lazyModel) {
		this.lazyModel = lazyModel;
	}

	
	public int getFirst() {
		return first;
	}
	
	public void setFirst(int first) {
		this.first = first;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}