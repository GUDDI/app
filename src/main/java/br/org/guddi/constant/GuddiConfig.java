package br.org.guddi.constant;

import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(prefix = "br.org.guddi.")
public class GuddiConfig {
	
	@Name(value = "guddizilla.enabled")
	private Boolean guddiZillaEnabled = false;

	@Name(value = "aminesia.remetente")
    private String remetente;
	
	@Name(value = "aminesia.assunto")
    private String assunto;
	
	@Name(value = "aminesia.url")
    private String url;

	public Boolean getGuddiZillaEnabled() {
		return guddiZillaEnabled;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getUrl() {
		return url;
	}
	
}
