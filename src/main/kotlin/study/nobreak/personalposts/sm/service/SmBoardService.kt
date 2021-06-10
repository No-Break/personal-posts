package study.nobreak.personalposts.sm.service

import org.springframework.stereotype.Component
import study.nobreak.personalposts.sm.SmBoard

@Component
public interface SmBoardService {
    fun addPost(smBoard: SmBoard): SmBoard

}