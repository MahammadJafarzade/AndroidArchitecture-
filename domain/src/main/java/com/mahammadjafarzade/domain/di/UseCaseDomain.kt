package com.mahammadjafarzade.domain.di

import com.mahammadjafarzade.data.repository.FlightRepository
import com.mahammadjafarzade.data.repository.FlightRepositoryInterface
import com.mahammadjafarzade.domain.mapper.SearchResponseToUIStateMapper
import com.mahammadjafarzade.domain.usecases.SearchListUseCase
import com.mahammadjafarzade.entities.model.SearchResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDomain {
    @Provides
    @Singleton
    fun provideSearchUseCase(repositoryInterface: FlightRepositoryInterface,
                             mapper:SearchResponseToUIStateMapper) = SearchListUseCase(repositoryInterface, mapper)
}