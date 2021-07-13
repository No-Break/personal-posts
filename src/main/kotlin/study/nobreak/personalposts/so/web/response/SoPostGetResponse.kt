package study.nobreak.personalposts.so.web.response

data class SoPostGetResponse(
    override val content: List<SoPostResponseItem>,
    override val totalPages: Int,
    override val totalElements: Long
): SoPageResponse<SoPostResponseItem>
