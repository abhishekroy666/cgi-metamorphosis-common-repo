package resource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	static SessionFactory sf;
	public static SessionFactory getConnection(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		sf = con.buildSessionFactory();
		return sf;
	}
	
}
