package study.nobreak.personalposts.so.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import study.nobreak.personalposts.so.domain.QSoPost
import study.nobreak.personalposts.so.domain.SoPost

@Repository
class SoPostDslRepositoryImpl: SoPostDslRepository, QuerydslRepositorySupport(SoPost::class.java) {
    private val soPost: QSoPost = QSoPost.soPost
    
    override fun findAllByFetchJoinCondition(isHiddenContentIncluded: Boolean, pageable: Pageable): Page<SoPost> {
        return from(soPost)
            .let { if (isHiddenContentIncluded) it.leftJoin(soPost.hiddenContent).fetchJoin() else it }
            .fetchPage(pageable)
    }
}
