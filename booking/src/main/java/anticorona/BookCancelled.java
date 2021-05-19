package anticorona;

public class BookCancelled extends AbstractEvent {

    private Long bookId;
    private Long vaccineId;
    private Long userId;
    private String status;
    private Long delbook;
    private Long addBook;

    public BookCancelled(){
        super();
    }

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
    public Long getDelbook() {
        return delbook;
    }

    public void setDelbook(Long delbook) {
        this.delbook = delbook;
    }
    public Long getAddBook() {
        return addBook;
    }

    public void setAddBook(Long addBook) {
        this.addBook = addBook;
    }
}
