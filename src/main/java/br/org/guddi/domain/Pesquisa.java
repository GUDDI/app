package br.org.guddi.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 */
// @Entity
// @Table(catalog = "guddi", schema = "guddi")
@XmlRootElement
public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idServico;

	private String nomeServico;

	private String url;

	private Long idDescritor;

	private String nomeDescritor;

	private Long idSistema;

	private String nomeSistema;

	private Long idOrgao;

	private String nomeOrgao;

	/**
     *
     */
    public Pesquisa() {
	}

	/**
     *
     * @return
     */
    public Long getIdOrgao() {
		return idOrgao;
	}

	/**
     *
     * @param idOrgao
     */
    public void setIdOrgao(Long idOrgao) {
		this.idOrgao = idOrgao;
	}

	/**
     *
     * @return
     */
    public String getNomeOrgao() {
		return nomeOrgao;
	}

	/**
     *
     * @param nomeOrgao
     */
    public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	/**
     *
     * @return
     */
    public Long getIdServico() {
		return idServico;
	}

	/**
     *
     * @param idServico
     */
    public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	/**
     *
     * @return
     */
    public String getNomeServico() {
		return nomeServico;
	}

	/**
     *
     * @param nomeServico
     */
    public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
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
    public Long getIdDescritor() {
		return idDescritor;
	}

	/**
     *
     * @param idDescritor
     */
    public void setIdDescritor(Long idDescritor) {
		this.idDescritor = idDescritor;
	}

	/**
     *
     * @return
     */
    public String getNomeDescritor() {
		return nomeDescritor;
	}

	/**
     *
     * @param nomeDescritor
     */
    public void setNomeDescritor(String nomeDescritor) {
		this.nomeDescritor = nomeDescritor;
	}

	/**
     *
     * @return
     */
    public Long getIdSistema() {
		return idSistema;
	}

	/**
     *
     * @param idSistema
     */
    public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	/**
     *
     * @return
     */
    public String getNomeSistema() {
		return nomeSistema;
	}

	/**
     *
     * @param nomeSistema
     */
    public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

}
