package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.DealInfoDao;
import com.crm.dao.OfrInfoDao;
import com.crm.dao.impl.DealInfoDaoImpl;
import com.crm.dao.impl.OfrInfoDaoImpl;
import com.crm.entity.extd.DealInfoEntityExtd;
import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class CommitDealInfoService {

	private DealInfoDao dealInfoDao = new DealInfoDaoImpl();
	private OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
	
	
public boolean checkCustCtcOppOfr(OfrInfoEntityExtd ofrInfo){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			ResultSet rs=ofrInfoDao.getZ(conn, ofrInfo);
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


	public void commitDealInfo(DealInfoEntityExtd dealInfo) {

		Connection conn = null;

		try {

			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			dealInfoDao.save(conn, dealInfo);
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
