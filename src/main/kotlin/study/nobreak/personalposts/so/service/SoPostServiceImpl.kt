package study.nobreak.personalposts.so.service

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import study.nobreak.personalposts.so.domain.SoPost
import study.nobreak.personalposts.so.exception.NoDataFoundException
import study.nobreak.personalposts.so.repository.SoPostRepository
import study.nobreak.personalposts.so.web.response.SoPostGetResponse
import study.nobreak.personalposts.so.web.response.SoPostResponseItem

@Service
class SoPostServiceImpl(
    private val soPostRepository: SoPostRepository
): SoPostService {
    override fun addPost(title: String, content: String) {
        soPostRepository.save(SoPost(title = title, content = content))
    }
    
    override fun getAllPosts(): SoPostGetResponse {
        return SoPostGetResponse(soPostRepository.findAll().map { SoPostResponseItem.fromSoPost(it) })
    }
    
    override fun deletePost(id: Long) {
        try {
            soPostRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw NoDataFoundException()
        }
    }
}
