package clasem.controllers;

import clasem.services.CalendarService;
import clasem.services.OperatorService;
import clasem.wrappers.AssignmentMachine.DetailsOperatorAssignmentWrapper;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import clasem.wrappers.user.JwtUserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OperatorController {

    private UserController userController;
    private OperatorService operatorService;
    private CalendarService calendarService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Autowired
    public void setOperatorService(OperatorService  operatorService) {
        this.operatorService = operatorService;
    }

    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public DetailsOperatorAssignmentWrapper detail2Operator(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        JwtUserWrapper user = userController.deatilsUserAthenticated(token);
        return operatorService.findDetailAssignment(user.getId());
    }

    public List<ListCalendarWrapper> listCalendar(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        JwtUserWrapper user = userController.deatilsUserAthenticated(token);
        return calendarService.listAllCalendarOperator(user.getId());
    }
}
