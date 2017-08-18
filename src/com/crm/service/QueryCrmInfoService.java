package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.crm.dao.CrmInfoDao;
import com.crm.dao.impl.CrmInfoDaoImpl;
import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.util.ConnectionFactory;


public class QueryCrmInfoService {
	
	private CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	
	public String[] queryCrmInfoX(CrmInfoEntityExtd crmInfo){
		
		Connection conn=null;
		
		try {
			
			conn = ConnectionFactory.getInstance().getConnection();
			ResultSet rs = crmInfoDao.getX(conn, crmInfo);
			String infoList[] = { "", "", ""};
			
			while (rs.next()) {
				
				infoList[0] = rs.getString("crm_name");
				infoList[1] = rs.getString("crm_title");
				infoList[2] = rs.getString("crm_role");
				return infoList;
			}

		} catch (Exception e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return null;
		
		
	}

}
