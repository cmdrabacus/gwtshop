package de.leuphana.internet.baseshop.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.HasData;

import de.leuphana.internet.baseshop.client.DataService;
import de.leuphana.internet.baseshop.client.DataServiceAsync;
import de.leuphana.internet.baseshop.client.DetailsPopup;
import de.leuphana.internet.baseshop.shared.Exam;

public class ProductTable extends Composite {
	

	// Init DataService
	final DataServiceAsync dataService = GWT.create(DataService.class);
	VerticalPanel contentPanel = new VerticalPanel();

	// Translations
	private BaseShopConstants constants = GWT.create(BaseShopConstants.class);

	public BaseShopConstants getConstants() {
		return constants;
	}

	// Search
	public final Button searchButton = new Button(constants.search());
	public final TextBox searchField = new TextBox();

	// Widget
	public ProductTable() {
		Widget wg = new Widget();
		wg = onInitialize();
		initWidget(wg);

	}

	public Widget onInitialize() {

		// Buttons and search
		searchField.setText(constants.search());
		searchField.setFocus(true);
		searchField.selectAll();

		// Create table
		final CellTable<Exam> table = new CellTable<Exam>();

		// Table settings
		table.setWidth("100%", true);
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		table.setPageSize(5);
		table.setVisibleRange(0, 5);
		table.addCellPreviewHandler(new CellPreviewEvent.Handler<Exam>() {

			@Override
			public void onCellPreview(CellPreviewEvent<Exam> event) {
				if ("click".equals(event.getNativeEvent().getType())) {
					new DetailsPopup(null, null, (Exam) event.getValue());
				}
			}
		});

		// Name column
		TextColumn<Exam> nameColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam examObject) {
				return examObject.getTopic();
			}
		};
		table.addColumn(nameColumn, constants.topic());

		// Author column
		TextColumn<Exam> addressColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam examObject) {
				return examObject.getBachelorstudent();
			}
		};
		table.addColumn(addressColumn, constants.student());

		// Price column
		TextColumn<Exam> priceColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam examObject) {
				return String.valueOf(examObject.getPrice());
			}
		};
		table.addColumn(priceColumn, constants.price());

		// Dataprovider 
		AsyncDataProvider<Exam> dataProvider = new AsyncDataProvider<Exam>() {

			// Load from database
			@Override
			protected void onRangeChanged(HasData<Exam> display) {
				final int start = display.getVisibleRange().getStart();
				int length = display.getVisibleRange().getLength();
				AsyncCallback<List<Exam>> callback = new AsyncCallback<List<Exam>>() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(List<Exam> result) {
						updateRowData(start, result);
					}
				};
				dataService.getList(start, length, callback);
			}
		};
		dataProvider.addDataDisplay(table);

		// Dialogbox
		table.addCellPreviewHandler(new CellPreviewEvent.Handler<Exam>() {

			@Override
			public void onCellPreview(CellPreviewEvent<Exam> event) {
				if ("click".equals(event.getNativeEvent().getType())) {
					new DetailsPopup(null, null, (Exam) event.getValue());
				}
			}
		});

		SimplePager pager = new SimplePager();
		pager.setDisplay(table);

		// Add widgets to panel
		VerticalPanel vp = new VerticalPanel();
		vp.add(searchField);
		vp.add(table);
		vp.add(pager);
		

		class MyHandler implements ClickHandler, KeyUpHandler {

			// Event "button"
			public void onClick(ClickEvent event) {
				executeSearch();
			}

			// Event "enter"
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					executeSearch();
				}
			}

			// Server communications
			private void executeSearch() {
				String searchText = searchField.getText();

				CellTable<Exam> searchResultTable = createTable();
				loadSearchResultCellTable(searchResultTable, searchText);

				// Results popup
				new SearchResultPopup(ProductTable.this, searchButton,
						searchResultTable);

				loadSearchResultCellTable(searchResultTable, searchText);
			}
		}

		// Handler 
		MyHandler handler = new MyHandler();
		searchButton.addClickHandler(handler);
		searchField.addKeyUpHandler(handler);

		// Add widgets to contentpanel
		contentPanel.add(vp);

		return vp;

	}

	// Result table
	private void loadSearchResultCellTable(CellTable<Exam> searchResultTable,
			final String search) {

		// DataProvider 
		AsyncDataProvider<Exam> dataProvider = new AsyncDataProvider<Exam>() {

			@Override
			protected void onRangeChanged(HasData<Exam> display) {
				final int start = display.getVisibleRange().getStart();
				int length = display.getVisibleRange().getLength();
				AsyncCallback<List<Exam>> serverCallback = new AsyncCallback<List<Exam>>() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(List<Exam> result) {
						updateRowData(start, result);
					}
				};
				dataService.getSearchList(start, length, search, serverCallback);
			}
		};
		dataProvider.addDataDisplay(searchResultTable);
	}

	private CellTable<Exam> createTable() {
		CellTable<Exam> table = new CellTable<Exam>();

		// price column
		TextColumn<Exam> priceColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam exam) {
				return String.valueOf(exam.getPrice());
			}
		};
		table.addColumn(priceColumn, constants.price());

		// theme column
		TextColumn<Exam> nameColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam exam) {
				return exam.getTopic();
			}
		};
		table.addColumn(nameColumn, constants.topic());

		// author column
		TextColumn<Exam> yearColumn = new TextColumn<Exam>() {
			@Override
			public String getValue(Exam exam) {
				return exam.getBachelorstudent();
			}
		};
		table.addColumn(yearColumn, constants.bachelorstudent());

		
		return table;
	}

}
