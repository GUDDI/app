package br.org.guddi.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.UsuarioBC;
import br.org.guddi.domain.Usuario;
import br.org.guddi.security.Roles;
import br.org.guddi.util.CriptografiaUtil;

/**
 *
 * @author escritorio
 */
@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
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
                String senha = CriptografiaUtil.getCodigoMd5(""+System.currentTimeMillis());
                getBean().setAminesia(senha);
                getBean().setSenha(senha.substring(21, 6));
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

	/**
     *
     * @return
     */
    public List<String> getPapeis(){
		return Roles.getRolesList();
	}

}