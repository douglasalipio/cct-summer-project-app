package com.douglas.android.garageapp.di

import com.douglas.android.domain.veichle.VehicleRepository
import com.douglas.android.data.VehicleRepositoryImp
import com.douglas.android.data.vehicle.model.VehicleModelToVehicleMapper
import com.douglas.android.domain.veichle.VehicleInteractor
import org.koin.dsl.module.module


val appModule = module {
    //    factory { LinesStatusAdapter() }
//    viewModel { StatusViewModel(get(), get()) }
}

val interactorsModule = module {
    factory { VehicleInteractor(get()) }
}

val repositoryModule = module {
    single<VehicleRepository> { VehicleRepositoryImp(get(), get()) }
}

val mappersModule = module {
    single { VehicleModelToVehicleMapper() }
}