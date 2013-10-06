package de.leuphana.internet.baseshop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.leuphana.internet.baseshop.shared.Cart;
import de.leuphana.internet.baseshop.shared.Exam;

public class DetailsPopup extends DialogBox {

	// Exam uebergeben
	private Exam exam;

	// Uebersetzungen per Constants
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public DetailsPopup(ProductTable productTable, SearchResultPopup searchResultPopup, Exam exam) {
		super();
		this.exam = exam;

		VerticalPanel detailsPanel = new VerticalPanel();

		detailsPanel.add(new Label(constants.topic() + ": " + exam.getTopic()));
		detailsPanel.add(new Label(constants.pageCount() + ": "
				+ exam.getSiteCount()));
		detailsPanel.add(new Label(constants.student() + ": "
				+ exam.getBachelorstudent()));
		detailsPanel.add(new Label(constants.price() + ": " + exam.getPrice()));
		detailsPanel.add(new Label(constants.year() + ": " + exam.getYear()));

		// Buttons zum Panel hinzufuegen
		addButtonsToPanel(detailsPanel);

		// DialogBox formatieren
		Grid grid = new Grid(1, 2);
		HTMLTable.CellFormatter formatter = grid.getCellFormatter();
		formatter.setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
		formatter.setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
		grid.setWidget(0, 1, detailsPanel);
		setWidget(grid);
		center();
	}

	protected void addButtonsToPanel(VerticalPanel vertiPan) {
		Button exitButton = new Button(constants.close());
		// Exit-Button hinzufuegen
		exitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DetailsPopup.this.hide();

			}
		});

		Button buyButton = new Button(constants.buy());
		buyButton.addClickHandler(new ClickHandler() {

			// Buy-Button hinzufuegen
			@Override
			public void onClick(ClickEvent event) {
				Cart.getInstance().addToCart(exam);
			}
		});
		
		// Buttons zum Panel hinzufuegen
		vertiPan.add(buyButton);
		vertiPan.add(exitButton);
		exitButton.setFocus(true);
	}
}
