package kotlininaction.chapter_4

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.ANDROID),
        SiteVisit("/", 21.0, OS.WINDOWS),
        SiteVisit("/products", 12.5, OS.LINUX),
        SiteVisit("/products", 24.65, OS.WINDOWS),
        SiteVisit("/", 63.123, OS.WINDOWS),
    )
}

fun byPath(path: String) = { siteVisit: SiteVisit ->
    siteVisit.path === path
}

fun byOS(os: OS) = { siteVisit: SiteVisit ->
    siteVisit.os === os
}

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate)
    .map(SiteVisit::duration)
    .average()

fun List<SiteVisit>.averageDuration(os: OS) = filter { it.os === os }
    .map{ it.duration }
    .average()

enum class OS {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS,
)

