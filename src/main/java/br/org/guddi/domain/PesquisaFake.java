package br.org.guddi.domain;

public class PesquisaFake extends Pesquisa {

	private static final long serialVersionUID = 2249784672343077319L;

	private Integer quantidadeOcorrencias;
	
	private String link;

	public PesquisaFake(String nomeOrgao, String link, int quantidadeOcorrencias) {
		setNomeOrgao(nomeOrgao);
		setLink(link);
		setQuantidadeOcorrencias(quantidadeOcorrencias);
	}

	public Integer getQuantidadeOcorrencias() {
		return quantidadeOcorrencias;
	}

	public void setQuantidadeOcorrencias(Integer quantidadeOcorrencias) {
		this.quantidadeOcorrencias = quantidadeOcorrencias;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
