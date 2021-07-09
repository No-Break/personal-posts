package study.nobreak.personalposts.so.repository

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import study.nobreak.personalposts.so.domain.QSoPost
import study.nobreak.personalposts.so.domain.SoPost

@Repository
class SoPostDslRepositoryImpl: SoPostDslRepository, QuerydslRepositorySupport(SoPost::class.java) {
    private val soPost: QSoPost = QSoPost.soPost
    
    override fun findAllByFetchJoinCondition(isHiddenContentIncluded: Boolean): List<SoPost> {
        return if (isHiddenContentIncluded) {
            from(soPost)
                .leftJoin(soPost.hiddenContent).fetchJoin()
                .fetch()
        } else {
            from(soPost).fetch()
        }
    }
}
