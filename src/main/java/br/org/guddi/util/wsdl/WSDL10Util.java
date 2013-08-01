package br.org.guddi.util.wsdl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.DescritorType;
import br.org.guddi.domain.Excecao;
import br.org.guddi.domain.Servico;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.FaultImpl;
import com.ibm.wsdl.MessageImpl;
import com.ibm.wsdl.OperationImpl;
import com.ibm.wsdl.PartImpl;
import com.ibm.wsdl.PortTypeImpl;
import com.ibm.wsdl.ServiceImpl;


public class WSDL10Util {

	public WSDL10Metadata loadWsdl(String url) throws WSDLException {
		
		// get hold the WSDLFactory
	    WSDLFactory factory = WSDLFactory.newInstance();

	    // create an object to read the WSDL file
	    WSDLReader reader = factory.newWSDLReader();

	    // pass the URL to the reader for parsing and get back a WSDL definiton
	    Definition wsdlInstance = reader.readWSDL( null, url );

	    WSDL10Metadata meta = new WSDL10Metadata();
	    
	    // get a map of the five specific parts a WSDL file
	    Types types = wsdlInstance.getTypes();
	    meta.setTypes(types);
	    
	    Map<QName, MessageImpl> messages = wsdlInstance.getMessages();
	    meta.setMessages(messages);
	    
	    Map<QName, PortTypeImpl> portTypes = wsdlInstance.getPortTypes();
	    meta.setPortTypes(portTypes);
	    
	    Map<QName, BindingImpl> bindings = wsdlInstance.getBindings();
	    meta.setBindings(bindings);
	    
	    Map<QName, ServiceImpl> services = wsdlInstance.getServices();
	    meta.setServices(services);

	    return meta;
	}
	
	public List<Descritor> loadDescritorOnWSDL(String url) throws WSDLException {
		
		WSDL10Metadata meta = loadWsdl(url);
		
		
		List<Descritor> descritores = new ArrayList<Descritor>();
		
		List<Servico> servicos = new ArrayList<Servico>();
		
		for (QName port	 : meta.getPortTypes().keySet()) {
			
			Descritor descritor = new Descritor();
			
			descritor.setNome(meta.getPortTypes().get(port).getQName().getLocalPart());
			descritor.setUrl(url);
			descritor.setDescricao(meta.getPortTypes().get(port).getQName().toString());
			descritor.setTipo(DescritorType.WSDL);
			
			
			for (Object implO : meta.getPortTypes().get(port).getOperations()) {
				OperationImpl impl = (OperationImpl) implO;

				Servico servico = new Servico();
				
				servico.setNome(impl.getName());
				servico.setDescricao(impl.getName());

				List<Atributo> atributos = new ArrayList<Atributo>();
				if(impl.getParameterOrdering() != null) {
					for(Object o : impl.getParameterOrdering()) {
						PartImpl p = (PartImpl) impl.getInput().getMessage().getParts().get(o);
						System.out.println("\t"+p.getName() + "( " + p.getTypeName().getLocalPart() + " ) " );
						
						Atributo atributo = new Atributo();
						atributo.setNome(p.getName());
						atributo.setTipo(p.getTypeName().getLocalPart());//TODO tratar a string para dar o tipo correto
						atributo.setDescricao(p.getTypeName().toString());
						
						atributos.add(atributo);
					}
				}
				servico.setAtributos(atributos);
				
				PartImpl p = (PartImpl) impl.getOutput().getMessage().getParts().get("return");
				if(p != null) {
					servico.setTipoRetorno(p.getTypeName().getLocalPart());
				} else {
					servico.setTipoRetorno("void");
				}
				
				List<Excecao> excessoes = new ArrayList<Excecao>();
				if(impl.getFaults() != null) {
					for(Object o : impl.getFaults().keySet()) {
	
						FaultImpl fault = (FaultImpl) impl.getFaults().get(o);
						
						Excecao excecao = new Excecao();
						excecao.setDescricao(fault.getName());
						
						excessoes.add(excecao);
					}
				}
				servico.setExcecoes(excessoes);
				
				servicos.add(servico);
			}
			
			descritor.setServicos(servicos);
			
			descritores.add(descritor);
		}
		
		return descritores;
	}
		
	
	/*private void adicionarNovoServico() {
		
		
	    	if(descritor.getServicos() == null) {
				descritor.setServicos(new ArrayList<Servico>());
			}
			
			Boolean existeServicoNovo = Boolean.FALSE; 
			for(Servico servico : descritor.getServicos()){
				
				if(servico.getAtributos() == null){
	    			servico.setAtributos(new ArrayList<Atributo>());
	    		}
	    		
	    		if(servico.getExcecoes() == null){
	    			servico.setExcecoes(new ArrayList<Excecao>());
	    		}
	    		
				if(servico.getId() == null){
					existeServicoNovo = Boolean.TRUE;					
				}
				
				Boolean existeNovoAtributo = Boolean.FALSE;
    			for(Atributo atributo : servico.getAtributos()){
    				if(atributo.getId() == null){
    					existeNovoAtributo = Boolean.TRUE;
    				}
    			}
    			
    			if(!existeNovoAtributo){
    				servico.getAtributos().add(new Atributo());
    			}
    			
    			Boolean existeNovaExcecao = Boolean.FALSE;
    			for(Excecao excecao : servico.getExcecoes()){
    				if(excecao.getId() == null){
    					existeNovaExcecao = Boolean.TRUE;
    				}
    			}
    			
    			if(!existeNovaExcecao){
    				servico.getExcecoes().add(new Excecao());
    			}
			}
			
			if(!existeServicoNovo){
				descritor.getServicos().add(new Servico());
				setAbaServicoAtual(descritor.getServicos().size() - 2);
				setAbaComplementarAtual(new Integer(0));
			}
	}*/
	
}
