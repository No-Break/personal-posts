package study.nobreak.personalposts.so.service

import study.nobreak.personalposts.so.web.response.SoPostGetResponse

interface SoPostService {
    fun addPost(title: String, content: String)
    fun getAllPosts(): SoPostGetResponse
    fun deletePost(id: Long)
}
