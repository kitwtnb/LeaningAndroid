package com.kitwtnb.droidkaigi2018contributors.datastore.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import kotlinx.coroutines.experimental.async

@Dao
interface ContributorDao {
    @Query("SELECT * FROM contributor ORDER BY contributions DESC")
    fun fetch(): List<Contributor>

    @Insert
    fun insert(contributors: List<Contributor>)

    @Query("DELETE FROM contributor")
    fun delete()

    @Transaction
    fun replace(contributors: List<Contributor>) {
        delete()
        insert(contributors)
    }
}

fun ContributorDao.deferredFetch() = async { fetch() }
fun ContributorDao.deferredInsert(contributors: List<Contributor>) = async { insert(contributors) }
fun ContributorDao.deferredDelete() = async { delete() }
fun ContributorDao.deferredReplace(contributors: List<Contributor>) = async { replace(contributors) }
