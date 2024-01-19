package ua.ithillel.jee.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://ws.jee.ithillel.ua")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloSoapService {
    @WebMethod // endpoint
    public String hello(@WebParam(name = "name") String name) {
        return String.format("Hello %s%n", name);
    }
}
