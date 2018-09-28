package com.kitwtnb.droidkaigi2018contributors.datastore.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.datastore.data.ContributorEntity
import kotlinx.coroutines.experimental.async

@Dao
interface ContributorDao {
    @Query("SELECT * FROM contributor where owner = :owner and repository = :repository ORDER BY contributions DESC")
    fun fetchBy(owner: String, repository: String): List<ContributorEntity>

    @Insert
    fun insert(contributors: List<ContributorEntity>)

    @Query("DELETE FROM contributor")
    fun delete()

    @Query("DELETE FROM contributor where owner = :owner and repository = :repository")
    fun deleteBy(owner: String, repository: String)

    @Transaction
    fun replaceBy(owner: String, repository: String, contributors: List<Contributor>) {
        deleteBy(owner, repository)
        insert(contributors.map { ContributorEntity(owner, repository, it) })
    }
}

fun ContributorDao.deferredFetchBy(owner: String, repository: String) = async { fetchBy(owner, repository) }
fun ContributorDao.deferredInsert(contributors: List<ContributorEntity>) = async { insert(contributors) }
fun ContributorDao.deferredDelete() = async { delete() }
fun ContributorDao.deferredDeleteBy(owner: String, repository: String) = async { deleteBy(owner, repository) }
fun ContributorDao.deferredReplace(owner: String, repository: String, contributors: List<Contributor>) = async { replaceBy(owner, repository, contributors) }
