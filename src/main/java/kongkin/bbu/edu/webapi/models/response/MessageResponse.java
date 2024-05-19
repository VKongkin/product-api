package kongkin.bbu.edu.webapi.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
    private String code;
    private String message;
    private String messageKH;
    private Object data;

    public void getDataSuccess(Object data){
        this.setCode("200");
        this.setMessage("Data Successfully Retrieve");
        this.setMessageKH("អបអរសាទរលោកអ្នកទទួលបានទិន្នន័យដោយជោគជ័យ សូមអរគុណលោកគ្រូ និងសិស្សនិស្សិតទាំងអស់");
        this.setData(data);
    }

    public void createDataSuccess(Object data){
        this.setCode("200");
        this.setMessage("Data Successfully Created");
        this.setMessageKH("អបអរសាទរលោកអ្នកបង្កើតទិន្នន័យដោយជោគជ័យ សូមអរគុណលោកគ្រូ និងសិស្សនិស្សិតទាំងអស់");
        this.setData(data);
    }

    public void updateDataSuccess(Object data){
        this.setCode("200");
        this.setMessage("Data Successfully Updated");
        this.setMessageKH("អបអរសាទរលោកអ្នកបានកែប្រែទិន្នន័យដោយជោគជ័យ សូមអរគុណលោកគ្រូ និងសិស្សនិស្សិតទាំងអស់");
        this.setData(data);
    }

    public void deleteDataSuccess(Object data){
        this.setCode("200");
        this.setMessage("Data Successfully Deleted");
        this.setMessageKH("ណែៗៗ អបអរសាទរលោកអ្នកបានលុបទិន្នន័យដោយជោគជ័យ សូមអរគុណលោកគ្រូ និងសិស្សនិស្សិតទាំងអស់");
        this.setData(data);
    }

    public void generalDataError(Object data){
        this.setCode("500");
        this.setMessage("Internal Server Error");
        this.setMessageKH("ណែៗៗ អបអរសាទរលោកអ្នកបាន Error ដោយជោគជ័យ សូមអរគុណលោកគ្រូ និងសិស្សនិស្សិតទាំងអស់");
        this.setData(data);
    }
}
