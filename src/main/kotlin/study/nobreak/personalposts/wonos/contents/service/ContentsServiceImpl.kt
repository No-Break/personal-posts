package study.nobreak.personalposts.wonos.contents.service

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import study.nobreak.personalposts.wonos.contents.domain.Contents
import study.nobreak.personalposts.wonos.contents.repository.ContentsRepository
import study.nobreak.personalposts.wonos.contents.service.ContentsService

@Service
class ContentsServiceImpl(
    private val contentsRepo : ContentsRepository

) : ContentsService  {

    override fun searchAllContents() {
        contentsRepo.findAll()
    }

    override fun createContents(title: String, mainText: String, writer: String) {
        contentsRepo.save(Contents(title = title, mainText = mainText, writer = writer))
    }

    override fun deleteContents(id: Int) {
        contentsRepo.deleteById(id)
    }

    override fun updateContents(id: Int) {
        contentsRepo.save(Contents(id = id))
    }
}