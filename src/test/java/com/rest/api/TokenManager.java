package com.rest.api;

import com.rest.CommonHTTP;
import java.time.Instant;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;
   // static CommonHTTP common = new CommonHTTP();
    public synchronized static String getToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing token ...");
               // Response response = renewToken();
                //access_token = response.path("access_token");
              //  int expiryDurationInSeconds = response.path("expires_in");
               // expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            } else{
                System.out.println("Token is good to use");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;
    }

    //private static Response renewToken(){

       // Response response = common.getLoginResponseAndAccessToken();

      //  if(response.statusCode() != 200){
     //       throw new RuntimeException("ABORT!!! Renew Token failed");
     //   }
       // return response;
 //   }
}
