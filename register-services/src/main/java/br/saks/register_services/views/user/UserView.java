package br.saks.register_services.views.user;

import br.saks.register_services.Entities.User;
import br.saks.register_services.securities.SessionContext;
import br.saks.register_services.utils.TokenUtil;
import br.saks.register_services.viewmodels.UserViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/fxml/UserView.fxml")
public class UserView {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserViewModel viewModel;

    private Stage stage;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label telefoneLabel;

    @FXML
    private Label cpfLabel;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {

        log.info("User dashboard loaded");

        try {

            loadUserData();

        } catch (Exception e) {

            log.error("Error loading user dashboard", e);

        }
    }

    private void loadUserData() {

        String token = SessionContext.getToken();

        Long userId = tokenUtil.getUserId(token);

        log.info("Loading user data: id={}", userId);

        User user = viewModel.getById(userId);

        nomeLabel.setText(user.getName());
        emailLabel.setText(user.getEmail());
        telefoneLabel.setText(user.getTelephone());
        cpfLabel.setText(user.getCpf());

    }
}