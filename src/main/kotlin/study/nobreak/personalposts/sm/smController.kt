package study.nobreak.personalposts.sm

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.security.MessageDigest
import javax.servlet.http.HttpSession

//json형태를 반환해주는 컨트롤
@RestController
class smController {

    //스프링에서 bean을 자동으로 관리
    @Autowired
    lateinit var repository:UserRepository

    @RequestMapping("/")
    //fun hello(): String = "hello world"
    fun index(model: Model):String{
        //html에서 {{ key }} 변수처리 값
        val addAttribute = model.addAttribute("Key", "Value")
        return "index"
    }
    //mustache 에서 mapping 작업을 해준다
    //@GetMapping("/{formType}")
    //fun htmlForm(model:Model,@PathVariable formType:String):String{
    @GetMapping("/find")
    fun htmlForm(model:Model):String{
        //html에서 인터페이스된 값
        //formType.equals("html 폼태그 value");
        return "find"
    }
    // create user
    @GetMapping("/sign")
    fun addSmUser(model:Model,
                 @RequestParam(value="id") userId:String,
                 @RequestParam(value="password") password:String){

        try{
            var cryptoPass = crypto(password)
            var user = repository.save(smUser(userId,cryptoPass))
            println("result: "+user.toString())
        }catch(e:Exception){
            e.printStackTrace()
        }
        //return ""
    }
    fun crypto(ss:String):String{
        val sha = MessageDigest.getInstance("SHA-256")
        val hexa = sha.digest(ss.toByteArray())
        val crypto_str = hexa.fold("",{str,it -> str + "%02x".format(it)})
        return crypto_str
    }
    //check user
    @GetMapping("/login")
    fun checkSmUser(model:Model,
                    session:HttpSession,
                    @RequestParam(value="id") userId:String,
                    @RequestParam(value="password") password:String):String{
        try{
            val cryptoPass = crypto(password)
            val user = repository.findByUserId(userId);
            if(user != null){
                val user_pass = user.password
                if(cryptoPass.equals(user_pass)){
                    session.setAttribute("userId",user.userId)
                    model.addAttribute("title","Welcome")
                    model.addAttribute("userId",userId)
                    return "complete"
                }
            }
        }catch(e:Exception){
            e.printStackTrace()
        }

        return "failed"
    }
}