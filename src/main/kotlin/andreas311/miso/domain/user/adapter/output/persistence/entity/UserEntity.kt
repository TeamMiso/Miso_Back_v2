package andreas311.miso.domain.user.adapter.output.persistence.entity

import andreas311.miso.domain.user.domain.Role
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "point", nullable = false)
    var point: Int = 0,

    @Enumerated(EnumType.STRING)
    val role: Role
)