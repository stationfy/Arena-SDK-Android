package im.arena.sample.social

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.basiccard.BasicCardState
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_social_card.*

class ActivityCardSocial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_card)

        social_card
            .mediaAuthorUrl("https://www.instagram.com/bbbsouthernarizona")
            .mediaAuthorName("bbbsouthernarizona")
            .providerName("Instagram")
            .providerUrl("https://www.instagram.com")
            .mediaThumbnailUrl("https://api-dev.arena.im/v2/oembed/imageproxy?url=https://www.instagram.com/p/B94Z6ZFHZQd/")
            .mediaType("photo")
            .mediaDescription("Protecting yourself, and your family are certainly at the top of your list these days, please see this page at the CDC to learn how to stay safe and minimize your risk. http://ow.ly/Ogso50yNidd #BBB #family #StartwithTrust")
            .senderName("Paulo Silva")
            .senderPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT_-Y8572t5eRZvLLuyC0XgdjXQsHQvIQYYJoR-ps8Rb7rKLKAm")
            .state(BasicCardState.NORMAL)
            .createdAt(1584638797958)
            .build()
    }
}