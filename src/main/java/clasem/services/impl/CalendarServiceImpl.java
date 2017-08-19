package clasem.services.impl;

import clasem.converter.CalendarConverter;
import clasem.entities.core.Calendar;
import clasem.entities.core.Maintenance;
import clasem.repositories.CalendarRepository;
import clasem.repositories.MaintenanceRepository;
import clasem.services.CalendarService;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarConverter calendarConverter;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public List<ListCalendarWrapper> listAllCalendar() {
        List<Calendar> calendarList = calendarRepository.findAll();
        List<ListCalendarWrapper> listCalendarWrappers = new ArrayList<ListCalendarWrapper>();
        for (Calendar calendar: calendarList) {
            listCalendarWrappers.add(calendarConverter.calendar2ListCalendarWrapper(calendar));
        }
        return listCalendarWrappers;
    }

    @Override
    public List<ListCalendarWrapper> listAllCalendarOperator() {
        return null;
    }

    @Override
    public void addCalendar(Maintenance maintenance) {
        if(maintenance.getDatemaintenance() != null) {
              calendarRepository.save(calendarConverter.maintenance2Calendar(maintenance));
        }
    }

    public void updateCalendar(Maintenance maintenance) {
        Calendar calendar = calendarRepository.findByMaintenance(maintenance);
        if (maintenance.getDatemaintenance() == null && calendar != null) {
            calendarRepository.delete(calendar.getId());
        }else if (maintenance.getDatemaintenance() != null && calendar == null){
            calendarRepository.save(calendarConverter.maintenance2Calendar(maintenance));
        }else if(maintenance.getDatemaintenance() != null && calendar != null ){
            calendarRepository.save(calendarConverter.calendar2UpdateCalendar(maintenance,calendar));
        }
    }

    @Override
    public void deleteCalendar(int id_maintenance) {
        Maintenance maintenance = maintenanceRepository.findOne(id_maintenance);
        Calendar calendar = calendarRepository.findByMaintenance(maintenance);
        if(calendar != null) {
            calendarRepository.delete(calendar.getId());
        }
    }
}
