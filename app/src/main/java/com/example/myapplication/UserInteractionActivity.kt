package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var buttonAlert: Button
    lateinit var buttonSnack: Button
    lateinit var buttonToast: Button
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)
        main=findViewById(R.id.Email)

        buttonAlert=findViewById(R.id.btnAlert)
        buttonSnack=findViewById(R.id.btnSnack)
        buttonToast=findViewById(R.id.btnToast)

        buttonToast.setOnClickListener{
            Toast.makeText(this@UserInteractionActivity,"Invalid login",Toast.LENGTH_LONG).show()
        }
        buttonSnack.setOnClickListener{
            Snackbar.make(main,"Unable to login",Snackbar.LENGTH_LONG).setAction("OK",{}).show()
        }

        buttonAlert.setOnClickListener{
            val alert=AlertDialog.Builder(this@UserInteractionActivity)
            alert.setTitle("Warning").setMessage("Are you sure")
//                .setIcon(R.drawable.image)
                .setPositiveButton("Yes",DialogInterface.OnClickListener{dialogInterface, i->})

                .setNegativeButton("No", DialogInterface.OnClickListener {dialogInterface, i-> dialogInterface.dismiss()
                    })
                alert.create().show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Email)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}