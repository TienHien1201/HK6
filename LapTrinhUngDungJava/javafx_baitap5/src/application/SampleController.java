package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	
	@FXML	
	public TextField nameField, priceField, quantityField,searchField;
	
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
	
	private Product selectedProduct;
	
	
	@FXML
	public void initialize() {
	nameColumn.setCellValueFactory(new
	PropertyValueFactory<>("name"));
	priceColumn.setCellValueFactory(new
	PropertyValueFactory<>("price"));
	quantityColumn.setCellValueFactory(new
	PropertyValueFactory<>("quantity"));
	productTable.setItems(productList);
	
	Product newProduct = new Product("Bia Hà Nội", 125000, 10);
	productList.add(newProduct);
	
	newProduct = new Product("Bia Sài Gòn", 130000, 10);
	productList.add(newProduct);
	
	newProduct = new Product("Khoai tây", 30000, 10);
	productList.add(newProduct);
	
	newProduct = new Product("Củ cải", 30000, 10);
	productList.add(newProduct);
	
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
	
	@FXML
	public void searchProduct() {
		String searchQuery = searchField.getText().toLowerCase();
		
		ObservableList<Product> filteredList =
		FXCollections.observableArrayList();
		
		for (Product product : productList) {
			if (product.getName().toLowerCase().contains(searchQuery)) 
			{
				filteredList.add(product);
			}
		}
		productTable.setItems(filteredList);
		}
	
	
	@FXML
	public void selectProduct() {
	selectedProduct = productTable.getSelectionModel().getSelectedItem();
	if (selectedProduct != null) {
	nameField.setText(selectedProduct.getName());
	priceField.setText(String.valueOf(selectedProduct.getPrice()));
	quantityField.setText(String.valueOf(selectedProduct.getQuantity()));
	}
	}
	@FXML
	public void updateProduct() {
	if (selectedProduct != null) {
	selectedProduct.setName(nameField.getText());
	selectedProduct.setPrice(Double.parseDouble(priceField.getText()));
	selectedProduct.setQuantity(Integer.parseInt(quantityField.getText()));
	productTable.refresh(); // Cập nhật lại hiển thị TableView
	}
	
	
	}
	
	//--------------------
	
		@FXML
		public void deleteProduct() {
				Product selectedProduct =
				productTable.getSelectionModel().getSelectedItem();
				if (selectedProduct != null) {
				productList.remove(selectedProduct);
				}
		}
	
	
	
}
