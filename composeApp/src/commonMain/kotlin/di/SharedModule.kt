package di

import data.RetroachievementsAPI
import org.koin.dsl.module

val sharedModule = module {
    single { RetroachievementsAPI }
}