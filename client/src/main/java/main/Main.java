package main;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helloservice.HelloService;
import helloservice.HelloServicePort;

public class Main {

    private Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String call() throws MalformedURLException {
        
        logger.info("start...");
        try {
            HelloService service = new HelloService(new URL("http://localhost:9080/soap-example-server/HelloService?wsdl"));
            HelloServicePort port = service.getPort();
            BindingProvider p = (BindingProvider)port;
            p.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9080/soap-example-server/HelloService");
            p.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 3*1000);
            p.getRequestContext().put("com.sun.xml.ws.connect.timeout", 3*1000);
            p.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 3*1000);
            
            // mainメソッドから呼び出す場合に必要
            //p.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 3*1000);
            // 不要?
            //p.getRequestContext().put("com.sun.xml.ws.request.timeout", 3*1000);
            // Libertyのランタイムの中から呼び出す場合に必要 
            //p.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 3*1000);
            String result = port.helloWorld();
            System.out.println(result);
            logger.info("end");
            return result;
        } catch (Throwable e) {
            logger.error("exception", e);
            return "ERROR";
        }
    }
}
