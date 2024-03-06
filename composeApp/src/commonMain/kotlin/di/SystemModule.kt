package di

import domain.repository.system.SystemRepository
import domain.repository.system.SystemRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import view.systemDetail.SystemDetailScreenModel
import view.systems.SystemsScreenModel

val systemModule = module {
    factoryOf(::SystemRepositoryImpl) { bind<SystemRepository>() }
    factory { SystemsScreenModel(get()) }
    factory { SystemDetailScreenModel(get()) }
}