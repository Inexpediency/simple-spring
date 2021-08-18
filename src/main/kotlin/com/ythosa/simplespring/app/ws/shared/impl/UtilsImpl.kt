package com.ythosa.simplespring.app.ws.shared.impl

import com.ythosa.simplespring.app.ws.shared.Utils
import org.springframework.stereotype.Service
import java.util.*

@Service
class UtilsImpl : Utils {
    override fun generateUUID(): String {
        return UUID.randomUUID().toString()
    }
}
