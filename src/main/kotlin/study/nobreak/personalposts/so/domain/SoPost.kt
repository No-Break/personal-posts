package study.nobreak.personalposts.so.domain

import study.nobreak.personalposts.so.exception.DataConflictException
import javax.persistence.*

@Entity
data class SoPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
) {
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.PERSIST])
    var hiddenContent: SoHiddenContent? = null
        private set

    fun addHiddenContent(question: String, answer: String, hiddenContent: String): SoHiddenContent {
        if (this.hiddenContent != null) {
            throw DataConflictException()
        }
        this.hiddenContent = SoHiddenContent(
            post = this,
            question = question,
            answer = answer,
            content = hiddenContent
        )
        return this.hiddenContent!!
    }
}
