package de.leuphana.internet.baseshop.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.leuphana.internet.baseshop.client.DataService;
import de.leuphana.internet.baseshop.shared.BachelorThesis;
import de.leuphana.internet.baseshop.shared.Exam;
import de.leuphana.internet.baseshop.shared.SeminarPaper;

@SuppressWarnings("serial")
public class DataServiceImpl extends RemoteServiceServlet implements
DataService {
	private Session getSession() {
		try {
			return HibernateUtil.getSessionFactory().getCurrentSession();
		} catch (HibernateException hEx) {
			// Fehler fuer Current Session
			return HibernateUtil.getSessionFactory().openSession();
		}
	}

	public List<Exam> getList(int start, int length) {
		// Neue Liste erstellen
		List<Exam> dbResult = new ArrayList<Exam>();
		List<Exam> exam = new ArrayList<Exam>();
		
		// Session erstellen
		Session session = getSession();
		session.beginTransaction();
		exam.addAll(querySeminarworks(session, "from SeminarPaper"));
		exam.addAll(queryBachelorthesis(session, "from BachelorThesis"));
		session.getTransaction().commit();

		if (exam.size() == 0) {
			loadStandardData();

			session = getSession();
			session.beginTransaction();
			exam.addAll(querySeminarworks(session, "from SeminarPaper"));
			exam.addAll(queryBachelorthesis(session, "from BachelorThesis"));
			session.getTransaction().commit();
		}

		Iterator<Exam> dataIterator = exam.iterator();

		for (int i = 0; i < start; i++) {
			if (dataIterator.hasNext()) {
				dataIterator.next();
			}
		}
		for (int i = 0; i < length; i++) {
			if (dataIterator.hasNext()) {
				dbResult.add(dataIterator.next());
			}
		}

		return dbResult;
	}

	private void loadStandardData() {
		Session session = getSession();

		session.beginTransaction();
		SeminarPaper seminar = new SeminarPaper();
		seminar.setYear(1999);
		seminar.setSiteCount(30);
		seminar.setLecturer("Max Mustermann");
		seminar.setTopic("Internettechnologien");
		seminar.setCourse("Internettechnologien");
		seminar.setBachelorstudent("Guenther Frosch");
		seminar.setPrice(13);

		session.save(seminar);

		seminar = new SeminarPaper();
		seminar.setLecturer("Max Mustermann");
		seminar.setYear(2001);
		seminar.setSiteCount(15);
		seminar.setTopic("Softwarearchitekturen");
		seminar.setCourse("Softwarearchitekturen");
		seminar.setBachelorstudent("Albert Alt");
		seminar.setPrice(11);

		session.save(seminar);

		BachelorThesis bachelorThesis = new BachelorThesis();
		bachelorThesis.setBachelorstudent("Hans-Albrecht Mueller");
		bachelorThesis.setFirstexaminer("Max Mustermann");
		bachelorThesis.setSecondexaminer("Guenther Mustermann");
		bachelorThesis.setYear(2003);
		bachelorThesis.setSiteCount(65);
		bachelorThesis.setTopic("GWT");
		bachelorThesis.setPrice(29);

		session.save(bachelorThesis);

		bachelorThesis = new BachelorThesis();
		bachelorThesis.setBachelorstudent("Guenther Frosch");
		bachelorThesis.setFirstexaminer("Max Mustermann");
		bachelorThesis.setSecondexaminer("Guenther Mustermann");
		bachelorThesis.setYear(2005);
		bachelorThesis.setSiteCount(45);
		bachelorThesis.setTopic("BWL");
		bachelorThesis.setPrice(29);

		session.save(bachelorThesis);

		session.getTransaction().commit();
	}

	// Suchfunktion
	public List<Exam> getSearchList(int start, int length, String search) {
		List<Exam> searchResult = new ArrayList<Exam>();

		List<Exam> exam = new ArrayList<Exam>();
		Session session = getSession();
		if (session != null) {
			session.beginTransaction();
			String searchQuery = " where topic like '%" + search + "%'";
			exam.addAll(querySeminarworks(session, "from SeminarPaper"
					+ searchQuery));
			exam.addAll(queryBachelorthesis(session, "from BachelorThesis"
					+ searchQuery));
			session.getTransaction().commit();
		}
		Iterator<Exam> dataIterator = exam.iterator();

		for (int i = 0; i < start; i++) {
			if (dataIterator.hasNext()) {
				dataIterator.next();
			}
		}
		for (int i = 0; i < length; i++) {
			if (dataIterator.hasNext()) {
				searchResult.add(dataIterator.next());
			}
		}

		return searchResult;
	}

	private List<Exam> querySeminarworks(Session session, String query) {
		List<Exam> seminararbeiten = new ArrayList<>();

		@SuppressWarnings("unchecked")
		Iterator<SeminarPaper> resultIterator = session.createQuery(query)
		.list().iterator();
		while (resultIterator.hasNext()) {
			seminararbeiten.add(resultIterator.next());
		}

		return seminararbeiten;
	}

	private List<Exam> queryBachelorthesis(Session session, String query) {
		List<Exam> bachelorthesis = new ArrayList<>();

		@SuppressWarnings("unchecked")
		Iterator<BachelorThesis> resultIterator = session.createQuery(query)
		.list().iterator();
		while (resultIterator.hasNext()) {
			bachelorthesis.add(resultIterator.next());
		}

		return bachelorthesis;
	}

	@Override
	public Boolean addExam(Exam exam) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.save(exam);
			session.getTransaction().commit();

			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
