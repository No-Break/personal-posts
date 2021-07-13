package study.nobreak.personalposts.so.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import study.nobreak.personalposts.so.domain.SoPost

interface SoPostRepository: JpaRepository<SoPost, Long>, SoPostDslRepository

interface SoPostDslRepository {
    fun findAllByFetchJoinCondition(isHiddenContentIncluded: Boolean, pageable: Pageable): Page<SoPost>
}
