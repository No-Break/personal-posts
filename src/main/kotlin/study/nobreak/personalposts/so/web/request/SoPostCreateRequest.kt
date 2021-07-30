package study.nobreak.personalposts.so.web.request

data class SoPostCreateRequest(
    val authorId: Long,
    val title: String,
    val content: String
)
