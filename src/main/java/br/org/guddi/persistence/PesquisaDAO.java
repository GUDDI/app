package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.util.search.SearchFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Query;

@PersistenceController
public class PesquisaDAO extends JPACrud<Pesquisa, Long> {

	private static final long serialVersionUID = 1L;

	/**
     *
     * @param searchParam
     * @return
     */
    public int count(String searchParam) {
		
		StringBuilder sql = new StringBuilder("SELECT ct FROM guddi.fc_servico_localizar_total_registros( :search ) ct; ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());
		
		query.setParameter("search", filtarParam(searchParam)); 
		
		Integer n = (Integer) query.getSingleResult();
		if (n == null) {
			return 0;
		}
		return n.intValue();
	}
	
	/**
     *
     * @param searchParam
     * @param parameters
     * @return
     */
    public List<Pesquisa> search(String searchParam, SearchFilter parameters) {
		StringBuilder sql = new StringBuilder("SELECT p.id_orgao, p.nome_orgao, p.id_sistema, p.nome_sistema, p.id_descritor, p.descricao_descritor, p.id_servico, p.nome_servico, p.wsdl_link_servico FROM guddi.fc_servico_localizar( :search , :firstResult, :maxResult) p ;  ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter("search", filtarParam(searchParam)); //TODO Claro que ainda tenho que filtar isso

		if (parameters != null) {
			query.setParameter("firstResult", parameters.getFirst());
			query.setParameter("maxResult", parameters.getPageSize());
		} else {
			query.setParameter("firstResult", 0);
			query.setParameter("maxResult", 10);
		}
		
		List<Object[]> objList = query.getResultList();
		
		List<Pesquisa> list = new ArrayList<>();
		for (Object[] obj : objList) {
			
			Pesquisa p = new Pesquisa();
			
			p.setIdOrgao(Long.parseLong(obj[0].toString()));
			p.setNomeOrgao((String) obj[1]);			

			p.setIdSistema(Long.parseLong(obj[2].toString()));
			p.setNomeSistema((String) obj[3]);

			p.setIdDescritor(Long.parseLong(obj[4].toString()));
			p.setNomeDescritor((String) obj[5]);

			p.setIdServico(Long.parseLong(obj[6].toString()));
			p.setNomeServico((String) obj[7]);
			p.setWsdlLink((String) obj[8]);
			
			list.add(p);
		}
		
		
		
		return list;
	}
	
	//TODO Claro que ainda tenho que filtar isso
	private String filtarParam(String param) {
		
		param = param.trim();
		
		return param;
	}
    private static final Logger LOG = Logger.getLogger(PesquisaDAO.class.getName());

}
