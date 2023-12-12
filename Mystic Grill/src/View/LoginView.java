package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class LoginView extends Application{
	
	Scene scene;
	BorderPane borderPane;
	Text welcomeText, errorMessage;
	Label emailLabel, passwordLabel;
	TextField emailField;
	PasswordField passwordField;
	Button loginButton, registerButton;
	VBox centerVBox;
	GridPane gridPane;
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Login - Mystic Grill");
		
		 borderPane = new BorderPane();
	     borderPane.setPadding(new Insets(20, 20, 20, 20));

	     welcomeText = new Text("Welcome to Mystic Grill");
	     welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	     BorderPane.setAlignment(welcomeText, Pos.TOP_CENTER);
	     borderPane.setTop(welcomeText);
	     

	       
	    emailLabel = new Label("Email : ");
		emailField = new TextField();
		emailField.setPromptText("Email");
		
		passwordLabel = new Label("Password : ");
		passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		
		loginButton = new Button("Login");
		loginButton.setOnAction(e -> handleLogin(emailField.getText(), passwordField.getText()));
		errorMessage = new Text();
        errorMessage.setStyle("-fx-fill: red;");

        registerButton = new Button("Register");
        registerButton.setOnAction(e -> handleRegister());
		
        centerVBox = new VBox(10);
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Baris 1

        emailField.setPromptText("Enter your email");
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);

        // Baris 2

        passwordField.setPromptText("Enter your password");
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        // Baris 3
        gridPane.add(loginButton, 1, 3);
        gridPane.add(errorMessage, 1, 2);

        // Baris 4
        gridPane.add(registerButton, 1, 4);

        borderPane.setCenter(gridPane);

        scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	
	 private void handleLogin(String email, String password) {
	        // Implementasi logika login di sini
	        // Contoh sederhana validasi
	        if (email.isEmpty() || password.isEmpty()) {
	            errorMessage.setText("Email dan password harus diisi.");
	        } else {
	            // Lakukan autentikasi atau navigasi ke halaman beranda
	            errorMessage.setText("");
	        }
	    }

	 private void handleRegister() {

			    RegisterView registerView = new RegisterView();
			    registerView.show();
			}
	    
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
