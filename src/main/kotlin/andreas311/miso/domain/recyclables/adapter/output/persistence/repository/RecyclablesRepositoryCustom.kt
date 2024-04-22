package andreas311.miso.domain.recyclables.adapter.output.persistence.repository

import andreas311.miso.domain.recyclables.adapter.output.persistence.entity.RecyclablesEntity

interface RecyclablesRepositoryCustom {
    fun search(searchValue: String): RecyclablesEntity?
}