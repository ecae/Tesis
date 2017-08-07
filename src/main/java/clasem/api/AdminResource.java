package clasem.api;

import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.components.constraint.IdConstraint;
import clasem.controllers.MachineController;
import clasem.controllers.UserController;
import clasem.services.MachineService;
import clasem.services.UserService;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
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

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Autowired
    public void setMachineController(MachineController machineController) {
        this.machineController = machineController;
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
    public ResponseEntity singleSave(@Valid @ModelAttribute CreateMachineWrapper createMachineWrapper, Errors errors) {
        return machineController.saveMachine(createMachineWrapper);
    }

}

