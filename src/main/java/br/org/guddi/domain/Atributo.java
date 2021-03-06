package br.org.guddi.domain;

import java.io.Serializable;

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
 * @author Clovis Lemes Ferreira Junior
 */
@Entity
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atributo.findAll", query = "SELECT a FROM Atributo a"),
    @NamedQuery(name = "Atributo.findById", query = "SELECT a FROM Atributo a WHERE a.id = :id"),
    @NamedQuery(name = "Atributo.findByNome", query = "SELECT a FROM Atributo a WHERE a.nome = :nome"),
    @NamedQuery(name = "Atributo.findByTipo", query = "SELECT a FROM Atributo a WHERE a.tipo = :tipo")})
public class Atributo implements Serializable {

	private static final long serialVersionUID = 7517355321528352171L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    @NotNull
    private String nome;

    @Size(max = 50)
    @Column(length = 50)
    @NotNull
    private String tipo;
    
    @Size(max = 300)
    @Column(length = 300)
    private String descricao;

    @JoinColumn(name = "id_servico", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Servico servico;

    /**
     *
     */
    public Atributo() {
    }

    /**
     *
     * @param id
     */
    public Atributo(Long id) {
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
        if (!(object instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) object;
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
