package study.nobreak.personalposts.so.web.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import study.nobreak.personalposts.so.domain.SoPost

@JsonInclude(value = Include.NON_NULL)
data class SoPostResponseItem(
    val id: Long,
    val title: String,
    val content: String,
    val hiddenContentQuestion: String?
) {
    companion object {
        fun fromSoPost(soPost: SoPost, isQuestionIncluded: Boolean): SoPostResponseItem {
            return SoPostResponseItem(
                id = soPost.id!!,
                title = soPost.title,
                content = soPost.content,
                hiddenContentQuestion = when {
                    isQuestionIncluded.not() -> null
                    soPost.hiddenContent != null -> soPost.hiddenContent!!.question
                    else -> ""
                }
            )
        }
    }
}
