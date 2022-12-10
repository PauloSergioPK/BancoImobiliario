package data.repository

import domain.model.colors.GameColor
import domain.model.gameboard.Gameboard
import domain.model.gameboard.GameboardHouse
import domain.model.gameboard.GameboardHouseKind
import domain.repository.GameboardRepository

class GameboardRepositoryImpl : GameboardRepository {
    override fun getInitialGameboard(): Gameboard {
        return Gameboard(
            currentTurnPlayer = null,
            houses = listOf(
                GameboardHouse(kind = GameboardHouseKind.Start(bonus = 200F)),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Leblon", 100F, GameColor.LIGHT_PURPLE)),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Av. Presidente Vargas",
                        60F,
                        GameColor.LIGHT_PURPLE
                    )
                ),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Av. Nossa S. De Copacabana",
                        60F,
                        GameColor.LIGHT_PURPLE
                    )
                ),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia Ferroviária",
                        200F,
                        GameColor.LIGHT_PURPLE
                    )
                ),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Av. Brigadeiro Fária Lima",
                        240F,
                        GameColor.LIGHT_BLUE
                    )
                ),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de viação",
                        200F,
                        GameColor.LIGHT_BLUE
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Rebouças", 220F, GameColor.LIGHT_BLUE)),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Av. 9 de julho",
                        220F,
                        GameColor.LIGHT_BLUE
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Jail),

                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Europa", 200F, GameColor.DARK_PURPLE)),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Rua Augusta", 180F, GameColor.DARK_PURPLE)),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Pacaembú", 180F, GameColor.DARK_PURPLE)),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de Táxi",
                        150F,
                        GameColor.DARK_PURPLE
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Interlagos", 350F, GameColor.ORANGE)),
                GameboardHouse(kind = GameboardHouseKind.Profits(200F)),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Morumbi", 400F, GameColor.ORANGE)),
                GameboardHouse(kind = GameboardHouseKind.Vacation),

                GameboardHouse(kind = GameboardHouseKind.Property(title = "Flamengo", 120F, GameColor.RED)),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Botafogo", 320F, GameColor.RED)),
                GameboardHouse(kind = GameboardHouseKind.Tax(200F)),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de navegação",
                        150F,
                        GameColor.YELLOW
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Brasil", 160F, GameColor.YELLOW)),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Paulista", 140F, GameColor.YELLOW)),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Jardim Europa", 140F, GameColor.YELLOW)),

                GameboardHouse(kind = GameboardHouseKind.GoToJail),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Copacabana", 260F, GameColor.GREEN)),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de aviação",
                        200F,
                        GameColor.GREEN
                    )
                ),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de aviação",
                        200F,
                        GameColor.GREEN
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Vieira Souto", 320F, GameColor.GREEN)),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Av. Atlântica", 300F, GameColor.GREEN)),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Companhia de táxi aério",
                        200F,
                        GameColor.GREEN
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Ipanema", 300F, GameColor.GREEN)),
                GameboardHouse(kind = GameboardHouseKind.LuckyOrUnlucky),
                GameboardHouse(
                    kind = GameboardHouseKind.Property(
                        title = "Jardim Paulista",
                        280F,
                        GameColor.DARK_BLUE
                    )
                ),
                GameboardHouse(kind = GameboardHouseKind.Property(title = "Brooklin", 260F, GameColor.DARK_BLUE)),
            )
        )
    }
}