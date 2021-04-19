package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
public interface SmBoardService {
    fun addPost(smBoard: SmBoard): SmBoard

}