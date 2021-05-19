package anticorona;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Vaccine_table")
public class Vaccine {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long vaccinId;
    private String vcName;
    private Long stock;
    private Long bookQty;

    @PostPersist
    public void onPostPersist(){
        VcRegistered vcRegistered = new VcRegistered();
        BeanUtils.copyProperties(this, vcRegistered);
        vcRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        VcStockAdded vcStockAdded = new VcStockAdded();
        BeanUtils.copyProperties(this, vcStockAdded);
        vcStockAdded.publishAfterCommit();


        StockModified stockModified = new StockModified();
        BeanUtils.copyProperties(this, stockModified);
        stockModified.publishAfterCommit();


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
