package br.org.guddi.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Logger;
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

    private static final long serialVersionUID = 762_179_107_126_837_980L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 50)
    @Column(length = 50)
    private String nome;
    
    @OneToMany(mappedBy = "orgao", fetch = FetchType.LAZY)
    private Set<Sistema> sistemas;
    
    @OneToMany(mappedBy = "orgao", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;

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
    public Set<Sistema> getSistemas() {
        return Collections.unmodifiableSet(sistemas);
    }

    /**
     *
     * @param sistemas
     */
    public void setSistemas(Set<Sistema> sistemas) {
        this.sistemas = sistemas;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Set<Usuario> getUsuarios() {
        return Collections.unmodifiableSet(usuarios);
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    private static final Logger LOG = Logger.getLogger(Orgao.class.getName());
}
