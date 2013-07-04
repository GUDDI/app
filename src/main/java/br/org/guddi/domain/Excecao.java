/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;
import java.util.logging.Logger;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 05081364908
 */
@Entity
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Excecao.findAll", query = "SELECT e FROM Excecao e"),
    @NamedQuery(name = "Excecao.findById", query = "SELECT e FROM Excecao e WHERE e.id = :id"),
    @NamedQuery(name = "Excecao.findByIdentificador", query = "SELECT e FROM Excecao e WHERE e.identificador = :identificador"),
    @NamedQuery(name = "Excecao.findByDescricao", query = "SELECT e FROM Excecao e WHERE e.descricao = :descricao")})
public class Excecao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;

	@Size(max = 20)
    @Column(length = 20)
    private String identificador;

	@Size(max = 255)
    @Column(length = 255)
    private String descricao;

	@JoinColumn(name = "id_servico", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Servico servico;

    /**
     *
     */
    public Excecao() {
    }

    /**
     *
     * @param id
     */
    public Excecao(Long id) {
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
    public String getIdentificador() {
        return identificador;
    }

    /**
     *
     * @param identificador
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

	/**
     *
     * @return
     */
    public Servico getServico() {
		return servico;
	}

	/**
     *
     * @param servico
     */
    public void setServico(Servico servico) {
		this.servico = servico;
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
        if (!(object instanceof Excecao)) {
            return false;
        }
        Excecao other = (Excecao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Excecao[ id=" + id + " ]";
    }

}
