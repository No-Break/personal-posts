package study.nobreak.personalposts.sm

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class smController {

    @GetMapping
    fun hello(): String = "hello world"
}