package study.nobreak.personalposts.sm

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

//json형태를 반환해주는 컨트롤
@RestController
class SmController(var smUserService: SmUserService) {

    // create user
    @GetMapping("/sign")
    fun addSmUser(
        model: Model,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ) {

        val user = smUserService.addUser(userId,password)
        println("result: $user")
        //return ""
    }

    //check user
    @GetMapping("/login")
    fun checkSmUser(
        model: Model,
        session: HttpSession,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ): String {
        smUserService.checkSmUser(model,session,userId,password)
        return "failed"
    }
}