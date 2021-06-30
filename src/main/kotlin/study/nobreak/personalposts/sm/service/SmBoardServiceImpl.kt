package study.nobreak.personalposts.sm.service

import org.springframework.stereotype.Component
import study.nobreak.personalposts.sm.repository.BoardRepository
import study.nobreak.personalposts.sm.domain.SmBoard

@Component
class SmBoardServiceImpl(var boardRepository: BoardRepository) : SmBoardService {

    override fun addPost(smBoard: SmBoard): SmBoard {
        return boardRepository.save(smBoard)
    }

}