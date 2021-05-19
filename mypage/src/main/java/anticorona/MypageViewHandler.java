package anticorona;

import anticorona.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {


    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBooked_then_CREATE_1 (@Payload Booked booked) {
        try {

            if (!booked.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setVaccineId(booked.getVaccineId());
            mypage.setVcName(booked.getVcName());
            mypage.setUserId(booked.getUserId());
            mypage.setBookId(booked.getBookingId());
            mypage.setStatus(booked.getStatus());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookCancelled_then_UPDATE_1(@Payload BookCancelled bookCancelled) {
        try {
            if (!bookCancelled.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByBookId(bookCancelled.getBookingId());
            if( mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(bookCancelled.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookUpdated_then_UPDATE_2(@Payload BookUpdated bookUpdated) {
        try {
            if (!bookUpdated.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByBookId(bookUpdated.getBookingId());
            if( mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(bookUpdated.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVcCompleted_then_UPDATE_3(@Payload VcCompleted vcCompleted) {
        try {
            if (!vcCompleted.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByBookId(vcCompleted.getBookingId());
            if( mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(vcCompleted.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}