package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.DealInfoDao;
import com.crm.dao.impl.DealInfoDaoImpl;
import com.crm.entity.extd.DealInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyDealInfoService {
	
	private DealInfoDao dealInfoDao=new DealInfoDaoImpl();

	
	public void modifyDealInfo(DealInfoEntityExtd dealInfo) {

		Connection conn = null;

		try {

			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			dealInfoDao.update(conn, dealInfo);
			conn.commit();

		} catch (SQLException e) {

			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();

			try {
				conn.rollback();
				System.out.println("------------- 事务回滚成功 -------------");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
}
