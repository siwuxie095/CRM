package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.LogInfoDao;
import com.crm.dao.OppInfoDao;
import com.crm.dao.impl.LogInfoDaoImpl;
import com.crm.dao.impl.OppInfoDaoImpl;
import com.crm.entity.extd.LogInfoEntityExtd;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class CommitLogInfoService {
	
	private LogInfoDao logInfoDao=new LogInfoDaoImpl();
	private OppInfoDao oppInfoDao=new OppInfoDaoImpl();


	public boolean checkCustCtcOpp(OppInfoEntityExtd oppInfo){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			ResultSet rs=oppInfoDao.getZ(conn, oppInfo);
			while (rs.next()) {
				return true;
			}


		} catch (SQLException e) {

			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();

		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return false;


	}
	
	public void commitLogInfo(LogInfoEntityExtd logInfo) {

		Connection conn = null;

		try {

			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			logInfoDao.save(conn, logInfo);
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
