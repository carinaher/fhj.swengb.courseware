package fhj.swengb.courseware

import java.sql.{Connection,DriverManager,ResultSet}
import scala.util.Try


object DB {
  trait DBEntity[T] {
    def fromDB(rs: ResultSet): List[T]
    def query(c: Connection)(q: String): ResultSet = c.createStatement().executeQuery(q)
  }

  val repopath:String = new java.io.File(".").getCanonicalPath
  val db: String = repopath  + "/fhj.swengb.courseware/src/main/resources/fhj/swengb/courseware/exampledb.sqlite"

  lazy val maybeConnection: Try[Connection] = Try(DriverManager.getConnection("jdbc:sqlite:" + db))

}
