package andreas311.miso.domain.purchase.adapter.output.persistence.repository

import andreas311.miso.domain.purchase.adapter.output.persistence.entity.PurchaseEntity
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<PurchaseEntity, Long>