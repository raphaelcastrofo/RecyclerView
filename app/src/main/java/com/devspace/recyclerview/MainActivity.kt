package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this,2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->

            val intent = Intent(this, ContactDetailActivity::class.java)

            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)


            startActivity(intent)
        }

    }
}

val contacts = listOf(
    Contact(
        "Marcello",
        "(55) 33 81234612",
        R.drawable.sample1
    ),

    Contact(
        "Amanda",
        "(55) 31 92256789",
        R.drawable.sample2
    ),

    Contact(
        "Carlos",
        "(55) 32 73456891",
        R.drawable.sample3
    ),

    Contact(
        "Julia",
        "(55) 34 92345678",
        R.drawable.sample4
    ),

    Contact(
        "Victor",
        "(55) 35 81239876",
        R.drawable.sample5
    ),

    Contact(
        "Marina",
        "(55) 36 91435879",
        R.drawable.sample6
    ),

    Contact(
        "Paulo",
        "(55) 37 94567231",
        R.drawable.sample7
    ),

    Contact(
        "Bianca",
        "(55) 38 85694321",
        R.drawable.sample8
    ),

    Contact(
        "Gustavo",
        "(55) 39 96721345",
        R.drawable.sample9
    ),

    Contact(
        "Isabela",
        "(55) 30 92345671",
        R.drawable.sample10
    ),

    Contact(
        "Felipe",
        "(55) 31 91723489",
        R.drawable.sample11
    ),

    Contact(
        "Livia",
        "(55) 32 98765432",
        R.drawable.sample12
    ),

    Contact(
        "Renato",
        "(55) 33 85431276",
        R.drawable.sample13
    ),

    Contact(
        "Patricia",
        "(55) 34 83214567",
        R.drawable.sample14
    ),

    Contact(
        "Thiago",
        "(55) 35 87653241",
        R.drawable.sample15
    ),

    Contact(
        "Leticia",
        "(55) 36 94567321",
        R.drawable.sample16
    ),
)