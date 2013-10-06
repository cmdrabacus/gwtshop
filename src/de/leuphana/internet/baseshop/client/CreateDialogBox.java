package de.leuphana.internet.baseshop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import de.leuphana.internet.baseshop.shared.BachelorThesis;
import de.leuphana.internet.baseshop.shared.SeminarPaper;

public class CreateDialogBox extends DialogBox {
	private final DataServiceAsync dataService = GWT.create(DataService.class);

	// Translations
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	// Dialogbox "Create Seminarpaper"
	public CreateDialogBox(Backend backend, final SeminarPaper seminarpaper) {
		super();

		// Creata grid
		Grid grid = new Grid(10, 2);

		// Create labels
		grid.setWidget(0, 0, new Label(constants.topic()));
		grid.setWidget(1, 0, new Label(constants.course()));
		grid.setWidget(2, 0, new Label(constants.docent()));
		grid.setWidget(3, 0, new Label(constants.bachelorstudent()));
		grid.setWidget(4, 0, new Label(constants.pageCount()));		
		grid.setWidget(5, 0, new Label(constants.year()));
		grid.setWidget(6, 0, new Label(constants.price()));

		// Create formelements
		final TextBox topicField = new TextBox();
		final TextBox courseField = new TextBox();
		final TextBox docentField = new TextBox();
		final TextBox studentField = new TextBox();
		final TextBox pageCountField = new TextBox();
		final TextBox yearField = new TextBox();
		final TextBox priceField = new TextBox();

		// Add labels to grid
		grid.setWidget(0, 1, topicField);
		grid.setWidget(1, 1, courseField);
		grid.setWidget(2, 1, docentField);
		grid.setWidget(3, 1, studentField);
		grid.setWidget(4, 1, pageCountField);
		grid.setWidget(5, 1, yearField);
		grid.setWidget(6, 1, priceField);

		setText(constants.createSeminarPaper());

		// Create close button
		Button closeButton = new Button(constants.close());

		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CreateDialogBox.this.hide();
			}
		});

		// Handler
		Button createButton = new Button(constants.create());
		createButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				seminarpaper.setTopic(topicField.getText());
				seminarpaper.setCourse(courseField.getText());
				seminarpaper.setLecturer(docentField.getText());
				seminarpaper.setBachelorstudent(studentField.getText());
				seminarpaper.setPrice(Integer.valueOf(priceField.getText()));
				try {
					seminarpaper.setSiteCount(Integer.parseInt(pageCountField
							.getText()));
				} catch (Exception ex) {
				}
				try {
					seminarpaper.setYear(Integer.parseInt(yearField.getText()));
				} catch (Exception ex) {
				}
				addSeminarWork(seminarpaper);
			}
		});

		// Add buttons to grid
		grid.setWidget(7, 1, createButton);
		grid.setWidget(8, 1, closeButton);
		setWidget(grid);
		center();
		closeButton.setFocus(true);
	}

	// Dialogbox "Create Bachelorpaper"
	public CreateDialogBox(Backend backend, final BachelorThesis bachelorthesis) {
		super();

		// Create grid
		Grid grid = new Grid(10, 2);

		// Create labels
		grid.setWidget(0, 0, new Label(constants.topic()));
		grid.setWidget(1, 0, new Label(constants.student()));
		grid.setWidget(2, 0, new Label(constants.firstValidator()));
		grid.setWidget(3, 0, new Label(constants.secondValidator()));
		grid.setWidget(4, 0, new Label(constants.pageCount()));
		grid.setWidget(5, 0, new Label(constants.year()));
		grid.setWidget(6, 0, new Label(constants.price()));

		// Create elements
		final TextBox topicField = new TextBox();
		final TextBox studentField = new TextBox();
		final TextBox firstValidatorField = new TextBox();
		final TextBox secondValidatorField = new TextBox();
		final TextBox pageCountField = new TextBox();
		final TextBox yearField = new TextBox();
		final TextBox priceField = new TextBox();

		// Add labels to grid
		grid.setWidget(0, 1, topicField);
		grid.setWidget(1, 1, studentField);
		grid.setWidget(2, 1, firstValidatorField);
		grid.setWidget(3, 1, secondValidatorField);
		grid.setWidget(4, 1, pageCountField);
		grid.setWidget(5, 1, yearField);
		grid.setWidget(6, 1, priceField);

		setText(constants.createBachelorPaper());

		// Close Button Handler
		Button exitButton = new Button(constants.close());
		exitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CreateDialogBox.this.hide();
			}
		});

		// Handler for createButton
		Button createPaperButton = new Button(constants.create());
		createPaperButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bachelorthesis.setTopic(topicField.getText());
				bachelorthesis.setBachelorstudent(studentField.getText());
				bachelorthesis.setFirstexaminer(firstValidatorField.getText());
				bachelorthesis.setSecondexaminer(secondValidatorField.getText());
				bachelorthesis.setPrice(Integer.valueOf(((priceField.getText()))));
				try {
					bachelorthesis.setSiteCount(Integer.parseInt(pageCountField
							.getText()));
				} catch (Exception ex) {
				}
				try {
					bachelorthesis.setYear(Integer.parseInt(yearField.getText()));
				} catch (Exception ex) {
				}
				addBachelorThesis(bachelorthesis);
			}
		});

		// Add buttons to grid
		grid.setWidget(7, 1, createPaperButton);
		grid.setWidget(8, 1, exitButton);
		setWidget(grid);
		center();
		exitButton.setFocus(true);
	}

	// Methods for add
	public void addBachelorThesis(BachelorThesis bachelorThesis) {
		dataService.addExam(bachelorThesis, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {

			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	public void addSeminarWork(SeminarPaper seminarwork) {
		dataService.addExam(seminarwork, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {

			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

}
