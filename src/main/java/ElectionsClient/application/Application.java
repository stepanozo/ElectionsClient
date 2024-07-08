package electionsClient.application;

import ElectionsClient.Configuration.SpringConfig;
import ElectionsClient.EntityClient.CandidateClient;
import ElectionsClient.EntityClient.ElectionsTimeClient;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.Service.Http.CandidateHttpService;
import ElectionsClient.Service.Http.ElectionsTimeHttpService;
import ElectionsClient.Service.Http.UserHttpService;
import ElectionsClient.frames.LogInFrame;
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
