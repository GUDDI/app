package br.org.guddi.view;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.guddi.security.Roles;

/**
 *
 * @author escritorio
 */
@ViewController
public class PapelListMB {
	
	private List<String> resultList;
	
	/**
     *
     * @return
     */
    protected List<String> getResultList() {
		this.resultList = Roles.getRolesList();
		
		return this.resultList;
	}

}