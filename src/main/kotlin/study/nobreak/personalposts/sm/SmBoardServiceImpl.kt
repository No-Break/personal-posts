package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
class SmBoardServiceImpl(var boardRepository: BoardRepository) : SmBoardService {

    override fun boardSave(smBoard: SmBoard): SmBoard {
        return boardRepository.save(smBoard)
    }

}