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
 *
 * @author 05081364908
 */
@Entity
@Table(catalog = "guddi", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findById", query = "SELECT s FROM Servico s WHERE s.id = :id"),
    @NamedQuery(name = "Servico.findByNome", query = "SELECT s FROM Servico s WHERE s.nome = :nome")})
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;
    @Size(max = 50)
    @Column(length = 50)
    private String nome;
    @OneToMany(mappedBy = "idServico", fetch = FetchType.LAZY)
    private Set<Atributo> atributoSet;
    @JoinColumn(name = "id_descritor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Descritor idDescritor;
    @OneToMany(mappedBy = "idServico", fetch = FetchType.LAZY)
    private Set<Excecao> excecaoSet;

    public Servico() {
    }

    public Servico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Set<Atributo> getAtributoSet() {
        return atributoSet;
    }

    public void setAtributoSet(Set<Atributo> atributoSet) {
        this.atributoSet = atributoSet;
    }

    public Descritor getIdDescritor() {
        return idDescritor;
    }

    public void setIdDescritor(Descritor idDescritor) {
        this.idDescritor = idDescritor;
    }

    @XmlTransient
    public Set<Excecao> getExcecaoSet() {
        return excecaoSet;
    }

    public void setExcecaoSet(Set<Excecao> excecaoSet) {
        this.excecaoSet = excecaoSet;
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
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Servico[ id=" + id + " ]";
    }

}
