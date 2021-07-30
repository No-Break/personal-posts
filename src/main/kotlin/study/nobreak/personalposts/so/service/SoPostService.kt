package study.nobreak.personalposts.so.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import study.nobreak.personalposts.so.domain.SoPost

interface SoPostService {
    fun addPost(authorId: Long, title: String, content: String)
    fun getAll(isQuestionIncluded: Boolean, pageable: Pageable): Page<SoPost>
    fun deletePost(id: Long)
    fun addHiddenContent(postId: Long, question: String, answer: String, content: String)
}
