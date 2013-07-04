package br.org.guddi.business;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DemoiselleRunner.class)
public class PesquisarBCTest {

    @Inject
    private PesquisarBC bc;

    /**
     *
     */
    @Test
    public void testSearhValidation() {
        //bc.searhValidation("");
    }

    /**
     *
     */
    @Test
    public void testCount() {
        //System.out.println(bc.count(""));
    }

    /**
     *
     */
    @Test
    public void testSearch() {
        //System.out.println(bc.search("", new SearchFilter(0,1)));
    }
}
