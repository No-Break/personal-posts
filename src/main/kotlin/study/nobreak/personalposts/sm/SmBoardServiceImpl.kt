package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
class SmBoardServiceImpl(var boardRepositories: BoardRepositories) : SmBoardService {

    override fun boardSave(smBoard: SmBoard): SmBoard {
        val board = boardRepositories.save(smBoard)
        return board
    }

}