package com.nickoperea.inventariapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.nickoperea.inventariapp.R
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.data.models.StoreInfo
import com.nickoperea.inventariapp.databinding.ActivitySplashBinding
import com.nickoperea.inventariapp.ui.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadInformation()

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        binding.splashAnimation.startAnimation(animation)
        val intent = Intent(this, MainActivity::class.java)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }

    private fun loadInformation() {
        splashViewModel.loadInformation(
            StoreInfo(
                1,
                "InventariApp",
                "https://d1nhio0ox7pgb.cloudfront.net/_img/g_collection_png/standard/512x512/store.png",
                "Avenida Falsa # 123",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                        "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                        "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
                        "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
            ), listOf(
                Comment(
                    1,
                    "Excelente",
                    "Camilo",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    2,
                    "Producto perfecto",
                    "Andres",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    3,
                    "Cumplió con lo prometido!",
                    "Carkis",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    4,
                    "Creo que le faltó un proceso mas de calidad",
                    "Raúl",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    5,
                    "No me gustó",
                    "Sandra",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    6,
                    "Se me hizo muy caro",
                    "José",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    7,
                    "Recomendado!",
                    "Pedro",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    8,
                    "Se dañó después del primer uso",
                    "Maria",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    9,
                    "Tuve que esperar mucho para que llegara",
                    "Catalina",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                ),
                Comment(
                    10,
                    "me autodeclaro fanático del producto!",
                    "Christian",
                    "https://www.pinclipart.com/picdir/big/355-3553881_stockvader-predicted-adig-user-profile-icon-png-clipart.png",
                    "2021-11-25"
                )
            ),
            listOf(
                Product(
                    1,
                    "Producto 1",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    10000.0,
                    100
                ),
                Product(
                    2,
                    "Producto 2",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    20000.0,
                    200
                ),
                Product(
                    3,
                    "Producto 3",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    30000.0,
                    300
                ),
                Product(
                    4,
                    "Producto 4",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    40000.0,
                    400
                ),
                Product(
                    5,
                    "Producto 5",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    50000.0,
                    500
                ),
                Product(
                    6,
                    "Producto 6",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    60000.0,
                    600
                ),
                Product(
                    7,
                    "Producto 7",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    70000.0,
                    700
                ),
                Product(
                    8,
                    "Producto 8",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    80000.0,
                    800
                ),
                Product(
                    9,
                    "Producto 9",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    90000.0,
                    900
                ),
                Product(
                    10,
                    "Producto 10",
                    "https://occidente.co/wp-content/uploads/2021/02/el-poder-de-las-frutas-libro.jpg",
                    "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
                    100000.0,
                    1000
                )
            )
        )
    }
}