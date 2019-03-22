
package webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TimeService", targetNamespace = "http://timeservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TimeService {


    /**
     * 
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDate", targetNamespace = "http://timeservice/", className = "webservice.GetDate")
    @ResponseWrapper(localName = "getDateResponse", targetNamespace = "http://timeservice/", className = "webservice.GetDateResponse")
    @Action(input = "http://timeservice/TimeService/getDateRequest", output = "http://timeservice/TimeService/getDateResponse")
    public XMLGregorianCalendar getDate();

}