package com.example.proyectoappmmja.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectoappmmja.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!
    private var currentNumber = ""
    private var previousNumber = ""
    private var operation = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        setupCalculator()

        return binding.root
    }

    private fun setupCalculator() {
        // Números
        binding.btn0.setOnClickListener { appendNumber("0") }
        binding.btn1.setOnClickListener { appendNumber("1") }
        binding.btn2.setOnClickListener { appendNumber("2") }
        binding.btn3.setOnClickListener { appendNumber("3") }
        binding.btn4.setOnClickListener { appendNumber("4") }
        binding.btn5.setOnClickListener { appendNumber("5") }
        binding.btn6.setOnClickListener { appendNumber("6") }
        binding.btn7.setOnClickListener { appendNumber("7") }
        binding.btn8.setOnClickListener { appendNumber("8") }
        binding.btn9.setOnClickListener { appendNumber("9") }

        // Operaciones
        binding.btnAdd.setOnClickListener { setOperation("+") }
        binding.btnSubtract.setOnClickListener { setOperation("-") }
        binding.btnMultiply.setOnClickListener { setOperation("*") }
        binding.btnDivide.setOnClickListener { setOperation("/") }

        // Botón de igual
        binding.btnEquals.setOnClickListener { calculateResult() }

        // Botón de limpiar
        binding.btnClear.setOnClickListener { clearCalculator() }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        binding.tvResult.text = currentNumber
    }

    private fun setOperation(op: String) {
        if (currentNumber.isNotEmpty()) {
            previousNumber = currentNumber
            currentNumber = ""
            operation = op
            binding.tvResult.text = operation
        }
    }

    private fun calculateResult() {
        if (previousNumber.isNotEmpty() && currentNumber.isNotEmpty()) {
            val result = when (operation) {
                "+" -> previousNumber.toDouble() + currentNumber.toDouble()
                "-" -> previousNumber.toDouble() - currentNumber.toDouble()
                "*" -> previousNumber.toDouble() * currentNumber.toDouble()
                "/" -> if (currentNumber != "0") {
                    previousNumber.toDouble() / currentNumber.toDouble()
                } else {
                    binding.tvResult.text = "Error"
                    return
                }
                else -> 0.0
            }
            binding.tvResult.text = result.toString()
            currentNumber = result.toString()
            previousNumber = ""
            operation = ""
        }
    }

    private fun clearCalculator() {
        currentNumber = ""
        previousNumber = ""
        operation = ""
        binding.tvResult.text = "0"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}