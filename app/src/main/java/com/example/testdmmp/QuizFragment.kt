package com.example.testdmmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
            answers = listOf("Neptune", "Uranus", "Pluton"))
    )
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0

    override fun onCreateView(
         inflater: LayoutInflater,  container: ViewGroup?,
          savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)
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

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < questions.size) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    }
                }
            }
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

    companion object {
        fun newInstance(): QuizFragment = QuizFragment()
    }

}