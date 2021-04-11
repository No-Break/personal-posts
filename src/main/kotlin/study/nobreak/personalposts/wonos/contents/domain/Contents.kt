package study.nobreak.personalposts.wonos.contents.domain

import javax.persistence.*

@Entity
@Table(schema = "posts", name = "contents")
data class Contents(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int? = null) {
    @Column(name = "title")
    var title: String = "",
    @Column(name = "mainText")
    var mainText: String = "",
    @Column(name = "writer")
    var writer: String = ""
}
