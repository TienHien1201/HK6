package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleController {

    @FXML
    private TableView<SanPham> tableView;
    @FXML
    private TableColumn<SanPham, Integer> colId;
    @FXML
    private TableColumn<SanPham, String> colTen;
    @FXML
    private TableColumn<SanPham, Double> colGia;
    @FXML
    private TableColumn<SanPham, Date> colNgayTao;

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;

    @FXML
    private AnchorPane goOders;

    @FXML
    private TextField textName;
    @FXML
    private TextField textPrice;
    @FXML
    private TextField textStt;
    @FXML
    private TextField textDate;
    @FXML
    public void initialize() {
        // Set up the columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
        colGia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        colNgayTao.setCellValueFactory(new PropertyValueFactory<>("ngayTao"));

        // Load data into the table
        ObservableList<SanPham> list = getSanPhamList();
        tableView.setItems(list);

        // Add event for table row selection
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { // Single click
            	textStt.setDisable(true); // Vô hiệu hóa hoàn toàn, không cho phép chỉnh sửa và tương tác

                SanPham selectedProduct = tableView.getSelectionModel().getSelectedItem();
                if (selectedProduct != null) {
                    populateFields(selectedProduct);
                }
            }
        });
        textPrice.textProperty().addListener((observable, oldValue, newValue) -> {
         
            if (!newValue.matches("\\d*\\.?\\d*")) { 
                textPrice.setText(oldValue); 
            }
        });
    }

    public ObservableList<SanPham> getSanPhamList() {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM sanPham";
        try (Connection conn = DataConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                list.add(new SanPham(
                    rs.getInt("id"),
                    rs.getString("ten"),
                    rs.getDouble("gia"),
                    rs.getDate("ngayTao")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void populateFields(SanPham sanPham) {
        textName.setText(sanPham.getTen());
        textPrice.setText(String.valueOf(sanPham.getGia()));
        textStt.setText(String.valueOf(sanPham.getId())); // Convert int to String
        textDate.setText(sanPham.getNgayTao().toString()); // Convert Date to String
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void AddClick(MouseEvent event) {
        String name = textName.getText();
        String priceText = textPrice.getText();
        if (name.isEmpty() || priceText.isEmpty()) {
            showAlert("Warning", "Please fill in all fields.");
            return;
        }

        double price = Double.parseDouble(priceText);
        if (price == 0) {
            showAlert("Warning","The product price must not be equal to 0.");
            return; // Dừng thực hiện nếu giá không hợp lệ
        }
        String query = "INSERT INTO sanPham (ten, gia) VALUES (?, ?)";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            showAlert("Success", "Product added successfully.");
            tableView.setItems(getSanPhamList());
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while adding the product.");
        }
    }

    @FXML
    void ClearClick(MouseEvent event) {
        textName.clear();
        textPrice.clear();
        textStt.clear();
        textDate.clear();
        textStt.setDisable(false); // Vô hiệu hóa hoàn toàn, không cho phép chỉnh sửa và tương tác

        tableView.getSelectionModel().clearSelection();
    }
    @FXML
    void tableclick() {}

    @FXML
    void deleteClick(MouseEvent event) {
        SanPham selectedProduct = tableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            String query = "DELETE FROM sanPham WHERE id = ?";
            try (Connection conn = DataConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, selectedProduct.getId());
                pstmt.executeUpdate();
                showAlert("Success", "Product deleted successfully.");
                tableView.setItems(getSanPhamList()); // Refresh the table
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "An error occurred while deleting the product.");
            }
        } else {
            showAlert("Warning", "Please select a product to delete.");
        }
    }

    @FXML
    void editClick(MouseEvent event) {
        SanPham selectedProduct = tableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            String name = textName.getText();
            String priceText = textPrice.getText();
            if (name.isEmpty() || priceText.isEmpty()) {
                showAlert("Warning", "Please fill in all fields.");
                return;
            }

            double price = Double.parseDouble(priceText);
            String query = "UPDATE sanPham SET ten = ?, gia = ? WHERE id = ?";
            try (Connection conn = DataConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setDouble(2, price);
                pstmt.setInt(3, selectedProduct.getId());
                pstmt.executeUpdate();
                showAlert("Success", "Product updated successfully.");
                tableView.setItems(getSanPhamList()); // Refresh the table
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "An error occurred while updating the product.");
            }
        } else {
            showAlert("Warning", "Please select a product to edit.");
        }
    }


}
