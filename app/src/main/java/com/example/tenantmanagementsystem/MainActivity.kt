package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = intent.getStringExtra("EMAIL")
        if (email != null) {
            Toast.makeText(this, "Logged in as $email", Toast.LENGTH_SHORT).show()
        }

        binding.saveButton.setOnClickListener {


            binding.saveButton.setOnClickListener {
                val name = binding.tenantNameEditText.text.toString()
                val phone = binding.phoneEditText.text.toString()
                val rent = binding.rentEditText.text.toString()

                if (name.isBlank()) {
                    binding.tenantNameEditText.error = "Required"
                    return@setOnClickListener
                }
                if (phone.isBlank()) {
                    binding.phoneEditText.error = "Required"
                    return@setOnClickListener
                }
                if (rent.isBlank()) {
                    binding.rentEditText.error = "Required"
                    return@setOnClickListener
                }

                val tenant = Tenant(name, phone, rent)
                binding.tenant = tenant
                lastTenant = tenant

                binding.tenantNameEditText.text.clear()
                binding.phoneEditText.text.clear()
                binding.rentEditText.text.clear()
            }

            binding.callButton.setOnClickListener {
                val tenant = lastTenant
                if (tenant == null) {
                    Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, tenant.summary())
                startActivity(Intent.createChooser(intent, "Share tenant"))
            }
            binding.shareButton.setOnClickListener {
                val tenant = lastTenant
                if (tenant == null) {
                    Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, tenant.summary())
                startActivity(Intent.createChooser(intent, "Share tenant"))
            }

            }
        }
    }

