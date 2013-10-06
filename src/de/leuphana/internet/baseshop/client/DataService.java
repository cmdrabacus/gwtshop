package de.leuphana.internet.baseshop.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.leuphana.internet.baseshop.shared.Exam;

@RemoteServiceRelativePath("greet")
public interface DataService extends RemoteService {
	List<Exam> getList(int start, int length);
	List<Exam> getSearchList(int start, int length, String search);
	Boolean addExam(Exam exam);
}
