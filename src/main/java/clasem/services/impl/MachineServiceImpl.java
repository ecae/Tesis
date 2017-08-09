package clasem.services.impl;

import clasem.converter.MachineConverter;
import clasem.entities.core.Machine;
import clasem.repositories.MachineRepository;
import clasem.services.MachineService;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import clasem.wrappers.machine.MachineModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    private static String UPLOADED_FOLDER = "src/main/resources/static/imageMachine/";

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private MachineConverter machineConverter;

    @Override
    public List<ListMachineWrapper> allMachines() {
        List<Machine> machines = machineRepository.findAll();
        List<ListMachineWrapper> listMachineWrappers = new ArrayList<ListMachineWrapper>();

        for (Machine machine : machines) {
            listMachineWrappers.add(machineConverter.machines2listMachineWrappers(machine));
        }

        return listMachineWrappers;
    }

    @Override
    public EditMachineWrapper findById(int id) {
        return machineConverter.machine2EditMachineWrapper(machineRepository.findById(id));
    }

    @Override
    public void saveMachine(CreateMachineWrapper createMachineWrapper) {
        machineRepository.save(machineConverter.createMachineWrapper2Machine(createMachineWrapper));
        storageFile(createMachineWrapper.getImage());
    }

    @Override
    public ResponseEntity updateMachine(Machine machine,MachineModifyWrapper machineModifyWrapper) {

        machineRepository.save(machineConverter.machineModifyWrapper2Machine(machine,machineModifyWrapper));
        storageFile(machineModifyWrapper.getImage());
        return new ResponseEntity("Maquinaria modificada correctamente", HttpStatus.OK);
    }


    private void storageFile(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();

            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);

        if (!fieldName.equals("serie")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }

        Machine machine = machineRepository.findBySerie(value.toString());

        return verifyNullMachine(machine);
    }

    @Override
    public boolean fieldIdExists(String id) throws UnsupportedOperationException {

        if (id == null  || id == "") {
            return false;
        }
        int nid = Integer.parseInt(id);
        Machine machine = machineRepository.findById(nid);

        if (null != machine) {
            return false;
        }
        return true;
    }

    private boolean verifyNullMachine(Machine machine) {

        if (null == machine) {
            return false;
        }
        return true;
    }
}
