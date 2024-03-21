package andreas311.miso.domain.item.adapter.output.persistence

import andreas311.miso.domain.item.adapter.output.persistence.mapper.ItemMapper
import andreas311.miso.domain.item.adapter.output.persistence.repository.ItemRepository
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.domain.Item
import org.springframework.stereotype.Component

@Component
class CommandItemPersistenceAdapter(
    private val itemMapper: ItemMapper,
    private val itemRepository: ItemRepository
): CommandItemPort {
    override fun saveItem(item: Item): Item {
        val itemEntity = itemRepository.save(itemMapper toEntity item)
        return itemMapper.toDomain(itemEntity)!!
    }

    override fun deleteItem(item: Item) {
        val itemEntity = itemMapper toEntity item
        return itemRepository.delete(itemEntity)
    }
}