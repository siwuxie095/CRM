package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.LogInfoDao;
import com.crm.dao.impl.LogInfoDaoImpl;
import com.crm.entity.extd.LogInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyLogInfoService {
	
	private LogInfoDao logInfoDao=new LogInfoDaoImpl();
	
	public void modifyLogInfo(LogInfoEntityExtd logInfo) {

		Connection conn = null;

		try {

			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			logInfoDao.update(conn, logInfo);
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
