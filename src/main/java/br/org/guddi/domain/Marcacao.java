package br.org.guddi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clovis Lemes Ferreira Junior
 */
@Entity
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcacao.findAll", query = "SELECT t FROM Marcacao t"),
    @NamedQuery(name = "Marcacao.findById", query = "SELECT t FROM Marcacao t WHERE t.id = :id"),
    @NamedQuery(name = "Marcacao.findByMarcacao", query = "SELECT t FROM Marcacao t WHERE t.marcacao = :marcacao")})
public class Marcacao implements Serializable {

	private static final long serialVersionUID = 5602366476002683716L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(max = 15)
    @Column(length = 15)
    private String marcacao;

    /**
     *
     */
    public Marcacao() {
    }

    /**
     *
     * @param id
     */
    public Marcacao(Long id) {
        this.id = id;
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
    public String getMarcacao() {
        return marcacao;
    }

    /**
     *
     * @param marcacao
     */
    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcacao)) {
            return false;
        }
        Marcacao other = (Marcacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Marcacao[ id=" + id + " ]";
    }


}
