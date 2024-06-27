/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

import ElectionsClient.model.ElectionsTime;

/**
 *
 * @author чтепоноза
 */
public class MyJsonConverter {
    
    public static String electionsTimeToJson(ElectionsTime electionsTime){
        
        String beginTimeStr = electionsTime.getDateTimeOfBegining().toString().substring(0, 10) +
                "T"+electionsTime.getDateTimeOfBegining().toString().substring(11);
        
        String endTimeStr = electionsTime.getDateTimeOfEnding().toString().substring(0, 10) +
                "T"+electionsTime.getDateTimeOfEnding().toString().substring(11);
              
        String booleanStr = electionsTime.isEnded() ? "true" : "false";
        //Попробовать дату преобразовать в строку и добавить T в середину
        String body = "{" +
                "\"dateTimeOfBegining\": \"" + beginTimeStr + ":00\", " +
                "\"dateTimeOfEnding\": \"" + endTimeStr + ":00\", " +
                "\"ended\": " + booleanStr + " }";
        
        return body;
    }
    
//    public static ElectionsTime jstonToElectionsTime(String json){
//        
//        int firstQuoteIndex = json.indexOf('\"');
//        int secondQuoteIndex = json.indexOf('\"', firstQuoteIndex + 1);
//        int thirdQuoteIndex = json.indexOf('\"', firstQuoteIndex + 1);
//        int fourthQuoteIndex = json.indexOf('\"', firstQuoteIndex + 1);
//        String substringFromFirstQuote = json.substring(firstQuoteIndex, i);
//
//
//        int secondQuoteIndex = text.indexOf('\"', firstQuoteIndex + 1);
//        int thirdQuoteIndex = text.indexOf('\"', secondQuoteIndex + 1);
//        String substringFromThirdQuote = text.substring(thirdQuoteIndex);
//    }
}

//{
//    "dateTimeOfBegining": "2024-06-26T18:00:00",
//    "dateTimeOfEnding": "2024-06-26T18:40:00",
//    "ended": false
//}
