package br.org.guddi.security;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import java.io.Serializable;
import java.security.Principal;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author escritorio
 */
@Named
@SessionScoped
public class Identity implements Serializable, Principal {

    private static final long serialVersionUID = 8003651916557123604L;
    private Boolean isLogged = false;
    private Long id;
    private String name;
    private String email;
    private String usuario;
    private String password;
    private Long orgao;
    private String nomeorgao;
    private String papel;
    @Inject
    private SecurityContext securityContext;
    @Inject
    private MessageContext messageContext;

    /**
     *
     * @return
     */
    public String login() {
        try {
            securityContext.login();
            return "index.html";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String logout() {
        try {
            securityContext.logout();
            return "index.jsf";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Boolean getIsLogged() {
        return isLogged;
    }

    /**
     *
     * @param isLogged
     */
    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getOrgao() {
        return orgao;
    }

    /**
     *
     * @param orgao
     */
    public void setOrgao(Long orgao) {
        this.orgao = orgao;
    }

    /**
     *
     * @return
     */
    public String getPapel() {
        return papel;
    }

    /**
     *
     * @param papel
     */
    public void setPapel(String papel) {
        this.papel = papel;
    }

    /**
     *
     * @return
     */
    public String getNomeorgao() {
        return nomeorgao;
    }

    /**
     *
     * @param nomeorgao
     */
    public void setNomeorgao(String nomeorgao) {
        this.nomeorgao = nomeorgao;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
