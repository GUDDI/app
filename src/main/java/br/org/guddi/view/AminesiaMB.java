package br.org.guddi.view;

import br.gov.frameworkdemoiselle.annotation.NextView;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.SecurityBC;
import br.org.guddi.domain.Usuario;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author escritorio
 */
@ViewController
@NextView("./index.jsf")
public class AminesiaMB extends AbstractEditPageBean<Usuario, Long> {

    private static final long serialVersionUID = 1L;
    @Inject
    private SecurityBC securityBC;
    private String aminesia;
    private String senhaatual;
    private String senhanova;
    private String senharepetida;

    public AminesiaMB() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
        aminesia = req.getParameter("quem");
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional
    public String insert() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional
    public String update() {
        if (aminesia == null){
            return getNextView();
        }
        if (senhanova.equals(senharepetida)) {
            this.securityBC.alteraSenha(aminesia, senhaatual, senhanova);
        } else {
            new Exception("Senha não confere");
        }

        return getNextView();
    }

    /**
     *
     */
    @Override
    protected void handleLoad() {
    }

    /**
     *
     * @return
     */
    @Override
    public String delete() {
        return null;
    }

    /**
     *
     * @return
     */
    public String getAminesia() {
        return aminesia;
    }

    /**
     *
     * @param aminesia
     */
    public void setAminesia(String aminesia) {
        this.aminesia = aminesia;
    }

    /**
     *
     * @return
     */
    public String getSenhaatual() {
        return senhaatual;
    }

    /**
     *
     * @param senhaatual
     */
    public void setSenhaatual(String senhaatual) {
        this.senhaatual = senhaatual;
    }

    /**
     *
     * @return
     */
    public String getSenhanova() {
        return senhanova;
    }

    /**
     *
     * @param senhanova
     */
    public void setSenhanova(String senhanova) {
        this.senhanova = senhanova;
    }

    /**
     *
     * @return
     */
    public String getSenharepetida() {
        return senharepetida;
    }

    /**
     *
     * @param senharepetida
     */
    public void setSenharepetida(String senharepetida) {
        this.senharepetida = senharepetida;
    }
}