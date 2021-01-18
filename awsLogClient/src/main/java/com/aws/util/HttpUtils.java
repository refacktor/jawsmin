package com.aws.util;

import java.io.IOException;
import java.util.Map;
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
    public static HttpPost createRequest(String url,String host,String key,String secret
    		,String region,String service,String methode,String canonical,String action) {
        
    	
    	
        /**
         * Add host without http or https protocol.
         * You can also add other parameters based on your amazon service requirement.
         */
        TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
        awsHeaders.put("host", host);
        awsHeaders.put("Accept", "application/json");
        awsHeaders.put("Content-Type", "application/x-amz-json-1.1");
       TreeMap<String, String> queryParam =null;
       queryParam = new TreeMap<String, String>();
        queryParam.put("Action", action);

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