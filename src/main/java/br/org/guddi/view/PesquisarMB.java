package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.guddi.business.PesquisarBC;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.util.search.SearchFilter;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;

//@Named
//@Controller
//@ConversationScoped
//@ViewController
//@Named
//@SessionScoped
/**
 *
 * @author escritorio
 */
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
    private Logger logger;

    /**
     *
     */
    public PesquisarMB() {
        super();
        first = 0;
        rows = 10;
    }

    /**
     *
     */
    public void clearSearch() {
        searchParam = "";
        lazyModel = null;
    }

    /**
     *
     */
    public void searchFirst() {
        first = 0;
        search();
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public String init() {
        //beginConversation();
        clear();
        clearSearch();
        searchFirst();
        return getPreviousView();
    }

    /**
     *
     */
    public void clear() {
        //model = null;
    }

    /**
     *
     * @return
     */
    public String back() {
        clear();
        search();
        return getPreviousView();
    }

    /**
     *
     * @return
     */
    public LazyDataModel<Pesquisa> getLazyModel() {
        return lazyModel;
    }

    /**
     *
     * @return
     */
    public String getSearchParam() {
        return searchParam;
    }

    /**
     *
     * @param searchParam
     */
    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    /**
     *
     * @param lazyModel
     */
    public void setLazyModel(LazyDataModel<Pesquisa> lazyModel) {
        this.lazyModel = lazyModel;
    }

    /**
     *
     * @return
     */
    public int getFirst() {
        return first;
    }

    /**
     *
     * @param first
     */
    public void setFirst(int first) {
        this.first = first;
    }

    /**
     *
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     *
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
}