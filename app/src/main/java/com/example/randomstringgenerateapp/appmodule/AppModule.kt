package com.example.randomstringgenerateapp.appmodule

import android.content.ContentResolver
import android.content.Context
import com.example.randomstringgenerateapp.repository.RandomStringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContentResolver(@ApplicationContext context: Context): ContentResolver {
        return context.contentResolver
    }

    @Provides
    fun provideRandomStringRepository(contentResolver: ContentResolver): RandomStringRepository {
        return RandomStringRepository(contentResolver)
    }
}
