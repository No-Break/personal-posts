package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
interface SmUserService {

    fun addUser(userId: String, password: String): SmUser
    fun checkUser(userId: String, password: String): SmUser

}