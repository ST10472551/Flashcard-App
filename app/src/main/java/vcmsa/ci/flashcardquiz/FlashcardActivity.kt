package vcmsa.ci.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashcardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard)

        val questionText: TextView = findViewById(R.id.questionText)
        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val trueBtn: Button = findViewById(R.id.trueButton)
        val falseBtn: Button = findViewById(R.id.falseButton)
        val nextBtn: Button = findViewById(R.id.nextButton)

        // Example world history questions and answers
        val questions = listOf(
            "Did the First World War begin in 1914?",
            "Was Julius Caesar the first emperor of Rome?",
            "Did the Berlin Wall fall in 1989?",
            "Was the Great Wall of China built in one year?",
            "Did the ancient Egyptians build the pyramids?",
            "Was Mahatma Gandhi a leader in India's independence movement?",
            "Did Christopher Columbus reach America in 1492?",
            "Was the Magna Carta signed in France?",
            "Did the Industrial Revolution start in Britain?",
            "Was Nelson Mandela the first black president of South Africa?"
        )
        val answers = listOf(
            true,      // WWI began in 1914
            false,     // Caesar was not the first emperor (Augustus was)
            true,      // Berlin Wall fell 1989
            false,     // Great Wall took centuries
            true,      // Egyptians built pyramids
            true,      // Gandhi: India independence
            true,      // Columbus: 1492
            false,     // Magna Carta: England
            true,      // Industrial Revolution: Britain
            true       // Mandela: 1st black president SA
        )
        var currentIndex = 0
        var score = 0

        fun displayQuestion() {
            questionText.text = questions[currentIndex]
            feedbackText.text = ""
            trueBtn.isEnabled = true
            falseBtn.isEnabled = true
            nextBtn.isEnabled = false
        }

        fun handleAnswer(userAnswer: Boolean) {
            trueBtn.isEnabled = false
            falseBtn.isEnabled = false
            nextBtn.isEnabled = true

            if (userAnswer == answers[currentIndex]) {
                feedbackText.text = "Correct!"
                score++
            } else {
                feedbackText.text = "Incorrect"
            }
        }

        trueBtn.setOnClickListener { handleAnswer(true) }
        falseBtn.setOnClickListener { handleAnswer(false) }
        nextBtn.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                displayQuestion()
            } else {
                // Move to ScoreActivity when quiz is finished
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                intent.putStringArrayListExtra("questions", ArrayList(questions))
                intent.putExtra("answers", answers.toBooleanArray())
                startActivity(intent)
                finish()
            }
        }

        displayQuestion()
    }
}















