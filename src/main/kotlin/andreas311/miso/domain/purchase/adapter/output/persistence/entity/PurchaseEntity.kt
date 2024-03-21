package andreas311.miso.domain.purchase.adapter.output.persistence.entity

import andreas311.miso.common.entitiy.BaseTimeEntity
import andreas311.miso.domain.item.adapter.output.persistence.entity.ItemEntity
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import javax.persistence.*

@Entity
@Table(name = "purchase")
data class PurchaseEntity(
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "item_id")
    val item: ItemEntity,
): BaseTimeEntity()
