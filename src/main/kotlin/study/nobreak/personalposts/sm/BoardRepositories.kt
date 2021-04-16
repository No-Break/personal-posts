package study.nobreak.personalposts.sm

import org.springframework.data.repository.CrudRepository

interface BoardRepositories : CrudRepository<SmBoard, Int> {
    fun findByBoardId(boardId: String): SmBoard

}