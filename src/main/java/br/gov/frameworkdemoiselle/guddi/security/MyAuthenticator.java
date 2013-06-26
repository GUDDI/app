package br.gov.frameworkdemoiselle.guddi.security;

import java.security.Principal;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.guddi.business.UsuarioBC;
import br.gov.frameworkdemoiselle.guddi.domain.Usuario;
import br.gov.frameworkdemoiselle.guddi.util.CriptografiaUtil;
import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;

/**
 * @author thiago.soares
 */
public class MyAuthenticator implements Authenticator {

	private static final long serialVersionUID = -5348324948048837944L;

	@Inject
	private Identity identity;
	
	@Inject
	private UsuarioBC usuarioBC;

	@Override
	public void authenticate() throws AuthenticationException {
		Usuario user = usuarioBC.findByLogin(identity.getLogin());
		
		if(user == null) {
			throw new AuthenticationException("O login falhou.");
		} else {
			if(!user.getSenha().equals(CriptografiaUtil.getCodigoMd5(identity.getPassword()))) {
				throw new AuthenticationException("O login falhou.");
			}
		}
		
		this.identity.setId(user.getId());
		this.identity.setIsLogged(true);
		this.identity.setName(user.getNome());
	}

	@Override
	public void unAuthenticate() {

		this.identity = null;

	}

	@Override
	public Principal getUser() {
		if (this.identity != null && this.identity.getIsLogged()) {
			return this.identity;
		} else {
			return null;
		}
	}

}
