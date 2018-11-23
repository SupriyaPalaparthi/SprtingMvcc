package com.cg.springmvcone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Mobile;
@Repository("mobiledao")
public class MobileDaoImpl implements iMobileDao {
	@PersistenceContext
    EntityManager em;
	
	@Override
	public void addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
	em.persist(mobile);
	em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mobile> showAllMobile() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("FROM Mobile");
		List<Mobile> myAll=query.getResultList();
		return myAll;
	}

	@Override
	public void deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		Query queryDelete=em.createQuery("DELETE FROM Mobile WHERE mobId=:mobdelete");
		queryDelete.setParameter("mobdelete",mobId);
	    queryDelete.executeUpdate();
         
	}

	@Override
	public Mobile searchMobile(int mobId) {
		// TODO Auto-generated method stub
		Query querySearch=em.createQuery("FROM Mobile WHERE mobId=:mobdata");
		querySearch.setParameter("mobdata",mobId);
		Mobile mob=(Mobile) querySearch.getResultList().get(0);
		return mob;
	}

	@Override
	public void updateMobile(int mobId, double mobPrice) {
		// TODO Auto-generated method stub
		Query querySearch=em.createQuery("UPDATE Mobile set mobPrice=:mp WHERE mobId=:mi");
		querySearch.setParameter("mi",mobId);
		querySearch.setParameter("mp",mobPrice);
		querySearch.executeUpdate();
		
	}

}
