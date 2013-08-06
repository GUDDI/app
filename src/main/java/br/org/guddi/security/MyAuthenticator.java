package br.org.guddi.security;

import java.security.Principal;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.util.CriptografiaUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author thiago.soares
 */
public class MyAuthenticator implements Authenticator {

    private static final long serialVersionUID = 5348324948048837944L;
    
    @Inject
    private Identity identity;
    
    @Inject
    private UsuarioDAO usuarioDAO;

    /**
     *
     * @throws AuthenticationException
     */
    @Override
    public void authenticate() throws AuthenticationException {
        Usuario user;
        
        try {
            user = usuarioDAO.findByUserName(identity.getUsuario());
        } catch (Exception ex) {
            throw new AuthenticationException("Usuário não existe.", ex);
        }

        if (user == null) {
            throw new AuthenticationException("O login falhou.");
        } else {
            if (!user.getAminesia().isEmpty() && user.getSenha().equals(user.getAminesia().substring(21, 27))) {
                throw new AuthenticationException("Você deve alterar sua senha apartir do email que o sistema mandou");
            }
            if (!user.getSenha().equals(CriptografiaUtil.getCodigoMd5(identity.getPassword()))) {
                throw new AuthenticationException("O login falhou.");
            }
        }

        this.identity.setId(user.getId());
        this.identity.setName(user.getNome());
        this.identity.setOrgao(user.getOrgao().getId());
        this.identity.setNomeorgao(user.getOrgao().getNome());
        this.identity.setPapel(Roles.getRole(user.getPapel()).get(0));

    }

    /**
     *
     */
    @Override
    public void unAuthenticate() {
        this.identity = null;
    }

    /**
     *
     * @return
     */
    @Override
    public Principal getUser() {

        if (this.identity != null && this.identity.getId() != null) {
            return this.identity;
        } else {
            return null;
        }
    }

}
