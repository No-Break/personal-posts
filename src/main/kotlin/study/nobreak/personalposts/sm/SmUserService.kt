package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component

@Component
interface SmUserService {

    fun addUser(userId: String, password: String)
    fun checkUser(userId: String, password: String): SmUser

}