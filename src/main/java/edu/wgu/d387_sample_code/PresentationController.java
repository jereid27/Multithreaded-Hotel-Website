package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")

public class PresentationController {

    @GetMapping("/presentation")
    public String[] getPresentationTimes(){
        return DisplayPresentation.retrievePresentation();
    }
}
