package study.nobreak.personalposts.so.repository

import com.querydsl.jpa.JPQLQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

fun <T> JPQLQuery<T>.fetchPage(pageable: Pageable): Page<T> {
    return this
        .offset(pageable.offset)
        .limit(pageable.pageSize.toLong())
        .let {
            PageImpl(it.fetch(), pageable, it.fetchCount())
        }
}
