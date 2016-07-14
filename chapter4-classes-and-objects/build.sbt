lazy val `chapter4-classes-and-objects` = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import default.chapter4.classes.and.objects._
                      |""".stripMargin
