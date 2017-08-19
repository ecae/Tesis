package clasem.controllers;

import clasem.services.CalendarService;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalendarController {

    private CalendarService calendarService;

    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public List<ListCalendarWrapper> listCalendar() {
        return calendarService.listAllCalendar();
    }
}
