package br.saks.register_services.listerners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.saks.register_services.events.StageReadyEvent;
import br.saks.register_services.views.MainWindow;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;

@Slf4j
@Component
public class StageReadyEventListener implements ApplicationListener<StageReadyEvent> {

	@Value("${spring.application.ui.title}")
    private String applicationTitle;
    
    @Autowired
    private FxWeaver fxWeaver; 
    
    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        Stage stage = event.getStage();

        Parent parent = fxWeaver.loadView(MainWindow.class);
        MainWindow mainWindow = fxWeaver.loadController(MainWindow.class);
        mainWindow.setStage(stage);

        var scene = new Scene(parent, 800, 600);
        stage.setScene(scene);
        stage.setTitle(applicationTitle);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
}