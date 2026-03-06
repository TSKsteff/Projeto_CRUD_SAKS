package br.saks.register_services.views.adm;

import br.saks.register_services.Entities.User;
import br.saks.register_services.securities.SessionContext;
import br.saks.register_services.utils.TokenUtil;
import br.saks.register_services.viewmodels.AdminViewModel;
import br.saks.register_services.views.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@FxmlView("/fxml/AdminView.fxml")
public class AdminView {

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    private AdminViewModel viewModel;

    @Autowired
    private TokenUtil tokenUtil;

    private Stage stage;
    private User currentAdmin;

    @FXML
    private Label nomeAdminLabel;

    @FXML
    private Label emailAdminLabel;

    @FXML
    private Label telephoneAdminLabel;

    @FXML
    private Label cpfAdminLabel;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> nomeColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> telefoneColumn;

    @FXML
    private TableColumn<User, String> cpfColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TableColumn<User, Void> acesColumn;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        log.info("Admin dashboard initialized");

        configureTable();
        configureActionButtons();
        loadData();
    }

    private void configureTable() {

        nomeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        emailColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getEmail()));

        telefoneColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getTelephone()));

        cpfColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCpf()));

        roleColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getRole().getDescription()));
    }

    private void configureActionButtons() {

        acesColumn.setCellFactory(param -> new TableCell<>() {

            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");
            private final HBox pane = new HBox(5, editButton, deleteButton);

            {
                pane.setStyle("-fx-alignment: CENTER;");

                editButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    openEditScreen(user, false);
                });

                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    deleteUser(user);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : pane);
            }
        });
    }

    private void loadData() {

        try {

            String token = SessionContext.getToken();
            Long adminId = tokenUtil.getUserId(token);

            log.info("Loading admin data id={}", adminId);

            currentAdmin = viewModel.getById(adminId);

            nomeAdminLabel.setText(currentAdmin.getName());
            emailAdminLabel.setText(currentAdmin.getEmail());
            telephoneAdminLabel.setText(currentAdmin.getTelephone());
            cpfAdminLabel.setText(currentAdmin.getCpf());

            List<User> users = viewModel.getALL();

            userTable.setItems(FXCollections.observableArrayList(users));

            log.info("Users loaded successfully. Count={}", users.size());

        } catch (Exception e) {

            log.error("Error loading admin data", e);
            showAlert("Error", "Could not load data", Alert.AlertType.ERROR);

        }
    }

    @FXML
    private void handleEditMyData() {

        log.info("Opening admin self edit screen");

        openEditScreen(currentAdmin, true);
    }

    private void deleteUser(User user) {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Delete User");
        confirmation.setHeaderText("User deletion");
        confirmation.setContentText("Confirm delete user: " + user.getName());

        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            try {

                viewModel.delete(user.getId());

                userTable.getItems().remove(user);

                log.info("User deleted {}", user.getEmail());

                showAlert("Success", "User deleted successfully", Alert.AlertType.INFORMATION);

            } catch (Exception e) {

                log.error("Error deleting user", e);

                showAlert("Error", "Could not delete user", Alert.AlertType.ERROR);

            }
        }
    }

    private void openEditScreen(User user, boolean adminEdit) {

        try {

            Parent root = fxWeaver.loadView(AdmEditView.class);
            AdmEditView controller = fxWeaver.getBean(AdmEditView.class);

            controller.setUser(user);
            controller.setAdminEditing(adminEdit);
            controller.setStage(stage);
            controller.setParentView(this);

            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("User Edit");
            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {

            log.error("Error opening edit screen", e);

            showAlert("Error", "Could not open edit screen", Alert.AlertType.ERROR);

        }
    }

    @FXML
    private void handleLogout() {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Logout");
        confirmation.setHeaderText("Exit system");
        confirmation.setContentText("Do you want to logout?");

        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            try {

                SessionContext.clear();

                Parent root = fxWeaver.loadView(MainWindow.class);

                stage.setScene(new Scene(root, 800, 600));
                stage.setTitle("Register System");
                stage.centerOnScreen();

                log.info("User logged out");

            } catch (Exception e) {

                log.error("Error during logout", e);

            }
        }
    }

    public void refreshData() {
        loadData();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }
}