package vcmsa.ci.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



                val startButton: Button = findViewById<Button>(R.id.startButton)
                startButton.setOnClickListener {
                    // Start FlashcardActivity
                    val intent = Intent(this, FlashcardActivity::class.java)
                    startActivity(intent)
                }
            }
        }







