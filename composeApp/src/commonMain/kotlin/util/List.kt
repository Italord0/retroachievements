package util

import data.model.System

fun List<System>.filterSystems(): List<System> {
    val validIds = setOf(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 17, 18, 21,
        23, 24, 25, 26, 27, 28, 29, 33, 34,
        37, 38, 39, 40, 41, 43, 44, 45, 46,
        47, 49, 51, 53, 56, 57, 63, 69, 71,
        72, 73, 74, 75, 76, 77, 78, 80, 102
    )

    return this.filter { it.id in validIds }
}