package clasem.wrappers.machine;

import clasem.components.constraint.ImageConstraint;
import clasem.components.constraint.MultipartFileNotEmpty;
import clasem.components.constraint.UniqueConstraint;
import clasem.components.constraint.UploadSizeConstraint;
import clasem.services.MachineService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class CreateMachineWrapper {

    @NotNull
    @Size(min = 3, max = 20)
    private String fabricator;

    @NotNull
    @Size(min = 3, max = 20)
    private String mark;

    @NotNull
    @Size(min = 3, max = 20)
    private String model;

    @NotNull
    @Size(min = 3, max = 20)
    private String namemachine;

    @NotNull
    @Size(min = 3, max = 20)
    @UniqueConstraint(service = MachineService.class,fieldName = "serie")
    private String serie;

    @NotNull
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date datepurchase;

    @MultipartFileNotEmpty
    @ImageConstraint
    @UploadSizeConstraint(max = 1000000)
    private MultipartFile image;

    public CreateMachineWrapper() {
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNamemachine() {
        return namemachine;
    }

    public void setNamemachine(String namemachine) {
        this.namemachine = namemachine;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDatepurchase() {
        return datepurchase;
    }

    public void setDatepurchase(Date datepurchase) {
        this.datepurchase = datepurchase;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
