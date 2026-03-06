package br.saks.register_services.views.adm;

import br.saks.register_services.Entities.User;
import br.saks.register_services.dtos.UpdateDTO;
import br.saks.register_services.securities.SessionContext;
import br.saks.register_services.utils.TokenUtil;
import br.saks.register_services.viewmodels.AdminViewModel;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/fxml/AdmEditView.fxml")
public class AdmEditView {

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    private AdminViewModel viewModel;

    @Autowired
    private TokenUtil tokenUtil;

    private Stage stage;
    private User user;
    private boolean adminEditing;
    private AdminView parentView;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField cpfField;

    @FXML
    private ComboBox<String> roleCombo;

    @FXML
    private Label errorLabel;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAdminEditing(boolean adminEditing) {
        this.adminEditing = adminEditing;
    }

    public void setParentView(AdminView parentView) {
        this.parentView = parentView;
    }

    @FXML
    public void initialize() {

        log.info("Edit view initialized");

        errorLabel.setText("");

        roleCombo.getItems().addAll(
                "ADMIN",
                "USER"
        );
        configureScreen();
        populateFields();
    }

    private void configureScreen() {

        if (adminEditing) {

            titleLabel.setText("Edit My Data");
            roleCombo.setDisable(true);

        } else {

            titleLabel.setText("Edit User");
            roleCombo.setDisable(false);

        }
    }

    private void populateFields() {

        if (user == null || nameField == null) {
            return;
        }

        nameField.setText(user.getName());
        emailField.setText(user.getEmail());
        phoneField.setText(user.getTelephone());
        cpfField.setText(user.getCpf());

        if (user.getRole() != null) {
            roleCombo.setValue(user.getRole().getDescription());
        }
    }

    @FXML
    private void handleSave() {

        try {

            var userDTO = UpdateDTO.builder()
                .name(nameField.getText())
                .email(emailField.getText())
                .telephone(phoneField.getText())
                .cpf(cpfField.getText())
                .build();

            String token = SessionContext.getToken();
            Long id = tokenUtil.getUserId(token);

            viewModel.updateUser(userDTO, id);
            log.info("User updated: {}", userDTO.email());

            showAlert(
                    "Success",
                    "User updated successfully",
                    Alert.AlertType.INFORMATION
            );

            goBack();

        } catch (Exception e) {

            log.error("Error updating user", e);

            errorLabel.setText("Error saving user");
        }
    }

    @FXML
    private void handleCancel() {
        goBack();
    }

    private void goBack() {

        try {

            Parent root = fxWeaver.loadView(AdminView.class);

            AdminView controller = fxWeaver.getBean(AdminView.class);
            controller.setStage(stage);

            /*
             * TODO
             * Atualizar tabela após edição
             */
            if (parentView != null) {
                parentView.refreshData();
            }

            stage.setScene(new Scene(root, 800, 600));
            stage.centerOnScreen();

        } catch (Exception e) {

            log.error("Error returning to admin screen", e);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}