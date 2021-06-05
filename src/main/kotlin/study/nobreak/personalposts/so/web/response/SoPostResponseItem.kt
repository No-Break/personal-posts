package study.nobreak.personalposts.so.web.response

import study.nobreak.personalposts.so.domain.SoPost

data class SoPostResponseItem(
    val id: Long,
    val title: String,
    val content: String
) {
    companion object {
        fun fromSoPost(soPost: SoPost): SoPostResponseItem {
            return SoPostResponseItem(soPost.id!!, soPost.title, soPost.content)
        }
    }
}
