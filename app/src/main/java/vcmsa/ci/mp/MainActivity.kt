package vcmsa.ci.mp
// ST10487831 Tshiamo Moloi
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Links to the activity_main.xml


        val addToPlaylistButton: Button = findViewById(R.id.button1)


        val nextButton: Button = findViewById(R.id.button2)


        val exitButton: Button = findViewById(R.id.button3)

        addToPlaylistButton.setOnClickListener {
            showAddSongDialog()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent) // Start Activity2
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun showAddSongDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.addsong, null)
        dialogBuilder.setView(dialogView)

        val songTitleEditText: EditText = dialogView.findViewById(R.id.songTitleEditText)
        val artistNameEditText: EditText = dialogView.findViewById(R.id.artistNameEditText)
        val ratingEditText: EditText = dialogView.findViewById(R.id.ratingEditText)
        val commentsEditText: EditText = dialogView.findViewById(R.id.commentsEditText)

        dialogBuilder.setTitle("Add Song to Playlist")
        dialogBuilder.setPositiveButton("Add") { dialog, which ->
            val songTitle = songTitleEditText.text.toString()
            val artistName = artistNameEditText.text.toString()
            val rating = ratingEditText.text.toString().toIntOrNull() ?: 0
            val comments = commentsEditText.text.toString()


            println("Song Title: $songTitle")
            println("Artist Name: $artistName")
            println("Rating: $rating")
            println("Comments: $comments")
        }
        dialogBuilder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }

        val alert = dialogBuilder.create()
        alert.show()
    }
}