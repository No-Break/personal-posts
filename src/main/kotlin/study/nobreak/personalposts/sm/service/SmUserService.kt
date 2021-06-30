package study.nobreak.personalposts.sm.service

import org.springframework.stereotype.Component
import study.nobreak.personalposts.sm.domain.SmUser

@Component
interface SmUserService {

    fun addUser(userId: String, password: String): SmUser
    fun checkUser(userId: String, password: String): SmUser

}