/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.frameworkdemoiselle.guddi.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author 05081364908
 */
@Entity
@Table(catalog = "guddi", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descritor.findAll", query = "SELECT d FROM Descritor d"),
    @NamedQuery(name = "Descritor.findById", query = "SELECT d FROM Descritor d WHERE d.id = :id"),
    @NamedQuery(name = "Descritor.findByDescricao", query = "SELECT d FROM Descritor d WHERE d.descricao = :descricao")})
public class Descritor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;
    @Size(max = 100)
    @Column(length = 100)
    private String descricao;
    @OneToMany(mappedBy = "idDescritor", fetch = FetchType.LAZY)
    private Set<Servico> servicoSet;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sistema idSistema;
    @OneToMany(mappedBy = "idDescritor", fetch = FetchType.LAZY)
    private Set<Tag> tagSet;

    public Descritor() {
    }

    public Descritor(Long id) {
        this.id = id;
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
    public Set<Servico> getServicoSet() {
        return servicoSet;
    }

    public void setServicoSet(Set<Servico> servicoSet) {
        this.servicoSet = servicoSet;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    @XmlTransient
    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
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
