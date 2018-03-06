package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.pojo.User;

public class TestMy {

	@Test
	public void getUser() throws IOException {

		String resource = "mybatis-config.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();

		User user = session.selectOne("test.findUserById", 1);

		//System.out.println(user.toString());

		List<User> users = session.selectList("test.findUserByName", "С��");

		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user1 = (User) iterator.next();
			System.out.println(user1.toString());

		}

		
		User user2=new User();
		user2.setAddress("���� ֣��");
		user2.setBirthDay(new Date());
		user2.setSex("Ů");
		user2.setUserName("������");
		int re=session.insert("test.addUser", user2);
		System.out.println(re+"===========��ӳɹ���==========");
		session.delete("test.deluser",26);
		System.out.println("ɾ���ɹ���");
		//
		User user3=new User();
		user3.setSex("1");
		user3.setId(29);
		session.update("test.updateuser", user3);
		System.out.println("���³ɹ���");
		session.commit();
		session.close();
	}
	
	
	
	
	
}
