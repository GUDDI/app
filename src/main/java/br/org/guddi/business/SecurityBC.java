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
                    rec.setId(Resources.getResource(recursos));
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
        usuarioDAO.UpdatePassWithAminesia(aminesia, senhanova);
    }

    public void enviarMensagemLembrandoSenha(Usuario usuario) throws Exception {
    	enviarMensagemLembrandoSenha(usuario.getEmail());
    }
    
    public void enviarMensagemLembrandoSenha(String destinatario) throws Exception {
        Usuario usu = usuarioDAO.findByEmail(destinatario);
        String senha = CriptografiaUtil.getCodigoMd5("" + System.currentTimeMillis());
        usu.setAminesia(senha);
        usu.setSenha(senha.substring(21, 27));
        usuarioDAO.update(usu);
        StringBuilder texto = new StringBuilder();
        texto.append(" O sistema GUDDI gerou novos dados para você:")
                .append("\n\r Usuário: ").append(usu.getUsuario())
                .append("\n\r Senha: ").append(usu.getSenha())
                .append("\n\r siga o link para alterar sua senha: ")
                .append(guddiConfig.getUrl()).append(usu.getAminesia());

        mailer.to(destinatario)
                .from(guddiConfig.getRemetente())
                .body().text(texto.toString())
                .subject(guddiConfig.getAssunto())
                .send();
        
    }
}
