package study.nobreak.personalposts.so.domain

import javax.persistence.*

@Entity
class SoHiddenContent(
    @Id
    val postId: Long? = null,
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    val post: SoPost,
    val question: String,
    val answer: String,
    val content: String
)
