package br.org.guddi.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.TagBC;
import br.org.guddi.domain.Tag;

@ViewController
@PreviousView("./tag_list.jsf")
public class TagEditMB extends AbstractEditPageBean<Tag, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TagBC tagBC;
	
	@Override
	@Transactional
	public String delete() {
		this.tagBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tagBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tagBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.tagBC.load(getId()));
	}

}