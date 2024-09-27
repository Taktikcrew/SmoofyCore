rootProject.name = "SmoofyCore"
include("core-api")
include("core-base")
include("core-abstraction:adapter-1_8")
findProject(":core-abstraction:adapter-1_8")?.name = "adapter-1_8"
include("core-cloud:adapter-polocloud")
findProject(":core-cloud:adapter-polocloud")?.name = "adapter-polocloud"
