package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	
	@FXML	public TextField nameField, priceField, quantityField;
	
	@FXML
	private TableView<Product> productTable;
	@FXML
	private TableColumn<Product, String> nameColumn;
	@FXML
	private TableColumn<Product, Double> priceColumn;
	@FXML
	private TableColumn<Product, Integer> quantityColumn;
	
	private ObservableList<Product> productList =
	FXCollections.observableArrayList();
	
	
	@FXML
	public void initialize() {
	nameColumn.setCellValueFactory(new
	PropertyValueFactory<>("name"));
	priceColumn.setCellValueFactory(new
	PropertyValueFactory<>("price"));
	quantityColumn.setCellValueFactory(new
	PropertyValueFactory<>("quantity"));
	productTable.setItems(productList);
	}
	
	@FXML
	public void addProduct() {
	String name = nameField.getText();
	double price = Double.parseDouble(priceField.getText());
	int quantity = Integer.parseInt(quantityField.getText());
	Product newProduct = new Product(name, price, quantity);
	productList.add(newProduct);
	nameField.clear();
	priceField.clear();
	quantityField.clear();
	
	}
	
	
}
