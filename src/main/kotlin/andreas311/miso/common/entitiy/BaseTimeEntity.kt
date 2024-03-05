package andreas311.miso.common.entitiy

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(
    @CreatedDate
    @Column(updatable = false)
    val createdDate: LocalDateTime = LocalDateTime.now()
)