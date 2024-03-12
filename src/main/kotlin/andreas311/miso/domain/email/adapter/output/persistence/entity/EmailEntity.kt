package andreas311.miso.domain.email.adapter.output.persistence.entity

import andreas311.miso.common.entitiy.BaseIdxEntity
import javax.persistence.*

@Entity
@Table(name = "email")
class EmailEntity(
    @Column(name = "email_id", nullable = false)
    val id: Long,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "random_key", nullable = false)
    var randomKey: String,

    @Column(name = "authentication", nullable = false)
    var authentication: Boolean
): BaseIdxEntity(id)