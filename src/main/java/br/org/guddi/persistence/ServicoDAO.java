package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Atributo;
import br.org.guddi.domain.Excecao;
import br.org.guddi.domain.Servico;
import java.util.List;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class ServicoDAO extends JPACrud<Servico, Long> {

	private static final long serialVersionUID = 1L;


	/**
     *
     * @param id
     * @return
     */
    public Servico loadFromDetalhamento(Long id) {
		StringBuilder sql = new StringBuilder("SELECT s FROM Servico s ");

		sql.append("LEFT JOIN FETCH s.descritor ");
		sql.append("WHERE s.id = :id");

		Servico servico = (Servico) super.createQuery(sql.toString()).setParameter("id", id).getSingleResult();


		List<Atributo> atributos = super.createQuery("SELECT a FROM Atributo a WHERE a.servico = :servico ").setParameter("servico", servico).getResultList();

		List<Excecao> excecoes = super.createQuery("SELECT a FROM Excecao a WHERE a.servico = :servico ").setParameter("servico", servico).getResultList();

		servico.setAtributos(atributos);
		servico.setExcecoes(excecoes);

		return servico;
	}


}
