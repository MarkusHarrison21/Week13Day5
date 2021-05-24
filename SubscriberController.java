package com.tts.week13day5.controller;

import com.tts.week13day5.repository.SubscriberRepository;
import com.tts.week13day5.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

//should have: 'value = "/" ' but because of only having one path we can do it like on line 17
    @GetMapping("/")
    public String index(Subscriber subscriber){
//        this is the specified template
//        it will be utilized by thymeleaf
        return "subscriber/index";
    }

    private Subscriber subscriber;

    @PostMapping(value = "/")
    public String addNewSubscriber(Subscriber subscriber, Model model){
        subscriberRepository.save(new Subscriber(
                subscriber.getFirstName(),
                subscriber.getLastName(),
                subscriber.getUserName(),
                subscriber.getSignedUp()
        ));

        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());
        return "subscriber/result";

    }

}

