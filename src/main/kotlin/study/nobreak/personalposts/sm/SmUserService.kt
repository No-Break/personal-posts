package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component
import org.springframework.ui.Model
import javax.servlet.http.HttpSession

@Component
interface SmUserService {

    fun addUser(userId:String,password:String)
    fun checkSmUser(model:Model,session:HttpSession,userId:String,password:String):String

}