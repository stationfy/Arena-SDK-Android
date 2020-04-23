package im.arena.sample.golfcard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_golf_card.*

class ActivityGolfCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_golf_card)

        golf_card
            .icon("https://firebasestorage.googleapis.com/v0/b/arena-prd.appspot.com/o/images%2F1f1a0be18270dde563bbc625e0270bcb.jpg?alt=media&token=7889aa13-53a2-49e3-862c-8e0d049a4498")
            .title("Title")
            .messageText("Description")
            .senderPhoto("https://firebasestorage.googleapis.com/v0/b/arena-dev-f9045.appspot.com/o/images%2F4d393abb0e8bdeda2c787d56592c71f3.jpg?alt=media&token=a8951c60-d47a-4792-87ef-27380172505a")
            .senderName("QA Publisher")
            .playerPhoto("https://f.i.uol.com.br/fotografia/2020/02/22/15823911105e515f46b0011_1582391110_3x2_md.jpg")
            .playerName("Adam Schenk")
            .clubName("Putter")
            .clubPhoto("https://stationfy.imgix.net/golf-clubs/putter.png")
            .createdAt(1584638797958)
            .period("1")
            .periodName("Buraco")
            .build()
    }
}