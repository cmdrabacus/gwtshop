package de.leuphana.internet.baseshop.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.leuphana.internet.baseshop.shared.Exam;

public interface DataServiceAsync {
	void getList(int start, int length, AsyncCallback<List<Exam>> callback);
	void getSearchList(int start, int length, String search, AsyncCallback<List<Exam>> callback);
	void addExam(Exam exam, AsyncCallback<Boolean> callback);
}
