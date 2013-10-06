package de.leuphana.internet.baseshop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.CellPreviewEvent;

import de.leuphana.internet.baseshop.shared.Exam;

public class SearchResultPopup extends DialogBox {
	private final Button closeButton;

	// Ubersetzungen per Constants
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public SearchResultPopup(final ProductTable productTable,
			final Button searchButton, CellTable<Exam> table) {
		super();

		// Neues Panel erzeugen
		VerticalPanel vp = new VerticalPanel();

		// Fensternamen festlegen
		setText(constants.searchResult());

		// CloseButton hinzufuegen
		closeButton = new Button("Close");

		// Handler hinzufuegen
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				SearchResultPopup.this.hide();
				searchButton.setEnabled(true);
				searchButton.setFocus(true);
			}
		});

		// Button zum Panel hinzufuegen
		vp.add(closeButton);

		// PreviewHandler fuer Popup erstellen
		table.addCellPreviewHandler(new CellPreviewEvent.Handler<Exam>() {

			@Override
			public void onCellPreview(CellPreviewEvent<Exam> event) {
				if ("click".equals(event.getNativeEvent().getType())) {
					SearchResultPopup.this.hide();
					new DetailsPopup(null, SearchResultPopup.this, (Exam) event
							.getValue());
				}
			}
		});

		SimplePager pager = new SimplePager();
		pager.setDisplay(table);

		// Elemente zum Panel hinzufuegen
		vp.add(table);
		vp.add(pager);
		vp.add(closeButton);
		setWidget(vp);
		center();
		closeButton.setFocus(true);
	}
}
