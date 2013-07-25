package br.org.guddi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @NamedQuery(name = "Descritor.findAll", query = "SELECT d FROM Descritor d"),
    @NamedQuery(name = "Descritor.findById", query = "SELECT d FROM Descritor d WHERE d.id = :id")})
public class Descritor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min=1, max = 256)
	@Column(length = 256)
	@NotNull
	private String url;
	
	@Size(min=1, max = 35)
	@Column(length = 35)
	@NotNull
	private String nome;
	
	@Size(max = 1500)
	@Column(length = 1500)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private DescritorType tipo;

	@JoinColumn(name = "id_sistema", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Sistema sistema;

	@OneToMany(mappedBy = "descritor", fetch = FetchType.LAZY)
    private List<Servico> servicos;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "descritor_marcacao",
            joinColumns = {
        @JoinColumn(name = "id_descritor", nullable = false, updatable = false)},
            inverseJoinColumns = {
        @JoinColumn(name = "id_marcacao", nullable = false, updatable = false)})
    private List<Marcacao> marcacoes;
	
	@Transient
	private String marcacoesFormatado;

    /**
     *
     */
    public Descritor() {
    }

    /**
     *
     * @param id
     */
    public Descritor(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param descricao
     * @param sistema
     */
    public Descritor(Long id, String url, Sistema sistema, DescritorType tipo) {
		super();
		this.id = id;
		this.sistema = sistema;
		this.sistema = sistema;
		this.tipo = tipo;
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
    @XmlTransient
	public List<Servico> getServicos() {
		return servicos;
	}

	/**
     *
     * @param servicos
     */
    public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	/**
     *
     * @return
     */
    public Sistema getSistema() {
		return sistema;
	}


	/**
     *
     * @param sistema
     */
    public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	/**
     *
     * @return
     */
    @XmlTransient
    public List<Marcacao> getMarcacoes() {
		return marcacoes;
	}
    
    public String getMarcacoesFormatado() {
    	if(marcacoes == null && marcacoesFormatado == null){
    		return "";
    	}
    	
    	StringBuffer sb = new StringBuffer();
    	
    	if(marcacoes != null && !marcacoes.isEmpty()){
	    	for(Marcacao marcacao : marcacoes){
	    		if(sb.length() > 0){
	    			sb.append(", ");
	    		}
	    		sb.append(marcacao.getMarcacao());
	    	}
    	}
    	else{
    		if(marcacoesFormatado != null && !marcacoesFormatado.isEmpty()){
    			return marcacoesFormatado;
    		}
    	}
    	
		return sb.toString();
	}

	public void setMarcacoesFormatado(String marcacoesFormatado) {
		this.marcacoesFormatado = marcacoesFormatado;
	}

	/**
     *
     * @param marcacacoes
     */
    public void setMarcacoes(List<Marcacao> marcacacoes) {
		this.marcacoes = marcacacoes;
	}

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DescritorType getTipo() {
		return tipo;
	}

	public void setTipo(DescritorType tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
