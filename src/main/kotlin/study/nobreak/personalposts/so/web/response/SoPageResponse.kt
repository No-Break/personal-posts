package study.nobreak.personalposts.so.web.response

interface SoPageResponse<T> {
    val content: List<T>
    val totalPages: Int
    val totalElements: Long
}
