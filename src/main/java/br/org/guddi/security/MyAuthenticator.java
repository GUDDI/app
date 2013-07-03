package br.org.guddi.security;

import java.security.Principal;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.org.guddi.business.SecurityBC;
import br.org.guddi.domain.Papel;
import br.org.guddi.domain.Usuario;
import br.org.guddi.util.CriptografiaUtil;
import java.util.ArrayList;

/**
 * @author thiago.soares
 */
public class MyAuthenticator implements Authenticator {

	private static final long serialVersionUID = -5348324948048837944L;

	@Inject
	private Identity identity;

	@Inject
	private SecurityBC securityBC;

	@Inject
	private SecurityContext securityContext;

	@Override
	public void authenticate() throws AuthenticationException {
		Usuario user = securityBC.findByLogin(identity.getLogin());

		if(user == null) {
			throw new AuthenticationException("O login falhou.");
		} else {
			if(!user.getSenha().equals(CriptografiaUtil.getCodigoMd5(identity.getPassword()))) {
				throw new AuthenticationException("O login falhou.");
			}
		}

		this.identity.setId(user.getId());
                this.identity.setName(user.getNome());
                this.identity.setOrgao(user.getOrgao().getId());
                this.identity.setPapeis(new ArrayList<String>());
                for(Papel p : user.getPapeis()){
                    this.identity.getPapeis().add(p.getDescricao());
                }

	}

	@Override
	public void unAuthenticate() {
		this.identity = null;
	}

	@Override
	public Principal getUser() {

		if (this.identity != null && this.identity.getId() != null) {
			return this.identity;
		}
		else {
			return null;
		}
	}

}
