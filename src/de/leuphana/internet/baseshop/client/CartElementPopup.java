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
import de.leuphana.internet.baseshop.shared.CartElement;
import de.leuphana.internet.baseshop.shared.CartTable;
import de.leuphana.internet.baseshop.shared.Exam;

public class CartElementPopup extends DialogBox {

	// Exam uebergeben
	private Exam exam;
	private CartTable cartTable;
	private CartElement cartElement;

	// Uebersetzungen per Constants
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public CartElementPopup(final Exam exam, CartTable cartTable) {
		super();
		this.exam = exam;
		this.cartTable = cartTable;

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

	protected void addButtonsToPanel(VerticalPanel vp) {
		Button exitButton = new Button(constants.close());

		// ExitButton Handler
		exitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CartElementPopup.this.hide();
			}
		});

		// DeleteButton Handler
		Button deleteButton = new Button(constants.delete());
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				delFromCart(exam);
			}
		});

		vp.add(deleteButton);
		vp.add(exitButton);

	}

	// Element aus dem Warenkorb loeschen
	public void delFromCart(Exam exam) {
		Cart.getInstance().delCartElement(exam.getProductNumber(), cartElement);
		cartTable.updateCartTable();
	}

}
