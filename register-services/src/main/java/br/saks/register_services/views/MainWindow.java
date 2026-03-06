package br.saks.register_services.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.saks.register_services.views.auth.AuthView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/MainWindow.fxml")
public class MainWindow {

    private static final Logger log = LoggerFactory.getLogger(MainWindow.class);

    @Autowired
    private FxWeaver fxWeaver;
    
    private Stage stage;
    
    @FXML
    private Button admButton;

    @FXML
    private Button funcionarioButton;

    public void setStage(Stage stage) { 
        this.stage = stage; 
    }
    
    @FXML
    public void initialize() {
        log.info("Home screen loaded");
    }

    @FXML
    private void handleAdm() {
        log.info("User he chose ADM");
        openAuth("ADMIN");
    }

    @FXML
    private void handleEmployee() {
        log.info("User he chose employee");
        openAuth("User");
    }
    
    private void openAuth(String tipo) {
        try {
            Parent root = fxWeaver.loadView(AuthView.class);

            AuthView controller = fxWeaver.getBean(AuthView.class);
            controller.setUserType(tipo);
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Autenticação - " + tipo);
            stage.centerOnScreen();
            
            log.info("Navigating to the authentication screen as: {}", tipo);
        } catch (Exception e) {
            log.error("Error opening authentication screen", e);
        }
    }
}