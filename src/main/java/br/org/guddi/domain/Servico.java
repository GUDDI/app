package br.org.guddi.domain;

import java.io.Serializable;
import java.util.List;

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
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findById", query = "SELECT s FROM Servico s WHERE s.id = :id"),
    @NamedQuery(name = "Servico.findByNome", query = "SELECT s FROM Servico s WHERE s.nome = :nome")})
public class Servico implements Serializable {

	private static final long serialVersionUID = 4084161390208797022L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    @NotNull
    private String nome;

    @Size(max = 1500)
	@Column(length = 1500)
	private String descricao;
    
    @Size(max = 100)
	@Column(name = "tipo_retorno", length = 100)
    private String tipoRetorno;
    
    @JoinColumn(name = "id_descritor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Descritor descritor;

    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<Atributo> atributos;

    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<Excecao> excecoes;

    /**
     *
     */
    public Servico() {
    	setId(null);
		setNome(null);
		setTipoRetorno(null);
		setDescricao(null);
		setDescritor(null);
    }

    /**
     *
     * @param id
     */
    public Servico(Long id) {
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
    public Descritor getDescritor() {
		return descritor;
	}


	/**
     *
     * @param descritor
     */
    public void setDescritor(Descritor descritor) {
		this.descritor = descritor;
	}

	/**
     *
     * @return
     */
    @XmlTransient
	public List<Atributo> getAtributos() {
		return atributos;
	}

	/**
     *
     * @param atributos
     */
    public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	/**
     *
     * @return
     */
    @XmlTransient
	public List<Excecao> getExcecoes() {
		return excecoes;
	}

	/**
     *
     * @param excecoes
     */
    public void setExcecoes(List<Excecao> excecoes) {
		this.excecoes = excecoes;
	}
    
    /**
    *
    * @return
    */
	public String getTipoRetorno() {
		return tipoRetorno;
	}

	/**
    *
    * @param tipoRetorno
    */
	public void setTipoRetorno(String tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
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
