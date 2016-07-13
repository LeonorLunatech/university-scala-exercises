lazy val tweets = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

scalaVersion := "2.11.8"

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import default.tweets._
                      |""".stripMargin
