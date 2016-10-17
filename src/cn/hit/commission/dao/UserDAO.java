package cn.hit.commission.dao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public class UserDAO extends BaseHibernateDAO implements IUserDAO {

	@Override
	public Salesman findBySalesID(int salesmanID) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			Salesman salesman = (Salesman) session.get(Salesman.class, salesmanID);
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
			Gunsmith gunsmith = (Gunsmith) session.get(Gunsmith.class, gunsmithID);
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
			Query queryObject = session.createQuery(hql);
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

	@Override
	public boolean updateUserPwd(Salesman salesman) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String hql = "update Salesman s set s.password = " + salesman.getPassword() + "where s.salesmanID = "
					+ salesman.getSalesmanID();
			Query queryObject = session.createQuery(hql);
			Salesman newSalesman = (Salesman) session.get(Salesman.class, salesman.getSalesmanID());
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
	public Salesman updateSalesman(Salesman salesman) {
		// TODO Auto-generated method stub
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(salesman.getUpdateTime());

			String hql = "update Salesman s set s.name = " + salesman.getName() + ",s.linkman = "
					+ salesman.getLinkman() + ",s.email = " + salesman.getEmail() + ",s.mobile = "
					+ salesman.getMobile() + ",s.address = " + salesman.getAddress() + ",s.updateTime = '" + dateString
					+ "' where s.salesmanID = " + salesman.getSalesmanID();
			System.out.println(hql);
			session.createQuery(hql).executeUpdate();
			Salesman newSalesman = (Salesman) session.get(Salesman.class, salesman.getSalesmanID());
			tran.commit();
			return newSalesman;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Salesman> selectSalesmenBypage(int pageSize, int pageNum) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String hql = "select s from Salesman s";
			List<Salesman> salesmanList = session.createQuery(hql).setFirstResult((pageNum - 1) * pageSize)
					.setMaxResults(pageSize).list();
			tran.commit();
			return salesmanList;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public int selectSalesmenCount(int pageSize) {
		Transaction tran = null;
		Session session = null;
		int count;
		try {
			session = getSession();
			tran = session.beginTransaction();

			String hql = "select count(*)  from Salesman";

			Object countObj = session.createQuery(hql).uniqueResult();
			if (countObj == null) {
				return 0;
			} else {
				count = (Integer.parseInt(countObj + "") + (pageSize - 1)) / pageSize;

			}
			tran.commit();
			return count;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return 0;
		} finally {
			session.close();
		}

	}

	@Override
	public boolean deleteSalesman(int salesmanID) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String hql = "update Salesman s set deleteFlag='1' where s.salesmanID = " + salesmanID;
			session.createQuery(hql).executeUpdate();
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
	public Salesman saveSalesman(Salesman salesman) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			// Ser
			Serializable id = session.save(salesman);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(new Date());
			String hql = "update Salesman s set s.createTime = '" + dateString + "' where s.salesmanID = " + id;
			// System.out.println(hql);
			session.createQuery(hql).executeUpdate();
			Salesman newSalesman = (Salesman) session.get(Salesman.class, id);
			tran.commit();
			return newSalesman;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Salesman updateSalesmanByBoss(Salesman salesman) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(new Date());

			String hql = "update Salesman s set s.name = " + salesman.getName() + ",s.linkman = "
					+ salesman.getLinkman() + ",s.email = " + salesman.getEmail() + ",s.mobile = "
					+ salesman.getMobile() + ",s.address = " + salesman.getAddress() + ",s.updateTime = '" + dateString
					+ "',s.password = '" + salesman.getPassword() + "' where s.salesmanID = "
					+ salesman.getSalesmanID();
			// System.out.println(hql);
			session.createQuery(hql).executeUpdate();
			Salesman newSalesman = (Salesman) session.get(Salesman.class, salesman.getSalesmanID());
			tran.commit();
			return newSalesman;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
