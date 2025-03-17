package com.example.rock_paper_scissors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // Allows REST API to be invoked by resources not on the same domain.
public class ScoreController {
    
    @GetMapping("/health-check")
    public String getHealthCehck() {
        return "Application is built and running. SNAFU (Situation Normal All Fired Up!)";
    }

}
