package study.nobreak.personalposts.so.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.so.service.SoPostService
import study.nobreak.personalposts.so.web.vo.SoPostCreateVo

@RestController
@RequestMapping("/so/post")
class SoPostController(
    private val soPostService: SoPostService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addPost(soPostCreateVo: SoPostCreateVo) {
        soPostService.addPost(soPostCreateVo.title, soPostCreateVo.content)
    }
}