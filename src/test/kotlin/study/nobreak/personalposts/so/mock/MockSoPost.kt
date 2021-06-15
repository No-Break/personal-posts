package study.nobreak.personalposts.so.mock

import study.nobreak.personalposts.so.domain.SoPost

fun mockSoPost(
    id: Long,
    title: String = "mock-title",
    content: String = "mock-content",
    hiddenContent: String? = null,
    question: String? = null,
    answer: String? = null
): SoPost {
    return SoPost(id, title, content)
        .apply {
            if ((hiddenContent == null && question == null && answer == null).not()) {
                this.addHiddenContent(
                    question = question ?: "",
                    answer = answer ?: "",
                    hiddenContent = hiddenContent ?: ""
                )
            }
        }
}
