package managerbean;

import webservice.TimeService;
import webservice.TimeServiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

@ManagedBean (name = "showTime")
@ViewScoped
public class ShowTime implements Serializable {

    private XMLGregorianCalendar date;

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }

    @PostConstruct
    public void init() {
        TimeService service = new TimeServiceService().getTimeServicePort();
        date = service.getDate();
    }

}
