package anticorona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

 @RestController
 public class VaccineController {

     @Autowired
     VaccineRepository vaccineRepository;

     @RequestMapping(value = "/vaccines/chkAndModifyStock",
             method = RequestMethod.GET,
             produces = "application/json;charset=UTF-8")
     public Boolean chkAndModifyStock(HttpServletRequest request, HttpServletResponse response) {
         Long vaccineId = Long.parseLong(request.getParameter("vaccineId"));
         Optional<Vaccine> vaccine = this.vaccineRepository.findById(vaccineId);
         if(vaccine.isPresent())
             return vaccine.get().canBook();
         else return true;
     }
 }
