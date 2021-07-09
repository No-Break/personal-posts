package study.nobreak.personalposts.sm

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.sm.service.SmBoardService


@RestController
class SmBoardController(var smBoardService: SmBoardService) {

    @PostMapping("/board/post")
    fun addPost(smBoard: SmBoard): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.addPost(smBoard))
    }

    @GetMapping("/board/post")
    fun getPost(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.getPost())
    }

    @GetMapping("/board/post/{userId}")
    fun getUserPost(@PathVariable userId: String): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.getUserPost(userId))
    }
}
