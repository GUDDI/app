/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author escritorio
 */
@Entity
@Table(name = "usuario_recursos", catalog = "guddi", schema = "guddi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRecursos.findAll", query = "SELECT u FROM UsuarioRecursos u"),
    @NamedQuery(name = "UsuarioRecursos.findByIdUsuario", query = "SELECT u FROM UsuarioRecursos u WHERE u.usuarioRecursosPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioRecursos.findByRecursos", query = "SELECT u FROM UsuarioRecursos u WHERE u.usuarioRecursosPK.recursos = :recursos"),
    @NamedQuery(name = "UsuarioRecursos.findByOperacao", query = "SELECT u FROM UsuarioRecursos u WHERE u.operacao = :operacao")})
public class UsuarioRecursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioRecursosPK usuarioRecursosPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int operacao;

    public UsuarioRecursos() {
    }

    public UsuarioRecursos(UsuarioRecursosPK usuarioRecursosPK) {
        this.usuarioRecursosPK = usuarioRecursosPK;
    }

    public UsuarioRecursos(UsuarioRecursosPK usuarioRecursosPK, int operacao) {
        this.usuarioRecursosPK = usuarioRecursosPK;
        this.operacao = operacao;
    }

    public UsuarioRecursos(long idUsuario, int recursos) {
        this.usuarioRecursosPK = new UsuarioRecursosPK(idUsuario, recursos);
    }

    public UsuarioRecursosPK getUsuarioRecursosPK() {
        return usuarioRecursosPK;
    }

    public void setUsuarioRecursosPK(UsuarioRecursosPK usuarioRecursosPK) {
        this.usuarioRecursosPK = usuarioRecursosPK;
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioRecursosPK != null ? usuarioRecursosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRecursos)) {
            return false;
        }
        UsuarioRecursos other = (UsuarioRecursos) object;
        if ((this.usuarioRecursosPK == null && other.usuarioRecursosPK != null) || (this.usuarioRecursosPK != null && !this.usuarioRecursosPK.equals(other.usuarioRecursosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.guddi.domain.UsuarioRecursos[ usuarioRecursosPK=" + usuarioRecursosPK + " ]";
    }
    
}
