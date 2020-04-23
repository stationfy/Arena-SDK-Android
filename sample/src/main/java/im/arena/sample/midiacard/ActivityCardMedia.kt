package im.arena.sample.midiacard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.basiccard.BasicCardState
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_media_card.*

class ActivityCardMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_card)

        media_card
            .icon("https://firebasestorage.googleapis.com/v0/b/arena-dev-f9045.appspot.com/o/images%2F4d393abb0e8bdeda2c787d56592c71f3.jpg?alt=media&token=a8951c60-d47a-4792-87ef-27380172505a")
            .title("Pegoou o goleiro")
            .mediaThumbnailUrl("https://stationfy.imgix.net/cm/5e80eef29929c500074fea13.jpeg")
            .mediaType("photo")
            .messageText("Kroos cobra o pênalti com uma cavadinha, desloca o goleiro Andrés Fernández e faz 4 a 1 para o Barça.")
            .senderName("Paulo Silva")
            .senderPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT_-Y8572t5eRZvLLuyC0XgdjXQsHQvIQYYJoR-ps8Rb7rKLKAm")
            .state(BasicCardState.NORMAL)
            .createdAt(1584638797958)
            .build()
    }
}