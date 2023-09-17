package fit.iuh.wwwlab2shop.enums;

public enum ProductStatus {
    IN_BUSINESS(1),
    PAUSED(2),
    OUT_OF_BUSINESS(3);
    private final int code;
    ProductStatus(int code){
        this.code = code;
    }
    public  int getCode(){
        return code;
    }
}
