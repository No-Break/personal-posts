package study.nobreak.personalposts.so.service

import org.springframework.stereotype.Service
import study.nobreak.personalposts.so.domain.SoPost
import study.nobreak.personalposts.so.repository.SoPostRepository

@Service
class SoPostServiceImpl(
    private val soPostRepository: SoPostRepository
) : SoPostService {
    override fun addPost(title: String, content: String) {
        soPostRepository.save(SoPost(title = title, content = content))
    }
}