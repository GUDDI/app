package br.org.guddi.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.guddi.business.PesquisarBC;
import br.org.guddi.constant.GuddiConfig;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.domain.PesquisaFake;
import br.org.guddi.util.search.SearchFilter;

/**
 *
 * @author thiago.soares
 */
@ViewController
@PreviousView("./pesquisa_list.jsf")
@NextView("./detalhamento_servico.jsf")
public class PesquisarMB extends AbstractPageBean {

    private static final long serialVersionUID = -7896379863254694834L;
    @Inject
    private Logger logger;
    @Inject
    private PesquisarBC pesquisarBC;
    private String searchParam;
    private int first, rows;
    private LazyDataModel<Pesquisa> lazyModel;
    private List<PesquisaFake> listRemotoFake;
    private List<PesquisaFake> mobiListRemotoFake;
    
    @Inject
    private GuddiConfig guddiConfig;

    /**
     * Construtor padrão que reinicializa os parametros do paginador
     */
    public PesquisarMB() {
        super();
        first = 0;
        rows = 10;
    }

    /**
     * Utilitario para limpar os creterios de pesquisa
     */
    public void clearSearch() {
        searchParam = "";
        lazyModel = null;
        listRemotoFake = null;
        first = 0;
        rows = 10;
    }

    /**
     * Utilitário para buscar apenas o primeiro resultado de uma pesquisa
     */
    public void searchFirst() {
        first = 0;
        search();
    }

    /**
     * metodo responsavel pela busca do resultado
     */
    public void search() {

        lazyModel = new LazyDataModel<Pesquisa>() {
            private static final long serialVersionUID = -6541913048403958674L;

            @Override
            public List<Pesquisa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

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
        clearSearch();
        searchFirst();
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

    public List<PesquisaFake> getListRemotoFake() {
        List<PesquisaFake> resultado = new ArrayList<PesquisaFake>();

        PesquisaFake pesquisa1 = new PesquisaFake("Ministério da Saúde", "http://guddi.saude.gov.br/", 13);
        PesquisaFake pesquisa2 = new PesquisaFake("Secretaria da Saúde do Paraná", "http://guddi.saude.pr.gov.br/", 3);
        PesquisaFake pesquisa3 = new PesquisaFake("Secretaria da Saúde de Santa Catarina", "http://guddi.saude.sc.gov.br/", 5);
        PesquisaFake pesquisa4 = new PesquisaFake("Secretaria Municipal da Saúde de Curitiba", "http://guddi.saude.curitiba.gov.br/", 1);

        resultado.add(pesquisa1);
        resultado.add(pesquisa2);
        resultado.add(pesquisa3);
        resultado.add(pesquisa4);

        return resultado;
    }

    public List<PesquisaFake> gerartListRemotoFake() {

        return getListRemotoFake();
    }

    public void setListRemotoFake(List<PesquisaFake> listRemotoFake) {
        this.listRemotoFake = listRemotoFake;
    }

    public List<PesquisaFake> getMobiListRemotoFake() {
        return mobiListRemotoFake;
    }

    public void setMobiListRemotoFake(List<PesquisaFake> mobiListRemotoFake) {
        this.mobiListRemotoFake = mobiListRemotoFake;
    }
    
    public Boolean getMostrarAbaRemota(){
    	return guddiConfig.getGuddiZillaEnabled();
    }
}