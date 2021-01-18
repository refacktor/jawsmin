package com.aws.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.aws.logs.AWSV4Auth;
import com.google.gson.Gson;

public class HttpUtils {
	
	public static Log logger = LogFactory.getLog(HttpUtils.class);
	
	  private static String getTimeStamp() {
	        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
	        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));//server timezone
	        return dateFormat.format(new Date());
	    }
    public static HttpPost createRequest(String url,String host,String key,String secret
    		,String region,String service,String methode,String canonical,String action,Object payload) {
        
    	
    	
        /**
         * Add host without http or https protocol.
         * You can also add other parameters based on your amazon service requirement.
         */
    	
        TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
        awsHeaders.put("content-type", "application/json");
        awsHeaders.put("host", host);       
        awsHeaders.put("x-amz-date", getTimeStamp());       
   
       TreeMap<String, String> queryParam =null;
       queryParam = new TreeMap<String, String>();
        queryParam.put("Action", action);
 queryParam.put("Version", "2012-10-17");


        AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder(key, secret)
                                           .regionName(region)
                                           .serviceName(service) // es - elastic search. use your service name
                                           .httpMethodName(methode) //GET, PUT, POST, DELETE, etc...
                                           .canonicalURI(canonical) //end point
                                           .queryParametes(queryParam) //query parameters if any
                                           .awsHeaders(awsHeaders) //aws header parameters
                                           .payload(null) // payload if any
                                           .debug() // turn on the debug mode
                                           .build();
        aWSV4Auth.getHeaders();
        System.out.println("######################################################################");
        /* Get header calculated for request */
        Map<String, String> header = new TreeMap<String, String>(aWSV4Auth.getHeaders());

        HttpPost httpPost = new HttpPost(url);

        for (Map.Entry<String, String> entrySet : header.entrySet()) {
            String headerkey = entrySet.getKey();
            String value = entrySet.getValue();
            
            /* Attach header in your request */
            /* Simple get request */
            httpPost.addHeader(headerkey, value);
        }
       return httpPost;
    }
    
    public static<T,S> S executeRequest(HttpPost request,T user,Class<S> s) {
	    CloseableHttpClient client = HttpClients.custom().build();

         try {
        	 Gson gson = new Gson();

        	 String json = gson.toJson(user);

           

        	    request.setEntity(new StringEntity(json));

               
             //Send the request; It will immediately return the response in HttpResponse object if any
             HttpResponse response = client.execute(request);
              
             //verify the valid error code first
             int statusCode = response.getStatusLine().getStatusCode();
             String stringResult = IOUtils.toString(response.getEntity().getContent());

             if (statusCode != 200) 
             {
            	 logger.error("Error Code :" + stringResult);
                 throw new RuntimeException("Failed with HTTP error code : " + statusCode);
             }else {
            	 System.out.println("Success Call to the Action. Status 200 "+stringResult);
             }
            
            
             S result = gson.fromJson(stringResult, s);

             return result;
         } catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        
         finally
         {
             //Important: Close the connect
             client.getConnectionManager().shutdown();
             return null;
         }
    }
}