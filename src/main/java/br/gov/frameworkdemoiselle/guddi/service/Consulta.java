/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.frameworkdemoiselle.guddi.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Paulo
 */
@WebService()
public class Consulta {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "versao")
    public String versao() {
        return "1.0.0";
    }

    
}
