package study.nobreak.personalposts.sm.repository

import org.springframework.data.repository.CrudRepository
import study.nobreak.personalposts.sm.SmBoard

interface BoardRepository : CrudRepository<SmBoard, Int> {
    fun findByBoardId(boardId: String): SmBoard

}