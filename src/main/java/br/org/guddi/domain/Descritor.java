/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
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
 * Conceito de Dominio servicos dentro de um Sistemas. 
 *
 * @author 05081364908
 */
@Entity
@Table(catalog = "guddi", schema = "guddi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descritor.findAll", query = "SELECT d FROM Descritor d"),
    @NamedQuery(name = "Descritor.findById", query = "SELECT d FROM Descritor d WHERE d.id = :id"),
    @NamedQuery(name = "Descritor.findByDescricao", query = "SELECT d FROM Descritor d WHERE d.descricao = :descricao")})
public class Descritor implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;
    
	@Size(max = 100)
    @Column(length = 100)
    private String descricao;
    
	@JoinColumn(name = "id_sistema", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Sistema sistema;

	@OneToMany(mappedBy = "descritor", fetch = FetchType.LAZY)
    private Set<Servico> servicos;
    
	@OneToMany(mappedBy = "descritor", fetch = FetchType.LAZY)
    private Set<Tag> tags;

    public Descritor() {
    }

    public Descritor(Long id) {
        this.id = id;
    }
    
    public Descritor(Long id, String descricao, Sistema sistema) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
	public Set<Servico> getServicos() {
		return servicos;
	}
	
	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public Sistema getSistema() {
		return sistema;
	}

	
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@XmlTransient
    public Set<Tag> getTags() {
		return tags;
	}
	
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
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
        if (!(object instanceof Descritor)) {
            return false;
        }
        Descritor other = (Descritor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Descritor[ id=" + id + " ]";
    }

}
