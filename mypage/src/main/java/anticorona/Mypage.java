package anticorona;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Mypage_table")
public class Mypage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long bookId;
        private Long vaccineId;
        private String vcName;
        private Long userId;
        private String status;


        public Long getBookId() {
            return bookId;
        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }
        public Long getVaccineId() {
            return vaccineId;
        }

        public void setVaccineId(Long vaccineId) {
            this.vaccineId = vaccineId;
        }
        public String getVcName() {
            return vcName;
        }

        public void setVcName(String vcName) {
            this.vcName = vcName;
        }
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
