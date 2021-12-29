package helloservice;

import javax.jws.WebService;

@WebService(endpointInterface="helloservice.HelloServicePortType", targetNamespace="http://helloservice/", serviceName="HelloService", portName="HelloServicePort")
public class HelloServicePortBindingImpl {
    public String helloWorld() {
        return "hello";
    }

    public String sayHello(String name) {
        // try {
        //     Thread.sleep(10 * 1000L);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "hello, " + name;
    }
}
