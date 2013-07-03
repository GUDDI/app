package br.org.guddi.security;

import java.io.Serializable;
import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import java.util.List;

@Named
@SessionScoped
public class Identity implements Serializable, Principal {

    private static final long serialVersionUID = -8003651916557123604L;
    private Boolean isLogged = false;
    private Long id;
    private String name;
    private String login;
    private String password;
    private Long orgao;
    private List<String> papeis;

    @Inject
    private SecurityContext securityContext;
    @Inject
    private MessageContext messageContext;

    public String login() {
        try {
            securityContext.login();
            return "index.html";
        } catch (Exception e) {
            e.printStackTrace();
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    public String logout() {
        try {
            securityContext.logout();
            return "index.jsf";
        } catch (Exception e) {
            e.printStackTrace();
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public List<String> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<String> papeis) {
        this.papeis = papeis;
    }

}
