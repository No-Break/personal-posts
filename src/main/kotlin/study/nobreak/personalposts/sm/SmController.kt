package study.nobreak.personalposts.sm

import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import study.nobreak.personalposts.sm.service.SmUserService
import javax.servlet.http.HttpSession

//json형태를 반환해주는 컨트롤
@RestController
class SmController(var smUserService: SmUserService) {

    // create user
    @ResponseBody
    @PostMapping("/sign")
    fun addSmUser(
        model: Model,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ): ResponseEntity<Any> {
        return ResponseEntity.ok().body(smUserService.addUser(userId, password))
    }

    //check user
    @PostMapping("/login")
    fun checkSmUser(
        model: Model,
        session: HttpSession,
        @RequestParam(value = "id") userId: String,
        @RequestParam(value = "password") password: String
    ): ResponseEntity<SmUser> {

        val user = smUserService.checkUser(userId, password)
        session.setAttribute("userId", user.userId)
        model.addAttribute("title", "Welcome")
        model.addAttribute("userId", userId)

        return ResponseEntity.ok().body(user)
    }

}