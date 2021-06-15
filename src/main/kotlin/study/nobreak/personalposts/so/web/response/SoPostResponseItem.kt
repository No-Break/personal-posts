package study.nobreak.personalposts.so.web.response

import study.nobreak.personalposts.so.domain.SoPost

data class SoPostResponseItem(
    val id: Long,
    val title: String,
    val content: String,
    val hiddenContentQuestion: String
) {
    companion object {
        fun fromSoPost(soPost: SoPost): SoPostResponseItem {
            return SoPostResponseItem(
                id = soPost.id!!,
                title = soPost.title,
                content = soPost.content,
                hiddenContentQuestion = soPost.hiddenContent?.question ?: ""
            )
        }
    }
}
