package di

import data.RetroachievementsAPI
import data.RetroachievementsAPIImpl
import org.koin.dsl.module

val sharedModule = module {
    factory<RetroachievementsAPI> {
        RetroachievementsAPIImpl()
    }
}
