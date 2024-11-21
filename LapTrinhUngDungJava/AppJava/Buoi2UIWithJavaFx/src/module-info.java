module Buoi2UIWithJavaFx {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
