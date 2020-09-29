package com.example.problemstarterwebissue

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.zalando.problem.spring.common.MediaTypes

@SpringBootTest
@AutoConfigureMockMvc
class ProblemStarterWebIssueApplicationTests {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testProblemSupport() {
        mockMvc.get("/hello") {
            accept(MediaType.APPLICATION_JSON)
        }.andExpect {
            status { isNotFound }
            header { string(HttpHeaders.CONTENT_TYPE, MediaTypes.PROBLEM_VALUE) }
        }
    }

}
