package com.example.ahmad_project_3tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmad_project_3tia.LoginActivity
import com.example.ahmad_project_3tia.MainActivity
import com.example.ahmad_project_3tia.databinding.FragmentHomeBinding
import com.example.ahmad_project_3tia.Home.pertemuan5.LimaActivity
import com.example.ahmad_project_3tia.Home.pertemuan6.EnamActivity
import com.example.ahmad_project_3tia.Home.pertemuan9.NinthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("EXTRA_USER")
        val password = requireActivity().intent.getStringExtra("EXTRA_PASS")

        binding.texUsername.text = "user: $user"
        binding.textPassword.text = "password: $password"

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(
                binding.root, "Halo ini SnackBar",
                Snackbar.LENGTH_LONG
            )
                .setAction("KEMBALI") {
                    // kembalikan item
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        requireContext(),
                        "Kembali ke halaman Activity",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak " +
                            "bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btntolima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)

            startActivity(intent)
        }
        binding.btntoEnam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)

            startActivity(intent)
        }
        binding.btntoNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)

            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}