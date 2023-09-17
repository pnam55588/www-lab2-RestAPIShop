package fit.iuh.wwwlab2shop.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    ON_LEAVE(0),
    TERMINATED(-1);

    private int code;

    EmployeeStatus(int code){
        this.code =code;
    }

    public int getCode() {
        return code;
    }
}
