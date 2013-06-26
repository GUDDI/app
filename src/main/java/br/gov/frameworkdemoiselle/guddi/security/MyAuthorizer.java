package br.gov.frameworkdemoiselle.guddi.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;

/**
* @author thiago.soares
*/
public class MyAuthorizer implements Authorizer {

	private static final long serialVersionUID = -9096849270023234484L;
	
	@Inject
	private Identity identity;
	
	@Override
	public boolean hasRole(String role) {

		//TODO Autorizar no banco de dados
		
		return true;
	}

	@Override
	public boolean hasPermission(String resource, String operation) {
		return true;
	}

}
