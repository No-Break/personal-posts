package study.nobreak.personalposts.so.domain

import study.nobreak.personalposts.so.exception.DataConflictException
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class SoPost(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val title: String,
    val content: String,
) {
    @OneToOne
    var hiddenContent: SoHiddenContent? = null
        private set
    
    fun addHiddenContent(question: String, answer: String, hiddenContent: String): SoHiddenContent {
        if (this.hiddenContent != null) {
            throw DataConflictException()
        }
        return SoHiddenContent(this, question, answer, hiddenContent)
            .also { this.hiddenContent = it }
    }
}
