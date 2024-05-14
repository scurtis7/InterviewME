package com.scurtis.ime;

import com.scurtis.ime.service.InterviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class ApplicationTests {

    @Autowired
    private InterviewService interviewService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(interviewService);
    }

}
