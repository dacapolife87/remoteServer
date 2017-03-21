package net.remote.remoteServer.common.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisConnectionFactory {
	public static SqlSessionFactory ssf;
	public static MyBatisConnectionFactory instance = null;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public static MyBatisConnectionFactory getInstance(){
		if(instance == null){
			instance = new MyBatisConnectionFactory();
		}
		return instance;
	}
	public MyBatisConnectionFactory(){
		try {
			String resource = "MyBatisConfig.xml";
			Reader reader;
			InputStream is = Resources.getResourceAsStream(resource);
			reader = Resources.getResourceAsReader(resource);
			System.out.println("reader : "+reader.toString());
			System.out.println("reader : "+reader.read());
			if (ssf == null) {
				logger.debug("test2");
				ssf = new SqlSessionFactoryBuilder().build(is);
	        }
			logger.debug("test3");
			System.out.println("ssf");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static SqlSessionFactory getSqlSessionFactory() {
        return ssf;
    }
	
}
