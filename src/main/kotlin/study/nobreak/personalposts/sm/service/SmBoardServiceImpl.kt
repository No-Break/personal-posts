package study.nobreak.personalposts.sm.service

import org.springframework.stereotype.Component
import study.nobreak.personalposts.sm.SmBoard
import study.nobreak.personalposts.sm.repository.BoardRepository

@Component
class SmBoardServiceImpl(var boardRepository: BoardRepository) : SmBoardService {

    override fun addPost(smBoard: SmBoard): SmBoard {
        return boardRepository.save(smBoard)
    }

    override fun getPost(): List<SmBoard> {
        return boardRepository.findAll()
    }

    override fun getUserPost(userId: String): List<SmBoard> {
        return boardRepository.findByUserId(userId)
    }
}
