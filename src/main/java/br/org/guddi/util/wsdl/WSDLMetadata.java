package br.org.guddi.util.wsdl;

import java.util.Map;

import javax.wsdl.Types;
import javax.xml.namespace.QName;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.MessageImpl;
import com.ibm.wsdl.PortTypeImpl;
import com.ibm.wsdl.ServiceImpl;

public class WSDLMetadata {

	Types types;

	Map<QName, MessageImpl> messages;

	Map<QName, PortTypeImpl> portTypes;

	Map<QName, BindingImpl> bindings;

	Map<QName, ServiceImpl> services;

	public WSDLMetadata() {
		super();
	}
	
	public Types getTypes() {
		return types;
	}

	
	public void setTypes(Types types) {
		this.types = types;
	}

	
	public Map<QName, MessageImpl> getMessages() {
		return messages;
	}

	
	public void setMessages(Map<QName, MessageImpl> messages) {
		this.messages = messages;
	}

	
	public Map<QName, PortTypeImpl> getPortTypes() {
		return portTypes;
	}

	
	public void setPortTypes(Map<QName, PortTypeImpl> portTypes) {
		this.portTypes = portTypes;
	}

	
	public Map<QName, BindingImpl> getBindings() {
		return bindings;
	}

	
	public void setBindings(Map<QName, BindingImpl> bindings) {
		this.bindings = bindings;
	}

	
	public Map<QName, ServiceImpl> getServices() {
		return services;
	}

	
	public void setServices(Map<QName, ServiceImpl> services) {
		this.services = services;
	}

	

}
