package io.github.michaelwoj.atiperarecruitmenttask.intergration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AtiperaRecruitmentTaskIntegrationTest {
 
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void verifyHappyPath() throws Exception {

        String username = "michaelwoj";

        mockMvc.perform(get("/" + username + "/repos")
                .accept(MediaType.APPLICATION_JSON))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].login").exists())
                .andExpect(jsonPath("$[0].branch").isArray())
                .andExpect(jsonPath("$[0].branch[0].name").exists())
                .andExpect(jsonPath("$[0].branch[0].sha").exists());
    }
}
