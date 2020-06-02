package im.arena.sample.summary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.basiccard.BasicCardState
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_summary_card.*

class ActivitySummaryCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_card)

        summary_card
            .summaryTitle("Summary")
            .iconUrl("https://firebasestorage.googleapis.com/v0/b/arena-dev-f9045.appspot.com/o/images%2F4d393abb0e8bdeda2c787d56592c71f3.jpg?alt=media&token=a8951c60-d47a-4792-87ef-27380172505a")
            .playerPhoto("https://f.i.uol.com.br/fotografia/2020/02/22/15823911105e515f46b0011_1582391110_3x2_md.jpg")
            .playerTeam("https://upload.wikimedia.org/wikipedia/pt/thumb/4/43/FCBarcelona.svg/1200px-FCBarcelona.svg.png")
            .playerName("Messi")
            .playerType("Atacante")
            .title("Pegoou o goleiro")
            .messageText("Kroos cobra o pênalti com uma cavadinha, desloca o goleiro Andrés Fernández e faz 4 a 1 para o Barça.")
            .senderName("Paulo Silva")
            .senderPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT_-Y8572t5eRZvLLuyC0XgdjXQsHQvIQYYJoR-ps8Rb7rKLKAm")
            .state(BasicCardState.SUMMARY)
            .build()
    }
}