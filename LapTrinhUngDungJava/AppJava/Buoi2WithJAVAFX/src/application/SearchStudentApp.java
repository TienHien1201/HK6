package application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchStudentApp extends Application {

    private TableView<Student> tableView;
    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) {
        Label searchLabel = new Label("Tìm kiếm theo tên:");
        TextField searchField = new TextField();
        Button searchButton = new Button("Tìm kiếm");

        tableView = new TableView<>();
        TableColumn<Student, String> nameColumn = new TableColumn<>("Tên");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Tuổi");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.getColumns().addAll(nameColumn, ageColumn);

        students = FXCollections.observableArrayList(
            new Student("Nguyễn Văn A", 20),
            new Student("Trần Thị B", 22),
            new Student("Lê Văn C", 21)
        );

        tableView.setItems(students);

        searchButton.setOnAction(e -> {
            String searchName = searchField.getText().toLowerCase();
            ObservableList<Student> filteredStudents = FXCollections.observableArrayList();
            for (Student student : students) {
                if (student.getName().toLowerCase().contains(searchName)) {
                    filteredStudents.add(student);
                }
            }
            tableView.setItems(filteredStudents);
        });

        VBox layout = new VBox(10, searchLabel, searchField, searchButton, tableView);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tìm kiếm sinh viên");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Student {
        private final String name;
        private final int age;

       public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}