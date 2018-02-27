package pkg

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import pkg.db.Users

interface UserRepository

@Repository
@Transactional // Should be at @Service level in real applications
class DefaultUserRepository {

    fun createTable() = SchemaUtils.create(Users)

    fun create(m: User): User {
        val t = Users.insert(toRow(m))[Users.id]
        return m
    }

    fun findAll() = Users.selectAll().map { fromRow(it) }

    fun deleteAll() = Users.deleteAll()

    private fun toRow(m: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[name] = m.name
    }

    private fun fromRow(r: ResultRow) =
            User(r[Users.id], r[Users.name])
}