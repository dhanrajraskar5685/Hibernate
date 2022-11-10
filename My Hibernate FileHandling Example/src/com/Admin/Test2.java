package com.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.FileData;
import com.Util.HibernateUtil;

public class Test2 {
	private static final String UPLOAD_DIR = "D:\\";
	
	public static void main(String[] args) throws IOException {
		
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	Session session = sf.openSession();
	
	FileData f = session.get(FileData.class, 1);
	
	Path path = Paths.get(UPLOAD_DIR+f.getFname());
	
	Files.write(path, f.getFdata());

}
}