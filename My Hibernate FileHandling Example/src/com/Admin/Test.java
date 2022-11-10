package com.Admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.FileData;
import com.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		FileData filedata = new FileData();
		File file = new File("C:\\npkey.txt");

		filedata.setFid(2);
		filedata.setFname(file.getName());
		filedata.setFpath(file.getAbsolutePath());
		filedata.setFsize(file.length());

		java.nio.file.Path path = Paths.get(file.getAbsolutePath());
		byte[] fbyte = Files.readAllBytes(path);
		filedata.setFdata(fbyte);
		session.save(filedata);
		session.beginTransaction().commit();
	}
}
