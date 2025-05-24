package vcmsa.ci.flashcardquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        class ReviewActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_review)

                val questions = arrayOf(
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

                val answers = booleanArrayOf(true, true, true, true, true)

                val reviewText = findViewById<TextView>(R.id.reviewText)

                var reviewContent = "Review Questions and Answers:\n\n"
                for (i in questions.indices) {
                    reviewContent += "${i+1}. ${questions[i]} \n"
                    reviewContent += "Correct Answer: ${if (answers[i]) "True" else "False"}\n\n"
                }

                reviewText.text = reviewContent
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}










