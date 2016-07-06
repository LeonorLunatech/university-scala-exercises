lazy val errors = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

maxErrors := 3

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import default.errors._
                      |""".stripMargin
