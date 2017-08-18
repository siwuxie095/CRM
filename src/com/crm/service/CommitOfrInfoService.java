package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.OfrInfoDao;
import com.crm.dao.OppInfoDao;
import com.crm.dao.impl.OfrInfoDaoImpl;
import com.crm.dao.impl.OppInfoDaoImpl;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class CommitOfrInfoService {
	
	private OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
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
	
	public void commitOfrInfo(OfrInfoEntityExtd ofrInfo){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			ofrInfoDao.save(conn, ofrInfo);
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
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
