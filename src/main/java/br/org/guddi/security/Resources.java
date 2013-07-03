/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.security;

import static br.org.guddi.security.IResources.ORGAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author escritorio
 */
public class Resources implements IResources{

   public static String getResources(int id) {

        return "";
    }

    public static Long getResource(String resource) {
        Long number = 0L;

        return number;
    }

    public static List<String> getResourcesList(){
        List<String> lista = new ArrayList<String>();

        lista.add(ATRIBUTO);
        lista.add(DESCRITOR);
        lista.add(EXCECAO);
        lista.add(ORGAO);
        lista.add(PAPEL);

        lista.add(INVALID);


        return lista;
    }

}
