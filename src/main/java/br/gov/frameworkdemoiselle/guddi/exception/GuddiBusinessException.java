package br.gov.frameworkdemoiselle.guddi.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;
import br.gov.frameworkdemoiselle.message.SeverityType;

@ApplicationException(rollback=true, severity=SeverityType.INFO)
public class GuddiBusinessException extends Exception  {

	private static final long serialVersionUID = -639180379519468520L;

	public GuddiBusinessException() {
		super();
	}


	public GuddiBusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public GuddiBusinessException(String message) {
		super(message);
	}

	public GuddiBusinessException(Throwable throwable) {
		super(throwable);
	}
	
}
