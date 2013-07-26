package br.org.guddi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clóvis Lemes Ferreira Júnior
 */

@Entity
@Table
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orgao.findAll", query = "SELECT o FROM Orgao o"),
    @NamedQuery(name = "Orgao.findById", query = "SELECT o FROM Orgao o WHERE o.id = :id"),
    @NamedQuery(name = "Orgao.findByNome", query = "SELECT o FROM Orgao o WHERE o.nome = :nome")})
public class Orgao implements Serializable {

    private static final long serialVersionUID = 762179107126837980L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, max = 50)
    @Column(length = 50)
    private String nome;

    @OneToMany(mappedBy = "orgao", fetch = FetchType.LAZY)
    private List<Sistema> sistemas;

    @OneToMany(mappedBy = "orgao", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
    
    @Column(length=100)
    private String url;
    
    @Column(length=10)
    private String sigla;
    
    @Column(length=50)
    private String razaoSocial;
    
    @Column(length=10)
    private String codigo;
    
    @Column(length=2)
    private String uf;
    
    @Column(length=70)
    private String endereco;
    
    @Column(length=60)
    private String email;
    
    @Column(length=50)
    private String nomeContato;
    

    /**
     *
     */
    public Orgao() {
    }

    /**
     *
     * @param id
     */
    public Orgao(Long id) {
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
    @XmlTransient
    public List<Sistema> getSistemas() {
        return sistemas;
    }

    /**
     *
     * @param sistemas
     */
    public void setSistemas(List<Sistema> sistemas) {
        this.sistemas = sistemas;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    /**
     *
     * @return
     */
    public String getUrl() {
		return url;
	}

	/**
     *
     * @param url
     */
    public void setUrl(String url) {
		this.url = url;
	}

	/**
     *
     * @return
     */
    public String getSigla() {
		return sigla;
	}

	/**
     *
     * @param sigla
     */
    public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
     *
     * @return
     */
    public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
     *
     * @param razaoSocial
     */
    public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
     *
     * @return
     */
    public String getCodigo() {
		return codigo;
	}

	/**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
     *
     * @return
     */
    public String getUf() {
		return this.uf;
	}

	/**
     *
     * @param uf
     */
    public void setUf(String uf) {
		this.uf = uf;
	}

	/**
     *
     * @return
     */
    public String getEndereco() {
		return endereco;
	}

	/**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
     *
     * @return
     */
    public String getEmail() {
		return email;
	}

	/**
     *
     * @param email
     */
    public void setEmail(String email) {
		this.email = email;
	}

	/**
     *
     * @return
     */
    public String getNomeContato() {
		return nomeContato;
	}

	/**
     *
     * @param nomeContato
     */
    public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
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
        if (!(object instanceof Orgao)) {
            return false;
        }
        Orgao other = (Orgao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.frameworkdemoiselle.guddi.domain.Orgao[ id=" + id + " ]";
    }

}
