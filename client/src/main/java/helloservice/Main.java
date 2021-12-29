package helloservice;

import java.net.URL;

import javax.xml.ws.BindingProvider;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void call() throws Exception {
        HelloService service = new HelloService(new URL("http://localhost:9080/soap-example-server/HelloService"));
        HelloServicePort port = service.getPort();
        BindingProvider p = (BindingProvider)port;
        //p.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9080/soap-example-server/HelloService");
        p.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 3*1000);
        
        p.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 3*1000);
        p.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 3*1000);
        p.getRequestContext().put("com.sun.xml.ws.request.timeout", 3*1000);
        
        
        String result = port.sayHello("myname");
        System.out.println(result);
    }
}
