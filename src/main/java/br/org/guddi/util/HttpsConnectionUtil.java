package br.org.guddi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpsConnectionUtil {

  public HttpsURLConnection connectHttps(String host, String port) {

    TrustManager[] trustAllCerts = new TrustManager[] { 
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                  return null;
                }
          
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
          
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
           } 
       };

    try {
      SSLContext sc = SSLContext.getInstance("TLS");
      sc.init(null, trustAllCerts, new java.security.SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (Exception e) {
    }

    try {

      HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
        public boolean verify(String string, SSLSession ssls) {
          return true;
        }
      });

      URL url = new URL(host + ":"+port);

      HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
      /*
      InputStream in = urlConnection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String input;
 
      while ((input = br.readLine()) != null) {
        System.out.println(input);
      }
 */
      
      return urlConnection;
      
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

  }

}
