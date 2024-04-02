package andreas311.miso.domain.recyclables.adapter.output.persistence.repository.impl

import andreas311.miso.domain.recyclables.adapter.output.persistence.entity.QRecyclablesEntity.recyclablesEntity
import andreas311.miso.domain.recyclables.adapter.output.persistence.entity.RecyclablesEntity
import andreas311.miso.domain.recyclables.adapter.output.persistence.repository.RecyclablesRepositoryCustom
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils.hasText

@Repository
class RecyclablesRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : RecyclablesRepositoryCustom {
    override fun search(searchValue: String): RecyclablesEntity? {
        return jpaQueryFactory
            .selectFrom(recyclablesEntity)
            .where(subTitleLike(searchValue))
            .fetchFirst()
    }

    private fun subTitleLike(subTitle: String): BooleanExpression? =
        if(hasText(subTitle)) recyclablesEntity.subTitle.like("%${subTitle}%") else null
}