/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.security;

import static br.org.guddi.security.IResources.ORGAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author escritorio
 */
public class Resources implements IResources{

    /**
     *
     * @param id
     * @return
     */
    public static String getResources(int id) {

        return "";
    }

    /**
     *
     * @param resource
     * @return
     */
    public static Long getResource(String resource) {
        Long number = 0L;

        return number;
    }

    /**
     *
     * @return
     */
    public static List<String> getResourcesList(){
        List<String> lista = new ArrayList<>();

        lista.add(ATRIBUTO);
        lista.add(DESCRITOR);
        lista.add(EXCECAO);
        lista.add(ORGAO);
        lista.add(PAPEL);

        lista.add(INVALID);


        return lista;
    }
    private static final Logger LOG = Logger.getLogger(Resources.class.getName());

}
