package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.enums;

public enum ProductStatus {
    DoingBusiness(1),
    TemporarilyPaused(0),
    NoLongerInBusiness(-1);

    private final int status;

    private ProductStatus(int status){
        this.status = status;
    }
    public static ProductStatus fromStatusNumber(int statusNumber){
        return switch (statusNumber) {
            case 1 -> ProductStatus.DoingBusiness;
            case 0 -> ProductStatus.TemporarilyPaused;
            case -1 -> ProductStatus.NoLongerInBusiness;
            default -> ProductStatus.TemporarilyPaused;
        };
    }
}
