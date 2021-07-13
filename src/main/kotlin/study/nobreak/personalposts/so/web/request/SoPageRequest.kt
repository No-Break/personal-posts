package study.nobreak.personalposts.so.web.request

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

interface SoPageRequest {
    val pageNumber: Int
    val pageSize: Int
    
    fun toPageable(): Pageable {
        return PageRequest.of(pageNumber - 1, pageSize)
    }
}
