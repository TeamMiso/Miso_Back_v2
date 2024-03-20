package andreas311.miso.domain.item.domain

data class Item(
    val id: Long,
    val price: Int,
    var amount: Int,
    val name: String,
    val content: String,
    val imageUrl: String?
) {
    fun removeAmount(): Item {
        synchronized(this) {
            this.amount -= 1
            return this
        }
    }
}
