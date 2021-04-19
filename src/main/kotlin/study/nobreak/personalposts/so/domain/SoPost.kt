package study.nobreak.personalposts.so.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class SoPost(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val title: String,
    val content: String
)