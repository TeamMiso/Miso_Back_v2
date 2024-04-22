package andreas311.miso.domain.item.application.port.output

import andreas311.miso.domain.item.domain.Item

interface QueryItemPort {
    fun findByIdOrNull(id: Long): Item?

    fun findAll(): List<Item>
}