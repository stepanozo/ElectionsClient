package electionsClient.application;

import ElectionsClient.Configuration.SpringConfig;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.Service.CandidateClientService;
import ElectionsClient.Service.Http.UserHttpService;
import ElectionsClient.application.Elections;
import ElectionsClient.application.Waiter;
import ElectionsClient.frames.InfoFrame;
import ElectionsClient.frames.LogInFrame;
import ElectionsClient.model.ElectionsTime;
import electionsClient.Exceptions.HTTPException;
import electionsClient.Exceptions.NoCandidatesException;
import electionsClient.Exceptions.NoElectionsException;
import ElectionsClient.Service.HttpUtil;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.SwingUtilities;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "ElectionsClient")
public class Application implements CommandLineRunner {

    Thread waiterThread;
    
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
        
        UserClient.setService(context.getBean("userClientService", UserHttpService.class));
        
        SwingUtilities.invokeLater(() -> {
            LogInFrame frame = new LogInFrame();
            frame.setVisible(true);
            
            //Хорошо бы счётчик выборов вынести чисто в окно для голосования, но это мб позже.
            try{
                if(HttpUtil.electionsHaveRecords()){
                    
                    ElectionsTime electionsTime = HttpUtil.getLatestElectionsTime();
                    Elections.setTimeOfBegining(electionsTime.getDateTimeOfBegining());
                    Elections.setTimeOfEnding(electionsTime.getDateTimeOfEnding());
                    //Elections.setCandidates(HTTPUtil.getCandidates());

                    if(Elections.getDateTimeOfEnding().isAfter(LocalDateTime.now())){
                        //Теперь запустим ожидание конца выборов.
                        waiterThread = new Thread(Waiter.getInstance());
                        waiterThread.start();
                    }

                }
                //new LogInFrame().setVisible(true);
            } catch( HTTPException | NoElectionsException e){
                new InfoFrame(e.getMessage()).setVisible(true);
            }
        });
    }
}
