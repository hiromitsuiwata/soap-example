package helloservice;

import javax.jws.WebService;

@WebService(endpointInterface="helloservice.HelloServicePortType", targetNamespace="http://helloservice/", serviceName="HelloService", portName="HelloServicePort")
public class HelloServicePortBindingImpl {
    public String helloWorld() {

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "hello";
    }
}
