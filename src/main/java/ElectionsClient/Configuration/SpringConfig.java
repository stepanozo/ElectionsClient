/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Configuration;

import ElectionsClient.Service.CandidateClientService;
import ElectionsClient.Service.ElectionsTimeClientService;
import ElectionsClient.Service.Http.CandidateHttpService;
import ElectionsClient.Service.Http.ElectionsTimeHttpService;
import ElectionsClient.Service.Http.UserHttpService;
import ElectionsClient.Service.UserClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author чтепоноза
 */

@Configuration
@ComponentScan("ElectionsClient")
public class SpringConfig {
    
    @Scope("singleton")
    @Bean
    public CandidateClientService candidateClientService(){
        return new CandidateHttpService();
    }
    
    @Scope("singleton")
    @Bean
    public UserClientService userClientService(){
        return new UserHttpService();
    }
    
    @Scope("singleton")
    @Bean
    public ElectionsTimeClientService electionsTimeClientService(){
        return new ElectionsTimeHttpService();
    }
            
}
