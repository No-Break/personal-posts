package study.nobreak.personalposts.sm

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.security.MessageDigest
import javax.servlet.http.HttpSession

//json형태를 반환해주는 컨트롤
@RestController
class SmController(val userRepository: UserRepository) {

    // create user
    @GetMapping("/sign")
    fun addSmUser(
        model: Model,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ) {

        val cryptoPass: String = crypto(password)
        val user = userRepository.save(SmUser(userId, cryptoPass))

        println("result: $user")
        //return ""
    }

    fun crypto(ss: String): String {
        val sha = MessageDigest.getInstance("SHA-256")
        val hexa = sha.digest(ss.toByteArray())
        val crypto_str = hexa.fold("", { str, it -> str + "%02x".format(it) })
        return crypto_str
    }

    //check user
    @GetMapping("/login")
    fun checkSmUser(
        model: Model,
        session: HttpSession,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ): String {
            val cryptoPass = crypto(password)
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

        return "failed"
    }
}