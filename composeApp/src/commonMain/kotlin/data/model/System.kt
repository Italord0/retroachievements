package data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class System(
    @SerialName(value = "ID")
    val id: Int,
    @SerialName(value = "Name")
    val name: String
) {
    val imageName: String = when (id) {
        1 -> "md"
        2 -> "n64"
        3 -> "snes"
        4 -> "gb"
        5 -> "gba"
        6 -> "gbc"
        7 -> "nes"
        8 -> "pce"
        9 -> "scd"
        10 -> "32x"
        11 -> "sms"
        12 -> "ps1"
        13 -> "lynx"
        14 -> "ngp"
        17 -> "jag"
        18 -> "ds"
        21 -> "ps2"
        23 -> "mo2"
        24 -> "mini"
        25 -> "2600"
        26 -> "dos"
        27 -> "arc"
        28 -> "vb"
        29 -> "msx"
        33 -> "sg1k"
        34 -> "vic-20"
        37 -> "cpc"
        38 -> "a2"
        39 -> "sat"
        40 -> "dc"
        41 -> "psp"
        43 -> "3do"
        44 -> "cv"
        45 -> "intv"
        46 -> "vect"
        47 -> "8088"
        49 -> "pc-fx"
        51 -> "7800"
        53 -> "ws"
        56 -> "ngcd"
        57 -> "chf"
        63 -> "wsv"
        69 -> "duck"
        71 -> "ard"
        72 -> "wasm4"
        73 -> "a2001"
        74 -> "vc4000"
        75 -> "elek"
        76 -> "pccd"
        77 -> "jcd"
        78 -> "dsi"
        80 -> "uze"
        102 -> "exe"
        else -> "error"
    }
}