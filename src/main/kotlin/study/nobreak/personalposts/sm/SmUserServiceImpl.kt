package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component
import org.springframework.ui.Model
import java.security.MessageDigest
import javax.servlet.http.HttpSession

@Component
class SmUserServiceImpl(val userRepository: UserRepository):SmUserService {


    override fun addUser(userId:String,password:String){

        val cryptoPass: String = crypto(password)
        val user = userRepository.save(SmUser(userId, cryptoPass))

    }

    override fun checkSmUser(model: Model, session: HttpSession, userId:String, password:String):String{

        val cryptoPass: String = crypto(password)
        val user = userRepository.findByUserId(userId);

        if (user != null) {
            val user_pass = user.password
            if (cryptoPass.equals(user_pass)) {
                session.setAttribute("userId", user.userId)
                model.addAttribute("title", "Welcome")
                model.addAttribute("userId", userId)
                return "complete"
            }
        }
        return "faile"
    }

    fun crypto(ss: String): String {
        val sha = MessageDigest.getInstance("SHA-256")
        val hexa = sha.digest(ss.toByteArray())
        val crypto_str = hexa.fold("", { str, it -> str + "%02x".format(it) })
        return crypto_str
    }
}