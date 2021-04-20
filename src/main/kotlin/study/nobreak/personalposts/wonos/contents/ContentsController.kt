package study.nobreak.personalposts.wonos.contents


import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import study.nobreak.personalposts.wonos.contents.service.ContentsServiceImpl
import study.nobreak.personalposts.wonos.contents.vo.ContentsVo

@RestController
@RequestMapping("/wo/board")
class ContentsController(
    private val contentsServiceImpl: ContentsServiceImpl
) {
    @GetMapping("/contents")
    fun getAllContents(contentsVo: ContentsVo){
        contentsServiceImpl.searchAllContents(contentsVo.title, contentsVo.mainText, contentsVo.writer)
    }
}