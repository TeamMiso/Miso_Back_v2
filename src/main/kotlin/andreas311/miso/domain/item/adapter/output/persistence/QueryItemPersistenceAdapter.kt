package andreas311.miso.domain.item.adapter.output.persistence

import andreas311.miso.domain.item.adapter.output.persistence.mapper.ItemMapper
import andreas311.miso.domain.item.adapter.output.persistence.repository.ItemRepository
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import andreas311.miso.domain.item.domain.Item
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class QueryItemPersistenceAdapter(
    private val itemMapper: ItemMapper,
    private val itemRepository: ItemRepository
): QueryItemPort {
    override fun findByIdOrNull(id: Long): Item? {
        val itemEntity = itemRepository.findByIdOrNull(id)
        return itemMapper.toDomain(itemEntity)
    }

    override fun findAll(): List<Item> {
        val itemList = itemRepository.findAllByOrderByPriceAsc()
        return itemList.map { itemMapper.toDomain(it)!! }
    }
}