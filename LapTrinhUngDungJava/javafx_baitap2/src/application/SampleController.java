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
	private TextField nameField, ageField, idField;
	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> nameColumn;
	@FXML
	private TableColumn<Student, Integer> ageColumn;
	@FXML
	private TableColumn<Student, String> idColumn;
	private ObservableList<Student> studentList =
	FXCollections.observableArrayList();
	@FXML
	public void initialize() {
	nameColumn.setCellValueFactory(new
	PropertyValueFactory<>("name"));
	ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
	idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	studentTable.setItems(studentList);
	
	Student newStudent = new Student("Nguyễn Văn A", 18, "221403001");
	studentList.add(newStudent);
	
	newStudent = new Student("Trần Văn Banh", 19, "221403002");
	studentList.add(newStudent);
	
	
	newStudent = new Student("Nguyễn Thị Diệu", 20, "221403003");
	studentList.add(newStudent);
	}
	@FXML
	public void addStudent() {
	String name = nameField.getText();
	int age = Integer.parseInt(ageField.getText());
	String id = idField.getText();
	Student newStudent = new Student(name, age, id);
	studentList.add(newStudent);
	nameField.clear();
	ageField.clear();
	idField.clear();
	}
	
	
}
