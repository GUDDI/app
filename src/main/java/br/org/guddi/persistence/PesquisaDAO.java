package br.org.guddi.persistence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.util.search.SearchFilter;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class PesquisaDAO extends JPACrud<Pesquisa, Long> {

	private static final long serialVersionUID = 1L;

	/**
     *
     * @param searchParam
     * @return
     */
    public int count(String searchParam) {

    	BigInteger n = (BigInteger) getQueryFromSearch(searchParam, null, true).getSingleResult();
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

		List<Object[]> objList = getQueryFromSearch(searchParam, parameters, false).getResultList();

		List<Pesquisa> list = new ArrayList<Pesquisa>(objList.size());
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

			list.add(p);
		}

		return list;
	}
    
    private Query getQueryFromSearch(String searchParam, SearchFilter parameters, Boolean isCount) {
    	
    	StringBuilder sql = new StringBuilder();
    	
    	if(isCount) {
    		sql.append("SELECT COUNT(1) ");
    	} else {
    		sql.append("select distinct on (o.id,  s.id, d.id, ws.id) o.id as idOrgao, o.nome as nomeOrgao, s.id as idSistema, s.nome as nomeSistema, d.id as idDescritor, d.descricao as descritor, ws.id as idServico, ws.nome as nomeServico ");
    	}
    	
    	sql.append("FROM guddi.servico ws ");
    	sql.append(" LEFT JOIN guddi.descritor d ON d.id = ws.id_descritor ");
    	sql.append(" LEFT JOIN guddi.sistema s ON s.id = d.id_sistema ");
    	sql.append(" LEFT JOIN guddi.orgao o ON o.id = s.id_orgao ");
    	
    	
    	sql.append("WHERE ws.nome ILIKE :searchParam ");
		sql.append("   OR d.descricao ILIKE :searchParam ");
		sql.append("   OR s.nome ILIKE :searchParam ");
		sql.append("   OR o.nome ILIKE :searchParam ");
    	
		/*if(!isCount) {
			sql.append("ORDER BY ws.nome, s.nome");
		}*/
		
		
		Query query = getEntityManager().createNativeQuery(sql.toString());
		
		query.setParameter("searchParam", filtarParam(searchParam)); //TODO Claro que ainda tenho que filtar isso

		if (parameters != null) {
			query.setFirstResult(parameters.getFirst());
			query.setMaxResults(parameters.getPageSize());
		} else {
			query.setFirstResult(0);
			query.setMaxResults(10);
		}
		
    	return query; 
    }

	//TODO Claro que ainda tenho que filtar isso
	private String filtarParam(String param) {

		param = "%"+param.trim()+"%";

		return param;
	}


}
