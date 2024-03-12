package andreas311.miso.domain.email.domain

data class Email(
    val id: Long,
    val email: String,
    var randomKey: String,
    var authentication: Boolean
) {
    fun updateAuthentication(authentication: Boolean) {
        this.authentication = authentication
    }
}
