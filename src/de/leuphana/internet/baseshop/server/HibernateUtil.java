package de.leuphana.internet.baseshop.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import de.leuphana.internet.baseshop.shared.BachelorThesis;
import de.leuphana.internet.baseshop.shared.SeminarPaper;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Load config
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(BachelorThesis.class);
			config.addAnnotatedClass(SeminarPaper.class);
			config.configure();
			new SchemaExport(config).create(true, true);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			// Exception handling
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}