package im.arena.sample.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.basiccard.BasicCardState
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_article.*

class ActivityCardArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        article_card
            .providerName("G1")
            .providerUrl("https://g1.globo.com")
            .title("Governo determina fechamento de shoppings e academias na Grande SP para conter avanço do coronavírus")
            .mediaDescription("Shoppings têm até a próxima segunda-feira (23) para fechar as portas e academias até o domingo (22). Fechamento deve durar até 30 de abril.")
            .mediaThumbnailUrl("https://s2.glbimg.com/HR0NKgQvnrR0jEAo0dtByv3L6lo=/1200x/smart/filters:cover():strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/R/C/5rHtbRRVycQ0fhKRnsFA/doria-anuncia.png")
            .mediaUrl("https://g1.globo.com/sp/sao-paulo/noticia/2020/03/18/governo-determina-fechamento-de-shoppings-na-regiao-metropolitana-de-sp-ate-23-de-marco.ghtml")
            .mediaType("article")
            .senderName("Paulo Silva")
            .senderPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT_-Y8572t5eRZvLLuyC0XgdjXQsHQvIQYYJoR-ps8Rb7rKLKAm")
            .state(BasicCardState.NORMAL)
            .createdAt(1584638797958)
            .build()
    }
}