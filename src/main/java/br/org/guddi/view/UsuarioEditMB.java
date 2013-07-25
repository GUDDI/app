package br.org.guddi.view;

import java.util.HashMap;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.UsuarioBC;
import br.org.guddi.domain.Orgao;
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
	private MessageContext messageContext;
	
	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private Orgao orgao;
	
    @Override
	@Transactional
	public String delete() {
		throw new UnsupportedOperationException();
	}
    
    @Transactional
    public String ativar(){
		getBean().setIsAtivo(Boolean.TRUE);
    	this.usuarioBC.update(getBean());
    	
    	messageContext.add("{usuario-ativo-ok}");
    	
    	return getPreviousView();
    }
    
    @Transactional
    public String inativar(){
    	getBean().setIsAtivo(Boolean.FALSE);
    	this.usuarioBC.update(getBean());
    	
    	messageContext.add("{usuario-inativo-ok}");
    	
    	return getPreviousView();
    }
	
    @Override
	@Transactional
	public String insert() {
        String senha = CriptografiaUtil.getCodigoMd5(""+System.currentTimeMillis());
        getBean().setAminesia(senha);
        getBean().setSenha(senha.substring(21, 27));
        getBean().setOrgao(getOrgao());
        getBean().setIsAtivo(Boolean.FALSE);
        
		this.usuarioBC.insert(getBean());
		
		messageContext.add("{usuario-insert-ok}", getBean().getUsuario());
    	
		return getPreviousView();
	}
	
    @Override
	@Transactional
	public String update() {
    	throw new UnsupportedOperationException();
	}
	
    @Override
	protected void handleLoad() {
		setBean(this.usuarioBC.load(getId()));
		setOrgao(getBean().getOrgao());
	}

    public HashMap<Short, String> getPapeis(){
		return Roles.getRolesListAsMap();
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}
	
	@ExceptionHandler
	private void tratarExcecao(Exception e){
		messageContext.add("{guddi.erro.generico}", SeverityType.ERROR);
	}
    

}