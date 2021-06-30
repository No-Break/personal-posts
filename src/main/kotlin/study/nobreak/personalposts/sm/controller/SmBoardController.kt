package study.nobreak.personalposts.sm.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.sm.domain.SmBoard
import study.nobreak.personalposts.sm.service.SmBoardService


@RestController
class SmBoardController(var smBoardService: SmBoardService) {

    @PostMapping("/board")
    fun addPost(smBoard: SmBoard): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.addPost(smBoard))
    }

}