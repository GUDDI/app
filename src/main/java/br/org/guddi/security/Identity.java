package br.org.guddi.security;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import java.io.Serializable;
import java.security.Principal;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

    public String login() {
        try {
            securityContext.login();
            return "index.html";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    public String logout() {
        try {
            securityContext.logout();
            return "index.jsf";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgao() {
        return orgao;
    }

    public void setOrgao(Long orgao) {
        this.orgao = orgao;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getNomeorgao() {
        return nomeorgao;
    }

    public void setNomeorgao(String nomeorgao) {
        this.nomeorgao = nomeorgao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
