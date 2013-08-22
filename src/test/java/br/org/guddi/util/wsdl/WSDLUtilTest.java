package br.org.guddi.util.wsdl;

import java.io.File;
import java.util.List;

import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;

import org.junit.Test;

import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Descritor;
import br.org.guddi.domain.Excecao;
import br.org.guddi.domain.Servico;

import com.ibm.wsdl.OperationImpl;
import com.ibm.wsdl.PartImpl;

public class WSDLUtilTest {

	@Test
	public void loadNuclepaDesenvTest() throws WSDLException {
		List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://10.1.11.14:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		printDescritores(descritores);
	}
	
	@Test
	public void loadHomologarTest() throws WSDLException {
		//List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://10.1.12.14:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		//printDescritores(descritores);
		
		List<Descritor> descritores2 = new WSDLUtil().loadDescriptorsOnWSDL("https://www2.homologar.prodepa.gov.br/portaltransparencia/ws/ConsultaReceitaFacade?wsdl");
		printDescritores(descritores2);
	}
	
	@Test
	public void loadNuclepaProducaoTest() throws WSDLException {
		List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://10.1.13.23:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		printDescritores(descritores);
	}
	
	
	@Test
	public void loadportaltransparenciaProducaoTest() throws WSDLException {
		List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("https://www.sistemas.pa.gov.br/portaltransparencia/ws/ConsultaReceitaFacade?wsdl");
		printDescritores(descritores);
	}
	
	
	private void printDescritores(List<Descritor> descritores) throws WSDLException {
		
		//List<Descritor> descritores = new WSDLUtil().loadDescritorOnWSDL("http://10.1.11.14:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		//List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://10.1.11.14:8080/controleacesso/ws/ControleAcessoFacadeBeanWS?wsdl");
		//List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://www2.homologar.prodepa.gov.br/eprotocolo/ws/AnexoFacadeBeanWS?wsdl");
		
		//List<Descritor> descritores = new WSDLUtil().loadDescriptorsOnWSDL("http://www.herongyang.com/Service/Hello_WSDL_20_SOAP.wsdl");
		
		
		for (Descritor descritor : descritores) {
			
			System.out.println(descritor.getNome());
			System.out.println(descritor.getUrl());
			System.out.println(descritor.getDescricao());
			System.out.println(descritor.getTipo());
				
			for (Servico servico : descritor.getServicos()) {
				System.out.println("\n >> Servico: " + servico.getNome() );
				
				System.out.println("Atributos:");
				for (Atributo a : servico.getAtributos()) {
					System.out.println("\t"+a.getNome() + " " + a.getTipo() );
				}
				
				System.out.println("Retorno: " + servico.getTipoRetorno());
				
				System.out.println("Excessoes:");
				for (Excecao a : servico.getExcecoes()) {
					System.out.println("\t"+a.getDescricao());
				}
			} 
		}
	}
	
	@Test
	public void toStringNucleopaTest() throws WSDLException {
		
		//WSDLMetadata meta = new WSDLUtil().loadWsdl("http://10.1.11.14:8080/nucleopa-nucleopa-ejb-2.2/NucleoPAFacadeBeanWS?wsdl");
		WSDLMetadata meta = new WSDLUtil().loadWsdlMetadata("src/test/resources/wsdl/10/ControleAcessoFacadeBeanWS.wsdl");

		
		//System.out.println(meta.getPortTypes());
		//System.out.println(meta.getPortTypes().keySet());
		for (QName i : meta.getPortTypes().keySet()) {
			//System.out.println(i.toString());
			//System.out.println(meta.getPortTypes().get(i));
			
			for (Object implO : meta.getPortTypes().get(i).getOperations()) {
				OperationImpl impl = (OperationImpl) implO;
				
				System.out.println(">Metodo : " + impl.getName());
				 
				System.out.println(">Parametros:");

				//System.out.println(impl.getParameterOrdering());
				
				for(Object o : impl.getParameterOrdering()) {
					PartImpl p = (PartImpl) impl.getInput().getMessage().getParts().get(o);
					System.out.println("\t"+p.getName() + "( " + p.getTypeName().getLocalPart() + " ) " );
				}
				
				System.out.println("Retorno: " + impl.getOutput().getMessage().getQName());
				
				//for(Object o : impl.getOutput().getMessage().getParts().keySet()) {
					PartImpl p = (PartImpl) impl.getOutput().getMessage().getParts().get("return");
					if(p != null) {
						System.out.println("\t"+p.getName() + "( " + p.getTypeName().getLocalPart() + " ) " );
					}
				//}
				
				System.out.println("Excessoes:");
				System.out.println(impl.getFaults());
				
				System.out.println("\n\n");
				
			}
		}
		
		
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
		
	}
	
	@Test
	public void loadWSDL20Test() throws WSDLException {
		
		 /*WSDLFactory factory = WSDLFactory.newInstance();
	       WSDLReader reader = factory.newWSDLReader();
	       reader.setFeature(WSDLReader.FEATURE_VALIDATION, true);
	       Description descComp = reader.readWSDL(wsdlurl);        <-- the Description component
	       DescriptionElement descElem = descElem.toComponent();*/
		
	}
	
}
