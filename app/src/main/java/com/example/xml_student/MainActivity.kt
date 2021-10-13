package com.example.xml_student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMain=findViewById((R.id.rvMain))
        var student:List<Student>?=null
        try {
            val parser = MyXmlPullParserHandler()
            val istream = assets.open("studentdetails.xml")
            student=  parser.parse(istream)

            rvMain.adapter=RVAdapter(student)
            rvMain.layoutManager=LinearLayoutManager(this)


        }catch (e:IOException){
            e.printStackTrace()

        }
    }
}