package study.nobreak.personalposts.sm.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.nobreak.personalposts.sm.SmBoard

interface BoardRepository : JpaRepository<SmBoard, Int> {
    fun findByBoardId(boardId: String): SmBoard
    fun findByUserId(UserId: String): List<SmBoard>

}