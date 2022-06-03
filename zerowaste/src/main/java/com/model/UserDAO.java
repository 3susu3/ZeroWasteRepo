package com.model;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class UserDAO {

		private SqlSessionFactory sql = SqlSessionManager.getSqlSessionFactory();
		private int cnt = 0;
		private SqlSession session = null;
		
		public int join(UserVO uvo) {
			try {
				session = sql.openSession(true);
				cnt = session.insert("insert", uvo);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return cnt;
		}
}