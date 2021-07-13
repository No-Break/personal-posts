package study.nobreak.personalposts.so.web.request

data class SoPostGetRequest(
    val isQuestionIncluded: Boolean = false,
    override val pageNumber: Int = 1,
    override val pageSize: Int = 10
): SoPageRequest
