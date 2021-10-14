package br.com.jhonatansouza.starbuckets.utils

import org.springframework.stereotype.Component
import org.springframework.util.DigestUtils

@Component
class SecurityComponent {

    fun stringToMd5(content: String): String? {
        return DigestUtils.md5DigestAsHex(content.toByteArray())
    }

}