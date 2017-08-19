package clasem.services;

import clasem.entities.core.Maintenance;
import clasem.wrappers.Calendar.ListCalendarWrapper;

import java.util.List;

public interface CalendarService {
    List<ListCalendarWrapper> listAllCalendar();
    List<ListCalendarWrapper> listAllCalendarOperator(long id_user);
    void addCalendar(Maintenance maintenance);
    void updateCalendar(Maintenance maintenance);
    void deleteCalendar(int id_maintenance);
}
