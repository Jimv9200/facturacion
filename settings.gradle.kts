rootProject.name = "facturacion"
include("persistencia")
include("persistencia:persistence")
findProject(":persistencia:persistence")?.name = "persistence"
