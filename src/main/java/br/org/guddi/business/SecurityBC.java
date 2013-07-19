/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.mail.Mail;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.org.guddi.constant.MailConfig;
import br.org.guddi.domain.Recurso;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.RecursoDAO;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.security.Identity;
import br.org.guddi.security.Resources;

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
    private MailConfig mailConfig;

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
            // LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     *
     * @param aminesia
     * @param senhaatual
     * @param senhanova
     */
    public void alteraSenha(String aminesia, String senhaatual, String senhanova) throws Exception {
        usuarioDAO.UpdatePassWithAminesia(aminesia, senhaatual, senhanova);
    }

    public void enviarMensagemLembrandoSenha(String destinatario) throws Exception {
        Usuario usu = usuarioDAO.findByEmail(destinatario);
        if (usu != null) {
//            mailer.to(destinatario)
//                    .from(mailConfig.getRemetente())
//                    .body().text(mailConfig.getUrl()+usu.getAminesia())
//                    .subject(mailConfig.getAssunto())
//                    .send();
        }else{
            throw new Exception("E-mail não cadastrado");
        }
    }
}
