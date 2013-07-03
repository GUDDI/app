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
    @NamedQuery(name = "UsuarioRecurso.findAll", query = "SELECT u FROM UsuarioRecurso u"),
    @NamedQuery(name = "UsuarioRecurso.findByIdUsuario", query = "SELECT u FROM UsuarioRecurso u WHERE u.usuarioRecursoPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioRecurso.findByRecursos", query = "SELECT u FROM UsuarioRecurso u WHERE u.usuarioRecursoPK.recursos = :recursos"),
    @NamedQuery(name = "UsuarioRecurso.findByOperacao", query = "SELECT u FROM UsuarioRecurso u WHERE u.operacao = :operacao")})
public class UsuarioRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioRecursoPK usuarioRecursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer operacao;

    public UsuarioRecurso() {
    }

    public UsuarioRecurso(UsuarioRecursoPK usuarioRecursoPK) {
        this.usuarioRecursoPK = usuarioRecursoPK;
    }

    public UsuarioRecurso(UsuarioRecursoPK usuarioRecursoPK, Integer operacao) {
        this.usuarioRecursoPK = usuarioRecursoPK;
        this.operacao = operacao;
    }

    public UsuarioRecurso(Long idUsuario, Integer recursos) {
        this.usuarioRecursoPK = new UsuarioRecursoPK(idUsuario, recursos);
    }

    public UsuarioRecursoPK getUsuarioRecursosPK() {
        return usuarioRecursoPK;
    }

    public void setUsuarioRecursosPK(UsuarioRecursoPK usuarioRecursoPK) {
        this.usuarioRecursoPK = usuarioRecursoPK;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioRecursoPK != null ? usuarioRecursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRecurso)) {
            return false;
        }
        UsuarioRecurso other = (UsuarioRecurso) object;
        if ((this.usuarioRecursoPK == null && other.usuarioRecursoPK != null) || (this.usuarioRecursoPK != null && !this.usuarioRecursoPK.equals(other.usuarioRecursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.guddi.domain.UsuarioRecurso[ usuarioRecursoPK=" + usuarioRecursoPK + " ]";
    }

}
