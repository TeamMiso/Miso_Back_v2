package andreas311.miso.domain.user.domain

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority(): String = name
}