package br.org.guddi.util.wsdl;

import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;

import org.junit.Test;

import com.ibm.wsdl.OperationImpl;
import com.ibm.wsdl.PartImpl;

public class WSDLUtilTest {

	@Test
	public void toStringNucleopaTest() throws WSDLException {
		
		//WSDLMetadata meta = new WSDLUtil().loadWsdl("http://10.1.11.14:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		WSDLMetadata meta = new WSDLUtil().loadWsdl("src/test/resources/wsdl/ControleAcessoFacadeBeanWS.wsdl");

		/*
		System.out.println(meta.getTypes());
		
		System.out.println(meta.getMessages());
		System.out.println(meta.getMessages().keySet());
		for (QName i : meta.getMessages().keySet()) {
			System.out.println(i.toString());
			System.out.println(meta.getMessages().get(i).toString());
		}
		*/
		
		System.out.println(meta.getPortTypes());
		System.out.println(meta.getPortTypes().keySet());
		for (QName i : meta.getPortTypes().keySet()) {
			//System.out.println(i.toString());
			//System.out.println(meta.getPortTypes().get(i));
			
			for (Object implO : meta.getPortTypes().get(i).getOperations()) {
				OperationImpl impl = (OperationImpl) implO;
				
				System.out.println("Metodo : " + impl.getName());
				 
				System.out.println("Parametros:");

				
				System.out.println(impl.getParameterOrdering());
				
				for(Object o : impl.getParameterOrdering()) {
					PartImpl p = (PartImpl) impl.getInput().getMessage().getParts().get(o);
					System.out.println(p.getName() + "( " + p.getTypeName().getLocalPart() + " ) " );
				}
				
				System.out.println("Retorno");
				System.out.println(impl.getOutput().getMessage().getQName());
				
				//for(Object o : impl.getOutput().getMessage().getParts().keySet()) {
					PartImpl p = (PartImpl) impl.getOutput().getMessage().getParts().get("return");
					if(p != null) {
						System.out.println(p.getName() + "( " + p.getTypeName().getLocalPart() + " ) " );
					}
				//}
				
				System.out.println("Excessoes:");
				System.out.println(impl.getFaults());
				
			}
		}
		
		/*
		System.out.println(meta.getBindings());
		System.out.println(meta.getBindings().keySet());
		for (QName i : meta.getBindings().keySet()) {
			System.out.println(i.toString());
			System.out.println(meta.getBindings().get(i).toString());
		}
		
		System.out.println(meta.getServices());
		System.out.println(meta.getServices().keySet());
		for (QName i : meta.getServices().keySet()) {
			System.out.println(i.toString());
			System.out.println(meta.getServices().get(i).toString());
		}
		*/
		
		
	}

	
}
