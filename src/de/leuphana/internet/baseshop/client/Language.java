package de.leuphana.internet.baseshop.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Language extends Composite {

	// Create panel
	VerticalPanel vp = new VerticalPanel();

	public Language() {

		initWidget(vp);
		
		// Buttons "translations"
		Button deutsch = new Button("Deutsch");
		Button english = new Button("English");

		final HorizontalPanel hPanel = new HorizontalPanel();

		deutsch.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.Location.assign(Window.Location.createUrlBuilder()
						.setParameter(LocaleInfo.getLocaleQueryParam(), "de")
						.buildString());
			}
		});

		hPanel.add(deutsch);

		english.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.Location.assign(Window.Location.createUrlBuilder()
						.setParameter(LocaleInfo.getLocaleQueryParam(), "en")
						.buildString());
			}
		});

		hPanel.add(english);
		vp.add(hPanel);

	}

}
