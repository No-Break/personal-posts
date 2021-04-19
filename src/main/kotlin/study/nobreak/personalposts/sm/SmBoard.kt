package study.nobreak.personalposts.sm

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class SmBoard(
    var userId: String,
    var boardTitle: String,
    var boardDesc: String,
    var boardLev: Int,
    @Id @GeneratedValue var boardId: Int? = null
)
