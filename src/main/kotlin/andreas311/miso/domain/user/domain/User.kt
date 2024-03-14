package andreas311.miso.domain.user.domain

import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val password: String,
    var point: Int,
    val role: MutableList<Role>
) {
    fun addPoint(point: Int): User {
        synchronized(this) {
            this.point += point
        }
        return this
    }

    fun removePoint(point: Int): User {
        synchronized(this) {
            this.point -= point
        }
        return this
    }
}
