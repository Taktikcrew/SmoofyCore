rootProject.name = "SmoofyCore"
include("core-api")
include("core-base")
include("core-cloud:adapter-polocloud")
findProject(":core-cloud:adapter-polocloud")?.name = "adapter-polocloud"
include("core-example")
