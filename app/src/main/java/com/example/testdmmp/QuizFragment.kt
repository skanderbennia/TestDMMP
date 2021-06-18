package com.example.testdmmp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.testdmmp.data.DaoScore
import com.example.testdmmp.data.Score
import com.example.testdmmp.data.ScoreViewModel
import com.example.testdmmp.databinding.FragmentQuizBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "Combien de planètes orbitent autour du Soleilf?",
            answers = listOf("Huit", "Neuf", "Dix")),
        Question(text = "Quelle est la planète la plus proche du soleil?",
            answers = listOf("Terre", "Jupiter", "Mercure" )),
        Question(text = "Quelle est la plus grosse planète du Système Solaire?",
            answers = listOf("Mars", "Jupiter", "Neptune")),
        Question(text = "Pushing structured data into a Layout?",
            answers = listOf("Neptune", "Uranus", "Pluton")),
            Question(text = "",
                    answers = listOf(""))
    )
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var score = 0
    private lateinit var mScoreViewModel: ScoreViewModel

    override fun onCreateView(
         inflater: LayoutInflater,  container: ViewGroup?,
          savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)
        mScoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        setQuestion()
        binding.game = this
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 0
                    R.id.thirdAnswerRadioButton -> answerIndex = 1
                    R.id.fourthAnswerRadioButton -> answerIndex = 2
                }


                if (questionIndex < questions.size-1) {

                    currentQuestion = questions[questionIndex]
                    Log.d("answer",answers[answerIndex])
                    Log.d("answer",currentQuestion.answers[0])
                    if (answers[answerIndex] == currentQuestion.answers[0]) {

                        score++
                        Log.d("score",score.toString())
                        // Advance to the next question

                    }
                    questionIndex++
                    setQuestion()
                    binding.invalidateAll()
                }
                if (questionIndex==questions.size-1) {
                    binding.secondAnswerRadioButton.visibility = View.GONE
                    binding.thirdAnswerRadioButton.visibility = View.GONE
                    binding.fourthAnswerRadioButton.visibility = View.GONE
                    binding.submitButton.visibility = View.GONE
                    binding.textView.visibility = View.GONE
                    binding.scoreShow.text = "votre score est  $score"
                    binding.scoreShow.visibility = View.VISIBLE
                    binding.bestScore.visibility = View.VISIBLE
                    binding.resetButton.visibility = View.VISIBLE
                    val objectScore = Score(0,score)
                    mScoreViewModel.addScore(objectScore)
                    mScoreViewModel.readAllData.observe(this, Observer {score->
                        binding.bestScore.text ="Your best Score is "+score[0].value.toString()
                    })

                }


            }
        }
        binding.resetButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            resetQuestions()
        }

        return binding.root

    }
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()

    }
    private fun resetQuestions(){
        questionIndex = 0
        score = 0
        setQuestion()
    }

    companion object {
        fun newInstance(): QuizFragment = QuizFragment()
    }

}