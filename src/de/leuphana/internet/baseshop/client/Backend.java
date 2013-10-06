package de.leuphana.internet.baseshop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.leuphana.internet.baseshop.shared.BachelorThesis;
import de.leuphana.internet.baseshop.shared.BackendAccess;
import de.leuphana.internet.baseshop.shared.SeminarPaper;

public class Backend extends Composite {

	// Panels erzeugen
	public VerticalPanel vp = new VerticalPanel();

	// Neues Admin Objekt erzeugen
	BackendAccess admin = new BackendAccess();

	// Uebersetzungen per Constants
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public Backend() {
		// Widget initalisieren
		Widget wg = new Widget();
		wg = onInitialize();
		initWidget(wg);
	}

	public Widget onInitialize() {

		// Form Elemente festlegen
		final TextBox username;
		final PasswordTextBox password;
		final FormPanel formPanel = new FormPanel();
		final SubmitButton button = new SubmitButton(constants.login());

		// Panels erzeugen
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.add(formPanel);

		formPanel.setAction("servletpath/login");
		formPanel.setMethod(FormPanel.METHOD_POST);

		vp.setWidth("100%");
		formPanel.setWidget(vp);

		// Forms erzeugen
		username = new TextBox();
		password = new PasswordTextBox();
		
		// Panels erzeugen
		final HorizontalPanel hPanel = new HorizontalPanel();
		final HorizontalPanel BAhPanel = new HorizontalPanel();
		final HorizontalPanel SEhPanel = new HorizontalPanel();
		
		// Buttons erzeugen
		final Button embedBA = new Button(constants.createBachelorPaper());
		embedBA.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new CreateDialogBox(null, new BachelorThesis());
			}
		});

		final Button embedSE = new Button(constants.createSeminarPaper());
		embedSE.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new CreateDialogBox(null, new SeminarPaper());
			}
		});
		embedSE.setVisible(false);

		// Widgets zum Panel hinzufuegen
		BAhPanel.add(embedBA);
		SEhPanel.add(embedSE);
		embedBA.setVisible(false);
		hPanel.add(BAhPanel);
		hPanel.add(SEhPanel);
		hPanel.setVisible(false);
		vp.add(username);
		vp.add(password);
		vp.add(button);
		vp.add(hPanel);

		// Handler erzeugen
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (username.getText().equalsIgnoreCase(admin.getUser())
						&& password.getText().equals(admin.getPassword())) {
					button.setVisible(false);
					username.setVisible(false);
					password.setVisible(false);
					hPanel.setVisible(true);
					embedBA.setVisible(true);
					embedSE.setVisible(true);

				} else {
					Window.alert("Please enter the correct username and password!");
				}
			}
		});
		return vp;
	}

}
