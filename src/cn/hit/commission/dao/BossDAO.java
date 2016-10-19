package cn.hit.commission.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;

public class BossDAO extends BaseHibernateDAO implements IBossDAO {

	@Override
	public int queryCount(int pageSize, String hql) {
		Transaction tran = null;
		Session session = null;
		int count;
		try {
			session = getSession();
			tran = session.beginTransaction();

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
	/*
	 * 按时间查询历史佣金情况
	 * @see cn.hit.commission.dao.IBossDAO#queryHistCommission(int, int, java.lang.String, java.lang.String)
	 */
	public List<Commission> queryHistCommission(int pageSize, int pageNum, String startTime, String endTime) {
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String hql = "from Commission as c where c.salesDate <= '" + endTime + "' and c.salesDate>= '" + startTime+"'";
			List<Commission> list = session.createQuery(hql).setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
			tran.commit();
			return list;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
