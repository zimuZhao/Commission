package cn.hit.commission.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public class UserDAO extends BaseHibernateDAO implements IUserDAO{
	
	@Override
	public Salesman findBySalesID(int salesmanID) {
		// TODO Auto-generated method stub
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			Salesman salesman = (Salesman)session.get(Salesman.class, salesmanID);
			tran.commit();
			return salesman;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Gunsmith findByGunsmithID(int gunsmithID) {
		// TODO Auto-generated method stub
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			Gunsmith gunsmith = (Gunsmith)session.get(Gunsmith.class, gunsmithID);
			tran.commit();
			return gunsmith;
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public boolean save(Salesrecord transientInstance) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List findList(String hql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			Query queryObject = session
					.createQuery(hql);
			tran.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean saveComRecord(Commission transientInstance) {
		// TODO Auto-generated method stub
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
