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
    @Autowired InjectionRepository injectionRepository;
    @Autowired CancellationRepository cancellationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBooked_AcceptBooking(@Payload Booked booked){

        if(!booked.validate()) return;

        System.out.println("\n\n##### listener AcceptBooking : " + booked.toJson() + "\n\n");

        // Sample Logic //
        Injection injection = new Injection();
        injectionRepository.save(injection);
        Cancellation cancellation = new Cancellation();
        cancellationRepository.save(cancellation);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookCancelled_CancelAcceptBooking(@Payload BookCancelled bookCancelled){

        if(!bookCancelled.validate()) return;

        System.out.println("\n\n##### listener CancelAcceptBooking : " + bookCancelled.toJson() + "\n\n");

        // Sample Logic //
        Injection injection = new Injection();
        injectionRepository.save(injection);
        Cancellation cancellation = new Cancellation();
        cancellationRepository.save(cancellation);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookCancelled_RegCancelBooking(@Payload BookCancelled bookCancelled){

        if(!bookCancelled.validate()) return;

        System.out.println("\n\n##### listener RegCancelBooking : " + bookCancelled.toJson() + "\n\n");

        // Sample Logic //
        Injection injection = new Injection();
        injectionRepository.save(injection);
        Cancellation cancellation = new Cancellation();
        cancellationRepository.save(cancellation);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
