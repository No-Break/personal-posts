package study.nobreak.personalposts.wonos.contents

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import study.nobreak.personalposts.wonos.contents.service.ContentsService
import study.nobreak.personalposts.wonos.contents.vo.ContentsVo

@RestController
@RequestMapping("/wo/board")
class ContentsController(
    private val contentService: ContentsService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllContents() {
        return contentService.searchAllContents()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createContents(contentsVo: ContentsVo) {
        contentService.createContents(contentsVo.title, contentsVo.mainText, contentsVo.writer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteContents(@PathVariable("id")id: Int) {
        contentService.deleteContents(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateContents(@PathVariable("id")id: Int) {
        contentService.updateContents(id)
    }

}
