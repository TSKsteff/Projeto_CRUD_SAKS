package br.saks.register_services.views.auth;

import br.saks.register_services.dtos.CreateUserDTO;
import br.saks.register_services.dtos.LoginUserDTO;
import br.saks.register_services.enums.RoleEnum;
import br.saks.register_services.securities.SessionContext;
import br.saks.register_services.utils.TokenUtil;
import br.saks.register_services.viewmodels.AuthViewModel;
import br.saks.register_services.views.MainWindow;
import br.saks.register_services.views.adm.AdminView;
import br.saks.register_services.views.user.UserView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/fxml/AuthView.fxml")
public class AuthView {

    private static final Logger log = LoggerFactory.getLogger(AuthView.class);

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    private AuthViewModel viewModel;

    @Autowired
    private TokenUtil tokenUtil;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField cpfField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label telefoneLabel;

    @FXML
    private Label cpfLabel;

    @FXML
    private Button confirmarButton;

    @FXML
    private ToggleGroup modeGroup;

    @FXML
    private RadioButton loginRadio;

    @FXML
    private RadioButton cadastroRadio;

    private String userType;

    private Stage stage;

    public void setUserType(String userType) {
        log.info("User type configured: {}", userType);
        this.userType = userType;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {
        log.info("Authentication screen loaded");
        errorLabel.setText("");

        modeGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                onModeChange(newToggle);
            }
        });

        hideRegisterFields();
    }

    private void hideRegisterFields() {

        nomeField.setVisible(false);
        nomeField.setManaged(false);
        nomeLabel.setVisible(false);
        nomeLabel.setManaged(false);

        telefoneField.setVisible(false);
        telefoneField.setManaged(false);
        telefoneLabel.setVisible(false);
        telefoneLabel.setManaged(false);

        cpfField.setVisible(false);
        cpfField.setManaged(false);
        cpfLabel.setVisible(false);
        cpfLabel.setManaged(false);
    }

    private void showRegisterFields() {

        nomeField.setVisible(true);
        nomeField.setManaged(true);
        nomeLabel.setVisible(true);
        nomeLabel.setManaged(true);

        telefoneField.setVisible(true);
        telefoneField.setManaged(true);
        telefoneLabel.setVisible(true);
        telefoneLabel.setManaged(true);

        cpfField.setVisible(true);
        cpfField.setManaged(true);
        cpfLabel.setVisible(true);
        cpfLabel.setManaged(true);
    }

    private void onModeChange(Toggle toggle) {

        if (toggle == loginRadio) {
            log.info("Login mode selected");
            hideRegisterFields();
            confirmarButton.setText("Login");
        }

        if (toggle == cadastroRadio) {
            log.info("Register mode selected");
            showRegisterFields();
            confirmarButton.setText("Register");
        }
    }

    @FXML
    public void handleSubmit(ActionEvent event){

        String email = emailField.getText();
        String password = passwordField.getText();

        Toggle selected = modeGroup.getSelectedToggle();

        if (email == null || email.isBlank()) {
            errorLabel.setText("Email is required");
            return;
        }

        if (password == null || password.length() < 6) {
            errorLabel.setText("Password must have at least 6 characters");
            return;
        }

        if (selected == cadastroRadio) {

            String name = nomeField.getText();
            String phone = telefoneField.getText();
            String cpf = cpfField.getText();

            if (name == null || name.isBlank()) {
                errorLabel.setText("Name is required");
                return;
            }

            if (phone == null || phone.isBlank()) {
                errorLabel.setText("Phone is required");
                return;
            }

            if (cpf == null || cpf.isBlank()) {
                errorLabel.setText("CPF is required");
                return;
            }

            CreateUserDTO dto = CreateUserDTO.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .telephone(phone)
                    .cpf(cpf)
                    .role("ADMIN".equals(userType) ? RoleEnum.ADM : RoleEnum.USER)
                    .active(true)
                    .build();

            viewModel.register(dto);

            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("User registered successfully");

            clearForm();
        }

        else {

            LoginUserDTO dto = LoginUserDTO.builder()
                    .email(email)
                    .password(password)
                    .build();

            try {

                viewModel.login(dto);
                navigateToMainScreen(event);
            } catch (Exception e) {

                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Invalid email or password");

            }
        }
    }

    private void clearForm() {

        emailField.clear();
        passwordField.clear();
        nomeField.clear();
        telefoneField.clear();
        cpfField.clear();

        modeGroup.selectToggle(null);
    }

    @FXML
    private void handleBack(ActionEvent event) {

        log.info("Returning to main window");

        try {

           Stage stage = (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

           Parent root = fxWeaver.loadView(MainWindow.class);


           stage.setScene(new Scene(root, 800, 600));
           stage.setTitle("Register System");
           stage.centerOnScreen();

        } catch (Exception e) {

            log.error("Error returning to main window", e);
            errorLabel.setText("Navigation error");

        }
    }

    private void navigateToMainScreen(ActionEvent event) {

        String token = SessionContext.getToken();
        Jwt jwt = tokenUtil.decode(token);
        String role = jwt.getClaim("role");

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        if ("ADM".equals(role)) {

            log.info("Navigating to Admin screen");

            Parent root = fxWeaver.loadView(AdminView.class);
            AdminView controller = fxWeaver.getBean(AdminView.class);
            controller.setStage(stage);

            stage.setScene(new Scene(root, 800, 600));
            stage.centerOnScreen();

        } else {

            log.info("Navigating to User screen");

            Parent root = fxWeaver.loadView(UserView.class);
            UserView controller = fxWeaver.getBean(UserView.class);
            controller.setStage(stage);

            stage.setScene(new Scene(root, 800, 600));
            stage.centerOnScreen();
        }
    }
}