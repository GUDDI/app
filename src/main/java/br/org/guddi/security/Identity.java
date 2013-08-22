package br.org.guddi.security;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;

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
    private Boolean lembreMeCookie;
    
    @Inject
    private FacesContext facesContext;
    
    @Inject
    private SecurityContext securityContext;
    
    @Inject
    private MessageContext messageContext;
	private Map<Integer, Integer> recursosOperacoes;
    
    /*
     * TODO A Funcionalidade do gravação de Cookie não esta funcionando corretamente. 
     */
    
//  private final String COOKIE_NAME = "guddiCookieLembreMe";
    
    public Identity(){
    	
//    	Cookie cookies[] = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getCookies();
//    	
//    	if(cookies != null) {
//    		for(Cookie cookie : cookies){
//    			if(COOKIE_NAME.equals(cookie.getName())){
//    				System.out.println(" >>>>>>>>>>>>>>>> " + cookie.getValue());
//    				if(!cookie.getValue().isEmpty()){
//    					setUsuario(cookie.getValue());
//    				}
//    			}
//    		}
//    	}
    	
    }

    /**
     *
     * @return
     */
    public String login() {
        try {
            securityContext.login();
            
//            if(lembreMeCookie){
//            	setCookie(COOKIE_NAME, getUsuario());
//            }
            
            return "";
        } 
        catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return null;
        }
    }
    
//    private void setCookie(String cookieName, String cookieValue) {
//        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put("path", "/");
//        
//        facesContext.getExternalContext().addResponseCookie(cookieName, cookieValue, properties);
//    }

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


	public Map<Integer, Integer> getRecursosOperacoes() {
		return recursosOperacoes;
	}

	public void setRecursosOperacoes(Map<Integer, Integer> recursosOperacoes) {
		this.recursosOperacoes = recursosOperacoes;
	}
	
	public Boolean getLembreMeCookie() {
		return lembreMeCookie;
	}

	public void setLembreMeCookie(Boolean lembreMeCookie) {
		this.lembreMeCookie = lembreMeCookie;
	}
}
