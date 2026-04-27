package fi.ngantran.javajahti

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.os.Handler
import android.os.Looper
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var codeText: TextView
    private lateinit var btnSyntax: Button
    private lateinit var btnComparison: Button
    private lateinit var btnType: Button
    private lateinit var btnLogic: Button
    private lateinit var btnStats: Button
    private lateinit var btnRestart: Button

    private val tasks = listOf(
        CodeTask("int x = \"hello\";", ErrorType.TYPE),
        CodeTask("int x = \"0,1\";", ErrorType.TYPE),
        CodeTask("if (a = 5) {\n    System.out.println(a);\n}", ErrorType.COMPARISON),
        CodeTask("for (int i = 0; i < 10; i++)\n    System.out.println(i)", ErrorType.SYNTAX),
        CodeTask("int a = 5;\nint b = 10;\nSystem.out.println(a);", ErrorType.LOGIC),
        CodeTask("int y = 10\nSystem.out.println(y);", ErrorType.SYNTAX),
        CodeTask("while (x == 5) {\n    System.out.println(x);\n}", ErrorType.LOGIC),
        CodeTask("boolean isReady = \"true\";", ErrorType.TYPE),
        CodeTask("if (count = 0) {\n    System.out.println(\"Zero\");\n}", ErrorType.COMPARISON),
        CodeTask("for (int i = 0; i <= 10; i--) {\n    System.out.println(i);\n}", ErrorType.LOGIC),
        CodeTask("String number = 5;", ErrorType.TYPE),
        CodeTask("System.out.println(\"Hello world\")", ErrorType.SYNTAX),
        CodeTask(
            "int a = 5;\nif (a > 10) {\n    System.out.println(\"Small\");\n} else {\n    System.out.println(\"Large\");\n}",
            ErrorType.LOGIC
        ),
        CodeTask(
            "if (flag == true);\n{\n    System.out.println(\"OK\");\n}",
            ErrorType.SYNTAX
        ),
        CodeTask("double d = 3.14;\nint x = d;", ErrorType.TYPE)
    )

    private var currentTaskIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // XML ja Kotlin
        codeText = findViewById(R.id.codeText)
        btnSyntax = findViewById(R.id.btnSyntax)
        btnComparison = findViewById(R.id.btnComparison)
        btnType = findViewById(R.id.btnType)
        btnLogic = findViewById(R.id.btnLogic)
        btnStats = findViewById(R.id.btnStats)
        btnRestart = findViewById(R.id.btnRestart)

        showTask()

        btnSyntax.setOnClickListener {
            checkAnswer(ErrorType.SYNTAX, btnSyntax)
        }

        btnComparison.setOnClickListener {
            checkAnswer(ErrorType.COMPARISON, btnComparison)
        }

        btnType.setOnClickListener {
            checkAnswer(ErrorType.TYPE, btnType)
        }

        btnLogic.setOnClickListener {
            checkAnswer(ErrorType.LOGIC, btnLogic)
        }

        btnStats.setOnClickListener {
            openStats()
        }

        btnRestart.setOnClickListener {
            restartGame()
        }

        btnStats.visibility = View.GONE
        btnRestart.visibility = View.GONE
    }

    private fun showTask() {
        if (currentTaskIndex < tasks.size) {
            resetButtonColors()

            btnSyntax.isEnabled = true
            btnComparison.isEnabled= true
            btnType.isEnabled = true
            btnLogic.isEnabled = true

            codeText.text = tasks[currentTaskIndex].codeSnippet
        } else {
            codeText.text = "Peli päättyi 🎉"
            disableButtons()

            btnSyntax.visibility = View.GONE
            btnComparison.visibility = View.GONE
            btnType.visibility = View.GONE
            btnLogic.visibility = View.GONE

            btnRestart.visibility = View.VISIBLE
            btnRestart.isEnabled = true

            btnStats.visibility = View.VISIBLE
            btnStats.isEnabled = true
        }
    }

    private fun checkAnswer(selected: ErrorType, pressedButton: Button) {
        disableButtons()
        val correct = tasks[currentTaskIndex].correctErrorType
        if (selected == correct) {
            correctCount++
        } else {
            wrongCount++
        }

        when (correct) {
            ErrorType.SYNTAX -> syntaxCount++
            ErrorType.TYPE -> typeCount++
            ErrorType.LOGIC -> logicCount++
            ErrorType.COMPARISON -> comparisonCount++
        }

        if (selected == correct) {
            Toast.makeText(this, "Oikein ✅", Toast.LENGTH_SHORT).show()

            pressedButton.backgroundTintList =
                ContextCompat.getColorStateList(this, R.color.green)

        } else {
            Toast.makeText(this, "Väärin ❌", Toast.LENGTH_SHORT).show()

            pressedButton.backgroundTintList =
                ContextCompat.getColorStateList(this, R.color.red)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            currentTaskIndex++
            showTask()
        }, 200)
    }

    private fun resetButtonColors() {
        val blue = ContextCompat.getColorStateList(this, R.color.blue)
        btnSyntax.backgroundTintList = blue
        btnComparison.backgroundTintList = blue
        btnType.backgroundTintList = blue
        btnLogic.backgroundTintList = blue
    }

    private fun disableButtons() {
        btnSyntax.isEnabled = false
        btnComparison.isEnabled = false
        btnType.isEnabled = false
        btnLogic.isEnabled = false
    }

    private fun restartGame() {
        currentTaskIndex = 0
        resetButtonColors()

        btnSyntax.visibility = View.VISIBLE
        btnComparison.visibility = View.VISIBLE
        btnType.visibility = View.VISIBLE
        btnLogic.visibility = View.VISIBLE

        btnSyntax.isEnabled = true
        btnComparison.isEnabled = true
        btnType.isEnabled = true
        btnLogic.isEnabled = true

        btnRestart.isEnabled = false
        btnRestart.visibility = View.GONE

        btnStats.isEnabled = false
        btnStats.visibility = View.GONE
        showTask()
    }

    private var correctCount = 0
    private var wrongCount = 0

    private var syntaxCount = 0
    private var typeCount = 0
    private var logicCount = 0
    private var comparisonCount = 0


    private fun openStats() {
        val intent = Intent(this, StatsActivity::class.java)
        intent.putExtra("correct", correctCount)
        intent.putExtra("wrong", wrongCount)
        intent.putExtra("syntax", syntaxCount)
        intent.putExtra("type", typeCount)
        intent.putExtra("logic", logicCount)
        intent.putExtra("comparison", comparisonCount)
        startActivity(intent)
    }

}