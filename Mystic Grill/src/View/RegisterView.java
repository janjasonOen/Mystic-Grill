package View;

import Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterView {

    private Stage stage;
    private GridPane registerPane;
    private Label nameLabel, emailLabel , passwordLabel;
    private Text errorMessage;
    private TextField nameField, emailField;
    private PasswordField passwordField;
    private Button registerButton;

    public RegisterView() {
        this.stage = new Stage();
        createRegisterPane();
    }

    private void createRegisterPane() {
        registerPane = new GridPane();
        registerPane.setHgap(10);
        registerPane.setVgap(10);
        registerPane.setAlignment(Pos.CENTER);
        registerPane.setPadding(new Insets(20, 20, 20, 20));

        nameLabel = new Label("Name : ");
        nameField = new TextField();
        nameField.setPromptText("Insert name");
        emailLabel = new Label("Email : ");
        emailField = new TextField();
        emailField.setPromptText("Insert email");

        passwordLabel = new Label("Password : ");
        passwordField = new PasswordField();
        passwordField.setPromptText("Insert password");
        
        errorMessage = new Text();
        errorMessage.setStyle("-fx-fill: red;");

        registerButton = new Button("Register");

        registerPane.add(nameLabel, 0, 0);
        registerPane.add(nameField, 1, 0);
        registerPane.add(emailLabel, 0, 1);
        registerPane.add(emailField, 1, 1);
        registerPane.add(passwordLabel, 0, 2);
        registerPane.add(passwordField, 1, 2);
        registerPane.add(registerButton, 1, 3);
        registerButton.setOnAction(e -> handleRegister());
        registerPane.add(errorMessage, 1, 4);
    }

    private void handleRegister() {
    	 String name = nameField.getText();
    	    String email = emailField.getText();
    	    String password = passwordField.getText();

    	    // Validasi tambahan, jika diperlukan
    	    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
    	        // Tampilkan pesan kesalahan atau lakukan penanganan sesuai kebutuhan
    	        errorMessage.setText("Semua field harus diisi.");
    	        return;
    	    }

    	    // Buat instance User
    	    User newUser = new User();

    	    // Insert user dengan userRole default "customer"
    	    newUser.registerUser(name, email, password);

    	    // Tampilkan pesan sukses atau navigasi ke halaman berikutnya jika diperlukan
    	    errorMessage.setText("Registrasi berhasil!");
    }

    public void show() {
        Scene registerScene = new Scene(registerPane, 400, 300);
        stage.setScene(registerScene);
        stage.setTitle("Register - Mystic Grill");
        stage.show();
    }
}
