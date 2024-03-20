package andreas311.miso.domain.item.adapter.output.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "item")
data class ItemEntity(
    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "price", nullable = false)
    val price: Int,

    @Column(name = "amount", nullable = false)
    var amount: Int,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "content", nullable = false)
    val content: String,

    @Column(name = "image_url", nullable = true)
    val imageUrl: String?
)
