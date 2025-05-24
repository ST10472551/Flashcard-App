package vcmsa.ci.flashcardquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)


        class ScoreActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_score)

                val score = intent.getIntExtra("score", 0)
                val total = intent.getIntExtra("total", 0)

                val scoreText: TextView = findViewById(R.id.textScore)
                scoreText.text = "Your score: $score out of $total"
                // Add more UI as needed
            }
        }

        // Get data passed from previous activity
        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        // Get references to UI components
        val textScore = findViewById<TextView>(R.id.textScore)
        val textFeedback = findViewById<TextView>(R.id.textScoreFeedback)
        val reviewButton = findViewById<Button>(R.id.buttonReview)
        val exitButton = findViewById<Button>(R.id.buttonExit)

        // Display the score
        textScore.text = "Your score: $score/10"

        // Personalized feedback
        textFeedback.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practising!"
        }

        // Review button opens ReviewActivity with question/answer data
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", answers)
            startActivity(intent)
        }

        // Exit button closes the app
        exitButton.setOnClickListener {
            finishAffinity()
        }

        // Handle window insets for immersive experience (status/navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



