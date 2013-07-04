package br.org.guddi.security;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.org.guddi.business.SecurityBC;
import br.org.guddi.domain.Usuario;
import br.org.guddi.util.CriptografiaUtil;
import java.security.Principal;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * @author thiago.soares
 */
public class MyAuthenticator implements Authenticator {

    private static final long serialVersionUID = 5348324948048837944L;
    @Inject
    private Identity identity;
    @Inject
    private SecurityBC securityBC;

    /**
     *
     * @throws AuthenticationException
     */
    @Override
    public void authenticate() throws AuthenticationException {
        Usuario user = securityBC.findByEmail(identity.getEmail());

        if (user == null) {
            throw new AuthenticationException("O login falhou.");
        } else {
            if (!user.getSenha().equals(CriptografiaUtil.getCodigoMd5(identity.getPassword()))) {
                throw new AuthenticationException("O login falhou.");
            }
        }

        this.identity.setId(user.getId());
        this.identity.setName(user.getNome());
        this.identity.setOrgao(user.getOrgao().getId());
        this.identity.setNomeorgao(user.getOrgao().getNome());
        this.identity.setPapel(user.getPapel().getDescricao());

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
    private static final Logger LOG = Logger.getLogger(MyAuthenticator.class.getName());
}
