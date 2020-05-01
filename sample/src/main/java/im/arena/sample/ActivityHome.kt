package im.arena.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.sample.analytics.ActivityAnalytics
import im.arena.sample.article.ActivityCardArticle
import im.arena.sample.basiccard.ActivityBasicCard
import im.arena.sample.golfcard.ActivityGolfCard
import im.arena.sample.liveblog.ActivityLiveBlog
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_BASEBALL
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_BASKETBALL
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_GENERAL
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_GOLF
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_MIDIA
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_MOTOSPORT
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_SOCCER
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EXTRA_EVENT_SLUG
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EXTRA_PUBLISHER_SLUG
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.PUBLISHER_SLUG
import im.arena.sample.midiacard.ActivityCardMedia
import im.arena.sample.pinnedcard.ActivityPinnedCard
import im.arena.sample.service.ActivityServicePlayByPlay
import im.arena.sample.social.ActivityCardSocial
import im.arena.sample.summary.ActivitySummaryCard
import kotlinx.android.synthetic.main.activity_home.*

class ActivityHome : AppCompatActivity(), AdapterHome.OnClickListener {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    private val componentsList: List<String> =
        listOf(
            "Live Blog General",
            "Live Blog Golf",
            "Live Blog Soccer",
            "Live Blog Baseball",
            "Live Blog Basketball",
            "Live Blog Motosport",
            "Live Blog Midia",
            "Basic Card",
            "Pinned Card",
            "Summary Card",
            "Golf Card",
            "Article Card",
            "Media Card",
            "Social Card",
            "Analytics",
            "Service Play By Play"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recycler_view_home.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = AdapterHome(componentsList, this@ActivityHome)
        }
    }

    override fun click(view: View?, position: Int) {
        when (position) {
            0 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_GENERAL)
            )

            1 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_GOLF)
            )

            2 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_SOCCER)
            )


            3 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_BASEBALL)
            )


            4 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_BASKETBALL)
            )


            5 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_MOTOSPORT)
            )


            6 -> startActivity(
                Intent(this, ActivityLiveBlog::class.java)
                    .putExtra(EXTRA_PUBLISHER_SLUG, PUBLISHER_SLUG)
                    .putExtra(EXTRA_EVENT_SLUG, EVENT_SLUG_MIDIA)
            )


            7 -> startActivity(Intent(this, ActivityBasicCard::class.java))

            8 -> startActivity(Intent(this, ActivityPinnedCard::class.java))

            9 -> startActivity(Intent(this, ActivitySummaryCard::class.java))

            10 -> startActivity(Intent(this, ActivityGolfCard::class.java))

            11 -> startActivity(Intent(this, ActivityCardArticle::class.java))

            12 -> startActivity(Intent(this, ActivityCardMedia::class.java))

            13 -> startActivity(Intent(this, ActivityCardSocial::class.java))

            14 -> startActivity(Intent(this, ActivityAnalytics::class.java))

            15 -> startActivity(Intent(this, ActivityServicePlayByPlay::class.java))
        }
    }

}