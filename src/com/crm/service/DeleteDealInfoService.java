package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.DealInfoDao;
import com.crm.dao.impl.DealInfoDaoImpl;
import com.crm.entity.extd.DealInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteDealInfoService {
	
	private DealInfoDao dealInfoDao=new DealInfoDaoImpl();
	
	
	public void deleteDealInfo(DealInfoEntityExtd dealInfo){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			dealInfoDao.delete(conn, dealInfo);

		} catch (SQLException e) {

			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();

		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteMulDealInfo(DealInfoEntityExtd dealInfo[]){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			dealInfoDao.deleteMul(conn, dealInfo);

		} catch (SQLException e) {

			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();

		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


}
