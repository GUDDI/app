package br.org.guddi.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.org.guddi.business.UsuarioBC;
import br.org.guddi.domain.Usuario;

/**
 *
 * @author escritorio
 */
@ViewController
@NextView("./usuario_edit.jsf")
@PreviousView("./usuario_list.jsf")
public class UsuarioListMB extends AbstractListPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarioFiltro;

	@Inject
	private UsuarioBC usuarioBC;

	/**
     *
     * @return
     */
    @Override
	protected List<Usuario> handleResultList() {
		return this.usuarioBC.findAll();
	}

	public List<Usuario> getUsuarioFiltro() {
		return usuarioFiltro;
	}

	public void setUsuarioFiltro(List<Usuario> usuarioFiltro) {
		this.usuarioFiltro = usuarioFiltro;
	}


}