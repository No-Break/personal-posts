package study.nobreak.personalposts.so.service

import study.nobreak.personalposts.so.domain.SoPost

interface SoPostService {
    fun addPost(title: String, content: String)
    fun getAllPosts(): List<SoPost>
    fun deletePost(id: Long)
    fun addHiddenContent(postId: Long, question: String, answer: String, content: String)
}
