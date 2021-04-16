package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
public interface SmBoardService {
    fun boardSave(smBoard: SmBoard): SmBoard

}