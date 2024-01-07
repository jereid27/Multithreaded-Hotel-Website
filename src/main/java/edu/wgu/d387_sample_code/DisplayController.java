package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class DisplayController {

    @GetMapping("/welcome")
    public String[] getWelcomeMessages() {
        return DisplayMessage.retrieveMessages();
    }

}
