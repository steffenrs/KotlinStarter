package pkg.db

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", length = 50)
}