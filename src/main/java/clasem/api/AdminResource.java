package clasem.api;

import clasem.api.exceptions.InvalidFieldMachineModifyException;
import clasem.api.exceptions.InvalidFieldModifyAssignmentMachineException;
import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.components.constraint.IdConstraint;
import clasem.controllers.AssignmentMachineController;
import clasem.controllers.MachineController;
import clasem.controllers.MaintenanceController;
import clasem.controllers.UserController;
import clasem.services.AssignmentMachineService;
import clasem.services.MachineService;
import clasem.services.MaintenanceService;
import clasem.services.UserService;
import clasem.wrappers.AssignmentMachine.CreateAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.EditAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.ListAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.UpdateAssignmentMachineWrapper;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import clasem.wrappers.machine.MachineModifyWrapper;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import clasem.wrappers.maintenance.EditMaintenanceWrapper;
import clasem.wrappers.maintenance.ListMaintenanceWrapper;
import clasem.wrappers.user.CreateUserWrapper;
import clasem.wrappers.user.EditUserWrapper;
import clasem.wrappers.user.ListUsersWrapper;
import clasem.wrappers.user.UserModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {

    private UserController userController;
    private MachineController machineController;
    private AssignmentMachineController assignmentMachineController;
    private MaintenanceController maintenanceController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Autowired
    public void setMachineController(MachineController machineController) {
        this.machineController = machineController;
    }

    @Autowired
    public void setAssignmentMachineController(AssignmentMachineController assignmentMachineController) {
        this.assignmentMachineController = assignmentMachineController;
    }

    @Autowired
    public void setMaintenanceController(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    //********CRUD DE USERS*************
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<ListUsersWrapper> allUsers() {
        return userController.allUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public EditUserWrapper findUserById(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id) {
        Long iden = Long.parseLong(id);
        return userController.findById(iden);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity addUser(@Valid @RequestBody CreateUserWrapper createUserWrapper, Errors errors){

        return userController.createUser(createUserWrapper);
    }

    @RequestMapping(value = "/user/{id}/edit",method = RequestMethod.PUT)
    public ResponseEntity userModify(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id , @Valid @RequestBody UserModifyWrapper userModifyWrapper , Errors errors) throws InvalidFieldModifyUserException {

        Long iden = Long.parseLong(id);
        return userController.userModify(iden,userModifyWrapper);
    }

    @RequestMapping(value ="/user/{id}/delete",method = RequestMethod.DELETE)
    public ResponseEntity userDestroy(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id ) {
        Long iden = Long.parseLong(id);
        return userController.userDelete(iden);
    }

    //********CRUD DE MAQUINARIAS*************

    @RequestMapping(value = "/machines",method = RequestMethod.GET)
    public List<ListMachineWrapper> allMachines() {
        return machineController.listMachines();
    }

    @RequestMapping(value = "/machine/{id}", method = RequestMethod.GET)
    public EditMachineWrapper findMachineById(@Valid @IdConstraint(service = MachineService.class) @PathVariable(value = "id")  String id) {
        int iden = Integer.parseInt(id);
        return machineController.findById(iden);
    }

    @RequestMapping(value="/machine/create", method=RequestMethod.POST)
    public ResponseEntity saveMachine(@Valid @ModelAttribute CreateMachineWrapper createMachineWrapper, Errors errors) {
        return machineController.saveMachine(createMachineWrapper);
    }

    @RequestMapping(value = "/machine/{id}/edit", method = RequestMethod.POST)
    public ResponseEntity updateMachine(@Valid @IdConstraint(service = MachineService.class) @PathVariable(value = "id")  String id, @Valid @ModelAttribute MachineModifyWrapper machineModifyWrapper , Errors error) throws InvalidFieldMachineModifyException {
        int iden = Integer.parseInt(id);
        return machineController.updateMachine(iden,machineModifyWrapper);
    }

    @RequestMapping(value = "/machine/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity machineDestroy(@Valid @IdConstraint(service = MachineService.class) @PathVariable(value = "id")  String id ) {
        int iden = Integer.parseInt(id);
        return machineController.deleteMachine(iden);
    }

    //*******CRUD DE ASIGNACION DE MAQUINARIA*******

    @RequestMapping(value = "/assignment/list", method = RequestMethod.GET)
    public List<ListAssignmentMachineWrapper> listAssignmentMachineWrapper() {
        return assignmentMachineController.listAssignments();
    }

    @RequestMapping(value = "/assignment/{id}", method = RequestMethod.GET)
    public EditAssignmentMachineWrapper findById(@Valid @IdConstraint(service = AssignmentMachineService.class) @PathVariable(value = "id")  String id){
        return assignmentMachineController.findById(id);
    }

    @RequestMapping(value = "/assignment/create", method = RequestMethod.POST)
    public ResponseEntity createAssignment(@Valid @RequestBody CreateAssignmentMachineWrapper createAssignmentMachineWrapper, Errors errors ) {
        return assignmentMachineController.createAssignmentMachine(createAssignmentMachineWrapper);
    }

    @RequestMapping(value = "/assignment/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity updateAssignment(@Valid @IdConstraint(service = AssignmentMachineService.class) @PathVariable(value = "id")  String id, @Valid @RequestBody UpdateAssignmentMachineWrapper updateAssignment , Errors errors) throws InvalidFieldModifyAssignmentMachineException {
        return assignmentMachineController.UpdateAssignment(id,updateAssignment);
    }

    @RequestMapping(value = "/assignment/{id}/delete",method = RequestMethod.DELETE)
    public ResponseEntity deleteAssignment(@Valid @IdConstraint(service = AssignmentMachineService.class) @PathVariable(value = "id")  String id) {
        return assignmentMachineController.deleteAssignment(id);
    }

    //**********CRUD MANTENIMIENTOS**********

    @RequestMapping(value = "/maintenance/create", method = RequestMethod.POST)
    public ResponseEntity createMaintenance(@Valid @RequestBody CreateMaintenanceWrapper createMaintenanceWrapper, Errors errors) {
       return maintenanceController.createMaintenance(createMaintenanceWrapper);
    }

    @RequestMapping(value = "/maintenance/list", method = RequestMethod.GET)
    public List<ListMaintenanceWrapper> listMaintenance() {
        return maintenanceController.listAll();
    }

    @RequestMapping(value = "/maintenance/{id}", method = RequestMethod.GET)
    public EditMaintenanceWrapper findMaintenanceId(@Valid @IdConstraint(service = MaintenanceService.class) @PathVariable(value = "id")  String id) {
        return maintenanceController.findMainteanceById(id);
    }

    @RequestMapping(value = "/maintenance/{id}/edit", method = RequestMethod.PUT)
    public ResponseEntity updateMaintenance(@Valid @IdConstraint(service = MaintenanceService.class) @PathVariable(value = "id")  String id, @Valid @RequestBody CreateMaintenanceWrapper createMaintenanceWrapper, Errors errors) {
        return maintenanceController.updateMaintenance(id,createMaintenanceWrapper);
    }

    @RequestMapping(value = "/maintenance/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteMaintenance(@Valid @IdConstraint(service = MaintenanceService.class) @PathVariable(value = "id")  String id) {
        return maintenanceController.deleteMaintenance(id);
    }
}

