package study.nobreak.personalposts.wonos.contents

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import study.nobreak.personalposts.wonos.contents.service.ContentsService
import study.nobreak.personalposts.wonos.contents.vo.ContentsVo

@RestController
@RequestMapping("/wo/board")
class ContentsController(
    private val contentService: ContentsService
) {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/contents")
    fun getAllContents(contentsVo: ContentsVo){
        contentService.searchAllContents(contentsVo.title, contentsVo.mainText, contentsVo.writer)
    }

    @PostMapping("/contents/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createContent(contentsVo: ContentsVo){
        contentService.createContent(contentsVo.title, contentsVo.mainText, contentsVo.writer)
    }
}