/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 05081364908
 */

@Entity
//@Table(catalog = "guddi", schema = "guddi")
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Papel.findAll", query = "SELECT p FROM Papel p"),
    @NamedQuery(name = "Papel.findById", query = "SELECT p FROM Papel p WHERE p.id = :id"),
    @NamedQuery(name = "Papel.findByDescricao", query = "SELECT p FROM Papel p WHERE p.descricao = :descricao")})
public class Papel implements Serializable{
   
    
	private static final long serialVersionUID = -9146098310699200511L;

	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Size(max = 20)
    @Column(length = 20)
    private String descricao;

    public Papel() {
    }

    public Papel(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Papel)) {
            return false;
        }
        Papel other = (Papel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Papel[ id=" + id + " ]";
    }

   }
