package com.example.proyectoappmmja.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoappmmja.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configuración del TextView
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Configuración del botón de Semestre
        val buttonSemestre = binding.button2
        buttonSemestre.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), buttonSemestre)
            popupMenu.menu.add("Primero")
            popupMenu.menu.add("Tercero")
            popupMenu.menu.add("Quinto")
            popupMenu.menu.add("Séptimo")

            popupMenu.setOnMenuItemClickListener { item ->
                Toast.makeText(requireContext(), "Seleccionaste: ${item.title}", Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()
        }

        // Configuración del botón de Carrera
        val buttonCarrera = binding.buttonCarrera
        buttonCarrera.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), buttonCarrera)
            popupMenu.menu.add("Ing. Informática")
            popupMenu.menu.add("Lic. Administración")
            popupMenu.menu.add("Ing. Administración")
            popupMenu.menu.add("Contador")
            popupMenu.menu.add("Ing. Agronomía")

            popupMenu.setOnMenuItemClickListener { item ->
                Toast.makeText(requireContext(), "Carrera seleccionada: ${item.title}", Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
