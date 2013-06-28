/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package br.org.guddi.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 05081364908
 */
// @Entity
// @Table(catalog = "guddi", schema = "guddi")
@XmlRootElement
public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idServico;

	private String nomeServico;

	private String wsdlLink;

	private Long idDescritor;

	private String nomeDescritor;

	private Long idSistema;

	private String nomeSistema;

	private Long idOrgao;

	private String nomeOrgao;

	public Pesquisa() {
	}

	public Long getIdOrgao() {
		return idOrgao;
	}

	public void setIdOrgao(Long idOrgao) {
		this.idOrgao = idOrgao;
	}

	public String getNomeOrgao() {
		return nomeOrgao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getWsdlLink() {
		return wsdlLink;
	}

	public void setWsdlLink(String wsdlLink) {
		this.wsdlLink = wsdlLink;
	}

	public Long getIdDescritor() {
		return idDescritor;
	}

	public void setIdDescritor(Long idDescritor) {
		this.idDescritor = idDescritor;
	}

	public String getNomeDescritor() {
		return nomeDescritor;
	}

	public void setNomeDescritor(String nomeDescritor) {
		this.nomeDescritor = nomeDescritor;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

}
