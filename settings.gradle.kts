pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StructureofProjects"
include(":app")
include(":features:account")
include(":features:product")
include(":entities")
include(":data")
include(":domain")
include(":network")
include(":common")
include(":features:flights")
