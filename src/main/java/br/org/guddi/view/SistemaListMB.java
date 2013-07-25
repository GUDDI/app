package br.org.guddi.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.org.guddi.business.SistemaBC;
import br.org.guddi.domain.Sistema;

/**
 *
 * @author escritorio
 */
@ViewController
@NextView("./sistema_edit.jsf")
@PreviousView("./sistema_list.jsf")
public class SistemaListMB extends AbstractListPageBean<Sistema, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBC sistemaBC;

    @Override
	protected List<Sistema> handleResultList() {
		return this.sistemaBC.findAll();
	}


}