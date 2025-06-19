package vcmsa.ci.mp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    private val songs = mutableListOf(
        Song("1am", "Belo", 5, "Great song!"),
        Song("Be better do better", "j0j", 4, "Nice tune."),
        Song("i know", "Blue", 3, "Okay."),
        Song("called my baby", "laikum", 2, "Not bad.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        val listOfSongsButton: Button = findViewById(R.id.listOfSongsButton)
        val averageButton: Button = findViewById(R.id.averageButton)
        val returnToMainScreenButton: Button = findViewById(R.id.returnToMainScreenButton)

        val songsTextView: TextView = findViewById(R.id.songsTextView)
        val averageRatingTextView: TextView = findViewById(R.id.averageRatingTextView)

        listOfSongsButton.setOnClickListener {
            displaySongs(songsTextView)
        }

        averageButton.setOnClickListener {
            calculateAverageRating(averageRatingTextView)
        }

        returnToMainScreenButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displaySongs(songsTextView: TextView) {
        val songsList = StringBuilder()
        for (song in songs) {
            songsList.append("Title: ${song.title}, Artist: ${song.artist}, Rating: ${song.rating}, Comment: ${song.comment}\n")
        }
        songsTextView.text = songsList.toString()
    }

    private fun calculateAverageRating(averageRatingTextView: TextView) {
        if (songs.isEmpty()) {
            averageRatingTextView.text = "No songs in the playlist."
            return
        }
        var totalRating = 0
        for (song in songs) {
            totalRating += song.rating
        }
        val averageRating = totalRating.toDouble() / songs.size
        averageRatingTextView.text = "Average Rating: $averageRating"
    }
}