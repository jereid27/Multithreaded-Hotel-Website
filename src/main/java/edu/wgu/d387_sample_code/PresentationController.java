package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("http://localhost:4200")

public class PresentationController {

    @GetMapping("/presentation")
    public String[] getPresentationTimes(
    ){
        LocalDateTime futureDateTime = LocalDateTime.of(2024, 2, 16, 10, 30);
        return DisplayPresentation.retrievePresentation(futureDateTime);
    }
}
