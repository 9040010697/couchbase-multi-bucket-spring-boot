package com.cb;

import com.cb.model.Customer;
import com.cb.model.MlcCard;
import com.cb.model.Session;
import com.cb.model.User;
import com.cb.repository.CustomerRepository;
import com.cb.repository.SessionRepository;
import com.cb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@SpringBootApplication
@EnableReactiveCouchbaseRepositories
public class BootLuncher {


    public static void main(String[] args) {
        SpringApplication.run(BootLuncher.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository repository,
                                               UserRepository userRepository,
                                               SessionRepository sessionRepository) {
        return e -> repository.saveAll(getDataList(userRepository, sessionRepository)).subscribe();
    }

 
    private List<Customer> getDataList(UserRepository userRepository, SessionRepository sessionRepository) {
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setCId(UUID.randomUUID().toString());
            String phNo = String.valueOf(new Random().nextInt(2147483647));
            customer.setPhoneNumber(phNo);
            customer.setRoles(new String[]{"PRO", "DIY"});

            List<MlcCard> cards = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                MlcCard card = new MlcCard();
                card.setMlcCardNo(String.valueOf(new Random().nextInt(2147483647)));
                card.setActive(new Random().nextBoolean());
                cards.add(card);
            }
            customer.setMlcCards(cards);
            list.add(customer);

            User user = new User();
            user.setUId(UUID.randomUUID().toString());
            user.setMobile(phNo);
            user.setUName("Dj"+new Random().nextInt(2147483647));

            userRepository.save(user).subscribe();

            Session session = new Session();
            session.setId(UUID.randomUUID().toString());
            session.setSession(phNo);

            sessionRepository.save(session).subscribe();

            System.out.println("SAVED :: " + phNo);

        }
                                      
        return list;
    }
}
