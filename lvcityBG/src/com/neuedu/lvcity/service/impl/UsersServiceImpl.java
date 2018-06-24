package com.neuedu.lvcity.service.impl;

import java.sql.Connection;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.UsersDao;
import com.neuedu.lvcity.dao.impl.UsersDaoImpl;
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.UsersService;

public class UsersServiceImpl implements UsersService{
	/**
	  * ���췽��˽�л�
	  */
	private UsersServiceImpl(){
		
	}
	/**
	  * ����һ��Ψһ��ʵ��
	  */
	 private static UsersServiceImpl Instance = new UsersServiceImpl();
	 
	 /**
	  * �ṩһ��������ʵĹ����ӿ�
	  * @return
	  */
	 public static  UsersService getInstance() {
		return Instance;
	}
	 
	 public Users login(String username,String passwrod){
	//���ؽ��
			Users users = null;
			//��������
			Connection conn= null;
			try{
					//��ȡ���ݿ�����
					conn = DBUtils.getConnection();
					//�õ�dao��ʵ����Ķ���
					UsersDao usersDao = new UsersDaoImpl(conn);
					//����dao��ķ���
					users = usersDao.login(username, passwrod);
			}catch(Exception exception ){
				System.out.println("��¼��ѯ�û��ǳ����쳣��"+exception.getMessage());
			}finally {
				DBUtils.closeConnection(conn);
			}		
			return users;	
	 }

}
	 
