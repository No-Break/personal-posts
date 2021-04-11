package study.nobreak.personalposts.wonos.contents

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.wonos.contents.repository.ContentsRepository

@RestController
@RequestMapping
class ContentsController(val contentsRepo: ContentsRepository) {

    @GetMapping
    fun getPosts(): ResponseEntity<*> {
        val posts = contentsRepo.findAll()

        return ResponseEntity.ok(posts)
    }
}