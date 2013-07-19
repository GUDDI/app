/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.constant;

import br.gov.frameworkdemoiselle.configuration.Configuration;

/**
 *
 * @author PauloGladson
 */
@Configuration(resource = "mail")
public class MailConfig {
    
    private String remetente;
    private String assunto;
    private String url;

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
