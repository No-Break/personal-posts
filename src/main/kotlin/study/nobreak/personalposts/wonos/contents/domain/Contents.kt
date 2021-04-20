package study.nobreak.personalposts.wonos.contents.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Column
//import javax.validation.constraints.NotBlank

@Entity
@Table(schema = "posts", name = "contents")
data class Contents(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,

    @Column(name = "title")
    var title: String = "",

    @Column(name = "mainText")
    var mainText: String = "",

    @Column(name = "writer")
    var writer: String = ""
)

