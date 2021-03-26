package study.nobreak.personalposts.sm

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class smUser(
    var userId:String,
    var password:String,
    @Id @GeneratedValue var id:Long?=null)
