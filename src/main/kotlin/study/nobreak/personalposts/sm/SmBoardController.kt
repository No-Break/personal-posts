package study.nobreak.personalposts.sm

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.sm.service.SmBoardService


@RestController
class SmBoardController(var smBoardService: SmBoardService) {

    @PostMapping("/addBoard")
    fun addPost(smBoard: SmBoard): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.addPost(smBoard))
    }

    @PostMapping("/getBoard")
    fun getPost(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.getPost())
    }

    @PostMapping("/getUserBoard")
    fun getUserPost(@RequestParam userId: String): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.getUserPost(userId))
    }
}
