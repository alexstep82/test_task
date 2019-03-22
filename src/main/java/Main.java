import webservice.TimeService;
import webservice.TimeServiceService;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

public class Main {

    public static void main(String[] args) throws JAXBException {
        TimeService service = new TimeServiceService().getTimeServicePort();
        XMLGregorianCalendar date = service.getDate();
        System.out.println(date);
    }
}
