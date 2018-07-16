package com.internship.mobileshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.internship.mobileshop.model.Device;

@Repository
@Transactional
public class DeviceDaoImp implements DeviceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean createDevice(Device device) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			session.save(device);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Boolean updateDeviceQty(Long id, int qty) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Device mo = session.byId(Device.class).load(id);
			mo.setQuantity(qty);
			session.flush();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Boolean deleteDevice(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Device model = session.byId(Device.class).load(id);
			session.delete(model);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> searchDevices(String keyword,Integer offset, Integer maxResult) {
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Device.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("brand","name", "color").matching(keyword).createQuery();
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Device.class);

		List<Device> results = hibQuery.setFirstResult(offset != null ? offset : 0).setMaxResults(maxResult != null ? maxResult : 10).list();
		return results;
	}


	@Override
	public Device getDevice(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Device model = session.byId(Device.class).load(id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Boolean updateDevice(Device device) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(device);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Device> findAll(Integer offset, Integer maxResult) {
		return sessionFactory.openSession().createCriteria(Device.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResult != null ? maxResult : 10).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long count() {
		return (Long) sessionFactory.openSession().createCriteria(Device.class).setProjection(Projections.rowCount())
				.uniqueResult();
	}

	@Override
	public void indexDevices() throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean updateStatus(Long id, String status) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Device mo = session.byId(Device.class).load(id);
			mo.setStatus(status);
			session.flush();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}
}
