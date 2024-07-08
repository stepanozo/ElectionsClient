package electionsClient.application;

import ElectionsClient.Configuration.SpringConfig;
import ElectionsClient.EntityClient.CandidateClient;
import ElectionsClient.EntityClient.ElectionsTimeClient;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.Service.Http.CandidateHttpService;
import ElectionsClient.Service.Http.ElectionsTimeHttpService;
import ElectionsClient.Service.Http.UserHttpService;
import ElectionsClient.application.Elections;
import ElectionsClient.application.Waiter;
import ElectionsClient.frames.InfoFrame;
import ElectionsClient.frames.LogInFrame;
import ElectionsClient.model.ElectionsTime;
import electionsClient.Exceptions.NoElectionsException;
import java.time.LocalDateTime;
import javax.swing.SwingUtilities;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "ElectionsClient")
public class Application implements CommandLineRunner {
    
    public static void main(String[] args) {
        ApplicationContext contexto = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.SERVLET)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
        
        //Зависимости
        UserClient.setService(context.getBean("userClientService", UserHttpService.class));
        CandidateClient.setService(context.getBean("candidateClientService", CandidateHttpService.class));
        ElectionsTimeClient.setService(context.getBean("electionsTimeClientService", ElectionsTimeHttpService.class));
        
        SwingUtilities.invokeLater(() -> {
            LogInFrame frame = new LogInFrame();
            frame.setVisible(true);
        });
    }
}
