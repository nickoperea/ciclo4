package com.nickoperea.inventariapp.data.mockups

import com.nickoperea.inventariapp.data.models.Comment
import java.util.*

class CommentMock {
    fun loadData(): List<Comment> {
        return listOf(
            Comment(
                1,
                "Excelente",
                "Camilo",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                2,
                "Producto perfecto",
                "Andres",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                3,
                "Cumplió con lo prometido!",
                "Carkis",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                4,
                "Creo que le faltó un proceso mas de calidad",
                "Raúl",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                5,
                "No me gustó",
                "Sandra",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                6,
                "Se me hizo muy caro",
                "José",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                7,
                "Recomendado!",
                "Pedro",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                8,
                "Se dañó después del primer uso",
                "Maria",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                9,
                "Tuve que esperar mucho para que llegara",
                "Catalina",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            ),
            Comment(
                10,
                "me autodeclaro fanático del producto!",
                "Christian",
                "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                Calendar.getInstance()
            )
        )
    }
}