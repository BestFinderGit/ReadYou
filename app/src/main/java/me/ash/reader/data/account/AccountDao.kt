package me.ash.reader.data.account

import androidx.room.*

@Dao
interface AccountDao {
    @Query(
        """
        SELECT * FROM account
        """
    )
    suspend fun queryAll(): List<Account>


    @Query(
        """
        SELECT * FROM account
        WHERE id = :id
        """
    )
    suspend fun queryById(id: Int): Account

    @Insert
    suspend fun insert(account: Account): Long

    @Insert
    suspend fun insertList(accounts: List<Account>): List<Long>

    @Update
    suspend fun update(vararg account: Account)

    @Delete
    suspend fun delete(vararg account: Account)
}