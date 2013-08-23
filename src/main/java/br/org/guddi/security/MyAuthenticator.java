package br.org.guddi.security;

import java.security.Principal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.guddi.domain.Usuario;
import br.org.guddi.domain.UsuarioRecurso;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.persistence.UsuarioRecursoDAO;
import br.org.guddi.util.CriptografiaUtil;

/**
 * @author thiago.soares
 */
public class MyAuthenticator implements Authenticator {

    private static final long serialVersionUID = 5348324948048837944L;
    
    @Inject
    private Identity identity;
    
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Inject
    private UsuarioRecursoDAO usuarioRecursoDAO;
    
    @Inject
    private ResourceBundle rb;

    /**
     *
     * @throws AuthenticationException
     */
    @SuppressWarnings("unused")
	@Override
    public void authenticate() throws AuthenticationException {
        Usuario user;
        Map<Integer, Integer> recursosOperacoes = new HashMap<Integer, Integer>();
        
        try {
            user = usuarioDAO.findByUserName(identity.getUsuario());
            
            List<UsuarioRecurso> recursosUsuario = usuarioRecursoDAO.findByUsuario(user.getId());
            
            Iterator<UsuarioRecurso> it = recursosUsuario.iterator();
            
            while(it.hasNext()){
            	UsuarioRecurso usuarioRecurso = it.next();
            	
            	recursosOperacoes.put(usuarioRecurso.getUsuarioRecursosPK().getRecursos(), usuarioRecurso.getOperacao());
            }
            
        } 
        catch (Exception ex) {
            throw new AuthenticationException(rb.getString("login.usuario.nao.existe"), ex);
        }

        if (user == null) {
            throw new AuthenticationException(rb.getString("login.falhou"));
        } else {
            if (!user.getAminesia().isEmpty() && user.getSenha().equals(user.getAminesia().substring(21, 27))) {
                throw new AuthenticationException(rb.getString("login.alteracao.por.email"));
            }
            if (!user.getSenha().equals(CriptografiaUtil.getCodigoMd5(identity.getPassword()))) {
                throw new AuthenticationException(rb.getString("login.falhou"));
            }
        }

        this.identity.setId(user.getId());
        this.identity.setName(user.getNome());
        this.identity.setOrgao(user.getOrgao().getId());
        this.identity.setNomeorgao(user.getOrgao().getNome());
        this.identity.setPapel(Roles.getRole(user.getPapel()).get(0));
        this.identity.setRecursosOperacoes(recursosOperacoes);
        this.identity.setIsLogged(true);
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
