package study.nobreak.personalposts.so.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class SoUser(
    @Id
    private val id: Long,
    private val name: String
)
