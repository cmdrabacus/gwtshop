package de.leuphana.internet.baseshop.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.leuphana.internet.baseshop.shared.Cart;
import de.leuphana.internet.baseshop.shared.CartTable;

public class Baseshop implements EntryPoint {

	// Singleton
	Cart cart = Cart.getInstance();
	CartTable cartTable = new CartTable();

	// Translations
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	public void onModuleLoad() {

		// Menue tabs
		TabLayoutPanel tabMenu = new TabLayoutPanel(5, Unit.CM);
		tabMenu.animate(4);
		tabMenu.add(new ProductTable(), constants.products());
		tabMenu.add(cartTable, constants.cart());
		tabMenu.add(new Backend(), constants.adminArea());
		tabMenu.add(new Language(), constants.language());

		tabMenu.addSelectionHandler(new SelectionHandler<Integer>() {
			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				if (event.getSelectedItem() == 1) {
					cartTable.updateCartTable();
				}
			}
		});

		// Add tabs to rootlayoutpanel
		RootLayoutPanel.get().add(tabMenu);

	}

}