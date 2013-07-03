/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author escritorio
 */
@Embeddable
public class UsuarioRecursosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer recursos;

    public UsuarioRecursosPK() {
    }

    public UsuarioRecursosPK(Long idUsuario, Integer recursos) {
        this.idUsuario = idUsuario;
        this.recursos = recursos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(Integer recursos) {
        this.recursos = recursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Long) idUsuario;
        hash += (Integer) recursos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRecursosPK)) {
            return false;
        }
        UsuarioRecursosPK other = (UsuarioRecursosPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.recursos != other.recursos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.guddi.domain.UsuarioRecursosPK[ idUsuario=" + idUsuario + ", recursos=" + recursos + " ]";
    }

}
