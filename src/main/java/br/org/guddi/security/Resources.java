/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.security;

import static br.org.guddi.security.IResources.ATRIBUTO;
import static br.org.guddi.security.IResources.ORGAO;
import static br.org.guddi.security.IResources.PAPEL;
import static br.org.guddi.security.IResources.TAG;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author escritorio
 */
public class Resources implements IResources {

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

        if (resource.equals(ATRIBUTO)) {
            number = 1L;
        }
        if (resource.equals(DESCRITOR)) {
            number = 2L;
        }
        if (resource.equals(EXCECAO)) {
            number = 3L;
        }
        if (resource.equals(ORGAO)) {
            number = 4L;
        }
        if (resource.equals(PAPEL)) {
            number = 5L;
        }
        if (resource.equals(PESQUISAR)) {
            number = 6L;
        }
        if (resource.equals(RECURSO)) {
            number = 7L;
        }
        if (resource.equals(SECURITY)) {
            number = 8L;
        }
        if (resource.equals(SERVICO)) {
            number = 9L;
        }
        if (resource.equals(SISTEMA)) {
            number = 10L;
        }
        if (resource.equals(TAG)) {
            number = 12L;
        }
        if (resource.equals(USUARIO)) {
            number = 13L;
        }
        if (resource.equals(INVALID)) {
            number = 99L;
        }

        return number;
    }

    /**
     *
     * @return
     */
    public static List<String> getResourcesList() {
        List<String> lista = new ArrayList<String>();

        lista.add(ATRIBUTO);
        lista.add(DESCRITOR);
        lista.add(EXCECAO);
        lista.add(ORGAO);
        lista.add(PAPEL);
        lista.add(PESQUISAR);
        lista.add(RECURSO);
        lista.add(SECURITY);
        lista.add(SERVICO);
        lista.add(SISTEMA);
        lista.add(TAG);
        lista.add(USUARIO);

        lista.add(INVALID);

        return lista;
    }

}
