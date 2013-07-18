package br.org.guddi.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Retorno.findAll", query = "SELECT r FROM Retorno r"),
    @NamedQuery(name = "Retorno.findById", query = "SELECT r FROM Retorno r WHERE r.id = :id"),
    @NamedQuery(name = "Retorno.findByTipo", query = "SELECT r FROM Retorno r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Retorno.findByDescricao", query = "SELECT r FROM Retorno r WHERE r.descricao LIKE :descricao")})
public class Retorno implements Serializable {

	private static final long serialVersionUID = 7517355321528352171L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(length = 100)
    private String tipo;
    
    @Size(max = 300)
    @Column(length = 300)
    private String descricao;

    /**
     *
     */
    public Retorno() {
    }

    /**
     *
     * @param id
     */
    public Retorno(Long id) {
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
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
    *
    * @return
    */
	public String getDescricao() {
		return descricao;
	}

	
	/**
    *
    * @param descricao
    */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
        if (!(object instanceof Retorno)) {
            return false;
        }
        Retorno other = (Retorno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Atributo[ id=" + id + " ]";
    }


}
