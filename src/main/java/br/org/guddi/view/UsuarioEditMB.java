package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.UsuarioBC;
import br.org.guddi.domain.Papel;
import br.org.guddi.domain.Usuario;
import br.org.guddi.security.Roles;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
	private List<Papel> papeis;

	@Inject
	private UsuarioBC usuarioBC;
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String insert() {
		this.usuarioBC.insert(getBean());
		return getPreviousView();
	}
	
	/**
     *
     * @return
     */
    @Override
	@Transactional
	public String update() {
		this.usuarioBC.update(getBean());
		return getPreviousView();
	}
	
	/**
     *
     */
    @Override
	protected void handleLoad() {
		setBean(this.usuarioBC.load(getId()));
	}

	public List<Papel> getPapeis(){

		this.papeis = new ArrayList<Papel>();
		
		List<String> roles = Roles.getRolesList();
		for (String role : roles) {
			Papel papel = new Papel();
			papel.setId(Roles.getRole(role));
			papel.setDescricao(role);
			this.papeis.add(papel);
		}
		
		return this.papeis;
	}

}