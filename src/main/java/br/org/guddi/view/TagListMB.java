package br.org.guddi.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.TagBC;
import br.org.guddi.domain.Tag;

@ViewController
@NextView("./tag_edit.jsf")
@PreviousView("./tag_list.jsf")
public class TagListMB extends AbstractListPageBean<Tag, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TagBC tagBC;
	
	@Override
	protected List<Tag> handleResultList() {
		return this.tagBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tagBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}