package co.novu.dto

import jdk.jfr.Enabled

data class Preference(
    var enabled: Boolean,
    var channels: Any?
)
