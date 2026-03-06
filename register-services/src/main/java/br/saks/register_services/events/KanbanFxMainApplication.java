package br.saks.register_services.events;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.saks.register_services.RegisterServicesApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class KanbanFxMainApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    
    @Override
    public void start(Stage stage) throws Exception {
       applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void init() {
      applicationContext =
          new SpringApplicationBuilder(RegisterServicesApplication.class)
              .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() {
      applicationContext.close();
      Platform.exit();
    }

    
}
