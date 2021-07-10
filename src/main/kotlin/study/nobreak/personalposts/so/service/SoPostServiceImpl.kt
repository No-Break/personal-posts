package study.nobreak.personalposts.so.service

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.nobreak.personalposts.so.domain.SoPost
import study.nobreak.personalposts.so.exception.NoDataFoundException
import study.nobreak.personalposts.so.repository.SoPostRepository

@Service
class SoPostServiceImpl(
    private val soPostRepository: SoPostRepository
): SoPostService {
    override fun addPost(title: String, content: String) {
        soPostRepository.save(SoPost(title = title, content = content))
    }
    
    override fun getAll(isQuestionIncluded: Boolean, pageable: Pageable): Page<SoPost> {
        return soPostRepository.findAllByFetchJoinCondition(isQuestionIncluded, pageable)
    }
    
    override fun deletePost(id: Long) {
        try {
            soPostRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw NoDataFoundException()
        }
    }
    
    @Transactional
    override fun addHiddenContent(postId: Long, question: String, answer: String, content: String) {
        soPostRepository.findById(postId)
            .orElseThrow { throw NoDataFoundException() }
            .addHiddenContent(question, answer, content)
    }
}
