package andreas311.miso.domain.item.adapter.output.persistence.repository

import andreas311.miso.domain.item.adapter.output.persistence.entity.ItemEntity
import org.springframework.data.repository.CrudRepository

interface ItemRepository: CrudRepository<ItemEntity, Long> {
}