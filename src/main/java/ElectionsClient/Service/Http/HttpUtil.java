/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service.Http;

import java.net.http.HttpClient;
import lombok.Getter;

/**
 *
 * @author чтепоноза
 */
public class HttpUtil {
      
    @Getter
    static HttpClient client = HttpClient.newHttpClient();
    
    @Getter
    static String serverUrl = "http://localhost:8080"; 
}
