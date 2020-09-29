package com.example.problemstarterwebissue

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ProblemStarterWebIssueApplication

fun main(args: Array<String>) {
    runApplication<ProblemStarterWebIssueApplication>(*args)
}

@RestController
@RequestMapping("/hello")
class HelloWorldController {
    @GetMapping
    fun sayHello() {
        throw HelloNotFoundException()
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class HelloNotFoundException() : RuntimeException("Hello not found")

@Configuration
class SecurityConfig() : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.anonymous().and().authorizeRequests().anyRequest().permitAll()
    }
}