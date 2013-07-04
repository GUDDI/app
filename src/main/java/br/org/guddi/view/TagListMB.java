package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.TagBC;
import br.org.guddi.domain.Tag;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

@ViewController
@NextView("./tag_edit.jsf")
@PreviousView("./tag_list.jsf")
public class TagListMB extends AbstractListPageBean<Tag, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TagBC tagBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Tag> handleResultList() {
		return this.tagBC.findAll();
	}

	/**
     *
     * @return
     */
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