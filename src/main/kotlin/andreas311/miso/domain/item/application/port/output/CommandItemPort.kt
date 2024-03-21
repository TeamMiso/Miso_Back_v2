package andreas311.miso.domain.item.application.port.output

import andreas311.miso.domain.item.domain.Item

interface CommandItemPort {
    fun saveItem(item: Item): Item

    fun deleteItem(item: Item)
}