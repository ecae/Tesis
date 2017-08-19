package clasem.converter;

import clasem.entities.core.Calendar;
import clasem.entities.core.Maintenance;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import org.springframework.stereotype.Component;

@Component
public class CalendarConverter {

    public ListCalendarWrapper calendar2ListCalendarWrapper(Calendar calendar) {
        ListCalendarWrapper listCalendarWrapper = new ListCalendarWrapper();
        listCalendarWrapper.setId(calendar.getId());
        listCalendarWrapper.setTitle(calendar.getTitle());
        listCalendarWrapper.setDescription(calendar.getDescription());
        listCalendarWrapper.setStart(calendar.getStart().toString());
        listCalendarWrapper.setEnd(calendar.getEnd().toString());
        listCalendarWrapper.setColor(calendar.getColor());
        listCalendarWrapper.setAllDay(1);
        return listCalendarWrapper;
    }

    public Calendar maintenance2Calendar(Maintenance maintenance) {
        Calendar calendar = new Calendar();
        calendar.setDescription(maintenance.getMachine().getNamemachine());
        calendar.setStart(maintenance.getDatemaintenance());
        calendar.setEnd(maintenance.getDatemaintenance());
        calendar.setTitle(maintenance.getDescription());
        calendar.setColor("#ef5350");
        calendar.setMaintenance(maintenance);
        return calendar;
    }
    public Calendar calendar2UpdateCalendar(Maintenance maintenance,Calendar calendar) {
        Calendar calendar1 = maintenance2Calendar(maintenance);
        calendar1.setId(calendar.getId());
        calendar1.setCreatedAt(calendar.getCreatedAt());
        calendar1.setUpdatedAt(calendar.getUpdatedAt());
        return calendar1;
    }
}
