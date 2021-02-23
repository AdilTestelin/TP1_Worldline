package com.wl.tuto.messagemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageManagerApplication.class, args);
    }

    /** @Bean
    CommandLineRunner commandLineRunner(MessageRepository msgRepo){
        return args -> {
            ArrayList<String> arrStr = new ArrayList<>();
            arrStr.add("test");
            arrStr.add("test1");
            Message msg = new Message("TestId", Message.getStatus(), "test", "test", 1, arrStr);

            msgRepo.save(msg);
        };
    } **/

}
