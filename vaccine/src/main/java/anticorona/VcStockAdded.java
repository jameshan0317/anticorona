package anticorona;

public class VcStockAdded extends AbstractEvent {

    private Long vaccinId;
    private String vcName;
    private Long stock;
    private Long bookQty;

    public VcStockAdded(){
        super();
    }

    public Long getVaccinId() {
        return vaccinId;
    }

    public void setVaccinId(Long vaccinId) {
        this.vaccinId = vaccinId;
    }
    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
    public Long getBookQty() {
        return bookQty;
    }

    public void setBookQty(Long bookQty) {
        this.bookQty = bookQty;
    }
}
