package de.leuphana.internet.baseshop.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;

import de.leuphana.internet.baseshop.client.BaseShopConstants;
import de.leuphana.internet.baseshop.client.CartElementPopup;

public class CartTable extends Composite {

	// Create cart table
	CellTable<CartElement> cartCell = new CellTable<CartElement>();
	
	CartTable cartTable = this;

	// Translations
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public CartTable() {
		Widget wg = new Widget();
		wg = onInitialize();
		initWidget(wg);

	}

	private Widget onInitialize() {

		// cart table settings
		cartCell.setWidth("100%", true);
		cartCell.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cartCell.setPageSize(3);
		cartCell.setVisibleRange(0, 3);

		cartCell.addCellPreviewHandler(new CellPreviewEvent.Handler<CartElement>() {

			@Override
			public void onCellPreview(CellPreviewEvent<CartElement> event) {
				if ("click".equals(event.getNativeEvent().getType())) {
					Exam exam = ((CartElement) event.getValue()).getExam();
					new CartElementPopup(exam, cartTable);
				}
			}
		});

		// quantity column
		TextColumn<CartElement> anzahlColumn = new TextColumn<CartElement>() {
			@Override
			public String getValue(CartElement element) {
				return String.valueOf(element.getQuantity());
			}
		};
		cartCell.addColumn(anzahlColumn, constants.quantity());

		// author column
		TextColumn<CartElement> authorNameColumn = new TextColumn<CartElement>() {
			@Override
			public String getValue(CartElement element) {
				return element.getExam().getBachelorstudent();
			}
		};
		cartCell.addColumn(authorNameColumn, constants.student());

		// product name column
		TextColumn<CartElement> productNameColumn = new TextColumn<CartElement>() {
			@Override
			public String getValue(CartElement element) {
				return element.getExam().getTopic();
			}
		};
		cartCell.addColumn(productNameColumn, constants.topic());

		Button orderButton = new Button(constants.order());
		orderButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Order button
				Window.alert("Successful!");
			}
		});

		// Create panel
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		VerticalPanel vertiPan = new VerticalPanel();

		// panel settings
		vertiPan.add(orderButton);
		vertiPan.add(cartCell);
		horizontalPanel.setWidth("100%");
		horizontalPanel
		.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(vertiPan);

		return horizontalPanel;

	}

	// update cart
	public void updateCartTable() {
		List<CartElement> elementList = new ArrayList<CartElement>();
		for (CartElement element : Cart.getInstance().getCartElements()) {
			elementList.add(element);
		}
		cartCell.setRowData(elementList);
	}

}
