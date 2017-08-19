package clasem.services.impl;

import clasem.converter.AssignmentMachineConvert;
import clasem.converter.CalendarConverter;
import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Calendar;
import clasem.entities.core.Machine;
import clasem.entities.core.Maintenance;
import clasem.entities.user.User;
import clasem.repositories.AssignmentMachineRepository;
import clasem.repositories.CalendarRepository;
import clasem.repositories.MaintenanceRepository;
import clasem.repositories.UserRepository;
import clasem.services.CalendarService;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private CalendarConverter calendarConverter;
    private CalendarRepository calendarRepository;
    private MaintenanceRepository maintenanceRepository;
    private UserRepository userRepository;
    private AssignmentMachineRepository assignmentMachineRepository;

    @Autowired
    public void setCalendarConverter(CalendarConverter calendarConverter) {
        this.calendarConverter = calendarConverter;
    }

    @Autowired
    public void setCalendarRepository(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Autowired
    public void setMaintenanceRepository(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private void setAssignmentMachineRepository (AssignmentMachineRepository assignmentMachineRepository){
        this.assignmentMachineRepository = assignmentMachineRepository;
    }

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
    public List<ListCalendarWrapper> listAllCalendarOperator(long id_user) {
        User user = userRepository.findById(id_user);
        AssignmentMachine assignmentMachine = assignmentMachineRepository.findByUser(user);
        List<ListCalendarWrapper> listCalendarWrappers = new ArrayList<ListCalendarWrapper>();
        if(assignmentMachine != null){
            Machine machine = assignmentMachine.getMachine();
            List<Calendar> calendars = calendarRepository.findAllByDescription(machine.getNamemachine());
            for (Calendar calendar: calendars) {
                listCalendarWrappers.add(calendarConverter.calendar2ListCalendarWrapper(calendar));
            }
            return listCalendarWrappers;
        }
        return listCalendarWrappers;
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
