package br.org.guddi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clovis Lemes Ferreira Junior
 */
@Entity
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findById", query = "SELECT s FROM Sistema s WHERE s.id = :id"),
    @NamedQuery(name = "Sistema.findByNome", query = "SELECT s FROM Sistema s WHERE s.nome = :nome")})
public class Sistema implements Serializable {

	private static final long serialVersionUID = 833945106894289319L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;

	@Size(max = 100)
    @Column(length = 100)
    private String nome;

	@JoinColumn(name = "id_orgao", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;

	@OneToMany(mappedBy = "sistema", fetch = FetchType.LAZY)
    private List<Descritor> descritores;
	
	@Column(name="publico")
	private Boolean isPublico = Boolean.TRUE;

    /**
     *
     */
    public Sistema() {
    }

    /**
     *
     * @param id
     */
    public Sistema(Long id) {
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


	/**
     *
     * @return
     */
    public Orgao getOrgao() {
		return orgao;
	}


	/**
     *
     * @param orgao
     */
    public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	/**
     *
     * @return
     */
    @XmlTransient
	public List<Descritor> getDescritores() {
		return descritores;
	}


	/**
     *
     * @param descritores
     */
    public void setDescritores(List<Descritor> descritores) {
		this.descritores = descritores;
	}

	public Boolean getIsPublico() {
		return isPublico;
	}

	public void setIsPublico(Boolean isPublico) {
		this.isPublico = isPublico;
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
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Sistema[ id=" + id + " ]";
    }


}
