lazy val updates = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

initialCommands := """|import default.updates._
                      |com.timushev.sbt
                      |""".stripMargin

libraryDependencies ++= Seq( "joda-time" % "joda-time"    % "2.2",
                             "org.joda"  % "joda-convert" % "1.4")