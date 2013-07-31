package br.org.guddi.util.wsdl;

import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;


public class WSDLUtil {

	
	
	
	
	public WSDLMetadata loadWsdl(String url) throws WSDLException {
		
		// get hold the WSDLFactory
	    WSDLFactory factory = WSDLFactory.newInstance();

	    // create an object to read the WSDL file
	    WSDLReader reader = factory.newWSDLReader();

	    // pass the URL to the reader for parsing and get back a WSDL definiton
	    Definition wsdlInstance
	        = reader.readWSDL( null, url );

	    WSDLMetadata meta = new WSDLMetadata();
	    
	    // get a map of the five specific parts a WSDL file
	    Types types = wsdlInstance.getTypes();
	    meta.setTypes(types);
	    
	    Map messages = wsdlInstance.getMessages();
	    meta.setMessages(messages);
	    
	    Map portTypes = wsdlInstance.getPortTypes();
	    meta.setPortTypes(portTypes);
	    
	    Map bindings = wsdlInstance.getBindings();
	    meta.setBindings(bindings);
	    
	    Map services = wsdlInstance.getServices();
	    meta.setServices(services);

	    /**
	     * perform lookup of types, messages, portTypes, bindings and services
	     */
	    
	    return meta;

	}
	
}
