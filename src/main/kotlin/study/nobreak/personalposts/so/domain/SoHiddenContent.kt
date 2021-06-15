package study.nobreak.personalposts.so.domain

import javax.persistence.*

@Entity
class SoHiddenContent(
    @Id
    @OneToOne
    @JoinColumn(name="post_id")
    val post: SoPost,
    val question: String,
    val answer: String,
    val content: String
)
