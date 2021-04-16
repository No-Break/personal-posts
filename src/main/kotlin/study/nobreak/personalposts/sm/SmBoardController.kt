package study.nobreak.personalposts.sm

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class SmBoardController(var smBoardService: SmBoardService) {

    @PostMapping("/boardSave")
    fun boardSave(smBoard: SmBoard): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smBoardService.boardSave(smBoard))
    }

}