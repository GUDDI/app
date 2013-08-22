/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.mail.Mail;
import br.gov.frameworkdemoiselle.mail.internal.Config;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.guddi.constant.GuddiConfig;
import br.org.guddi.domain.Recurso;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.RecursoDAO;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.security.Resources;
import br.org.guddi.util.CriptografiaUtil;

/**
 *
 * @author 70744416353
 */
@BusinessController
public class SecurityBC {

    @Inject
    private Mail mailer;
    
    @Inject
    private RecursoDAO recursoDAO;
    
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Inject
    private GuddiConfig guddiConfig;
    
    @Inject
    private Config config;
    
    @Inject
	private ResourceBundle rb;
    
    /**
     *
     */
    @Startup
    public void bootstrap() {
        try {

            recursoDAO.clear();
            List<String> listarec = Resources.getResourcesList();
            for (String recursos : listarec) {
                Recurso rec = recursoDAO.load(recursos);
                if (rec == null) {
                    rec = new Recurso();
                    rec.setId(Long.valueOf(Resources.getResource(recursos)));
                    rec.setNome(recursos);
                    recursoDAO.insert(rec);
                }

            }


        } catch (Exception e) {
            Logger.getLogger(SecurityBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *
     * @param aminesia
     * @param senhaatual
     * @param senhanova
     */
    public void alteraSenha(String aminesia, String senhanova) throws Exception {
        usuarioDAO.updatePassWithAminesia(aminesia, senhanova);
    }

    public void enviarMensagemLembrandoSenha(Usuario usuario) throws Exception {
    	enviarMensagemLembrandoSenha(usuario.getEmail());
    }
    
    public void enviarMensagemLembrandoSenha(String destinatario) throws Exception {
        Usuario usuario = usuarioDAO.findByEmail(destinatario);
        String senha = CriptografiaUtil.getCodigoMd5("" + System.currentTimeMillis());
        usuario.setAminesia(senha);
        usuario.setSenha(senha.substring(21, 27));
        usuarioDAO.update(usuario);
        
        mailer.to(destinatario)
                .from(guddiConfig.getRemetente())
                .body().text(rb.getString("email.aminesia.texto", usuario.getUsuario(), usuario.getSenha(), guddiConfig.getUrl() + usuario.getAminesia()))
                .subject(guddiConfig.getAssunto())
                .send();
        
    }
}
