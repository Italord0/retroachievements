package di

import domain.repository.game.GameRepository
import domain.repository.game.GameRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val gameModule = module {
    factoryOf(::GameRepositoryImpl) { bind<GameRepository>() }
}