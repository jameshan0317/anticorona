package anticorona;

import anticorona.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    InjectionRepository injectionRepository;


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBooked_AcceptBooking(@Payload Booked booked){

        if(!booked.validate()) return;

        System.out.println("\n\n##### listener AcceptBooking : " + booked.toJson() + "\n\n");

        // AcceptBooking Logic //
        if(booked.isMe()){
            
            Injection injection = new Injection();
            injection.setBookingId(booked.getBookingId());
            injection.setStatus("AcceptBooking");

            injectionRepository.save(injection);
        }
          
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookCancelled_CancelAcceptBooking(@Payload BookCancelled bookCancelled){

        if(!bookCancelled.validate()) return;

        System.out.println("\n\n##### listener AcceptCancelBooking : " + bookCancelled.toJson() + "\n\n");

        // AcceptCancelBooking Logic //
        
        if(bookCancelled.isMe()){
            Optional<injection> injectionOptional = injectionRepository.findById(bookCancelled.getBookingId());
            Injection injection = injectionOptional.get();

            injection.setStatus(bookCancelled.getStatus());
            injectionRepository.save(injection);
        }
    }

    @Autowired
    CancellationRepository cancellationRepository;    

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookCancelled_RegCancelBooking(@Payload BookCancelled bookCancelled){

        if(!bookCancelled.validate()) return;

        System.out.println("\n\n##### listener RegCancelBooking : " + bookCancelled.toJson() + "\n\n");

        // RegCancelBooking Logic //
        if(booked.isMe()){            
            Cancellation cancellation = new Cancellation();
            cancellation.setBookingId(booked.getBookingId());
            cancellation.setVaccineId(booked.getVaccineId());
            cancellation.setUserId(booked.getUserId());
            
            cancellationRepository.save(cancellation);
        }        
            
    }

    

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


    
}
