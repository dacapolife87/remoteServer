package net.remote.remoteServer.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.remote.remoteServer.vo.LoginUser;

public class AccountDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	
	public AccountDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public LoginUser selectLogin(LoginUser loginuser){
		HashMap result;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	result = session.selectOne("Account.selectLogin", loginuser);
 
        } finally {
            session.close();
        }
        System.out.println("selectOne("+loginuser+") --> "+result);
        return loginuser;
    }
	
}
