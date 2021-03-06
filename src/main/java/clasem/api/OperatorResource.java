package clasem.api;

import clasem.controllers.OperatorController;
import clasem.controllers.UserController;
import clasem.wrappers.AssignmentMachine.DetailsOperatorAssignmentWrapper;
import clasem.wrappers.Calendar.ListCalendarWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
@RequestMapping("/operator")
public class OperatorResource {

    private OperatorController operatorController;

    @Autowired
    public void setOperatorController(OperatorController operatorController) {
        this.operatorController = operatorController;
    }

    @RequestMapping(value = "/assignment/machine", method = RequestMethod.GET)
    public DetailsOperatorAssignmentWrapper HelloOperator(HttpServletRequest request) {
        return operatorController.detail2Operator(request);
    }

    @RequestMapping(value = "/calendar/maintenances{id?}", method = RequestMethod.GET)
    public List<ListCalendarWrapper> listCalendar(HttpServletRequest request) {
        return operatorController.listCalendar(request);
    }

}
