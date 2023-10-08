package com.example.parcialapprecetascocina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRecetas: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvRecetas = findViewById(R.id.rv_recetas)
        rvRecetas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvRecetas.adapter = adapter
        val listaRecetas = getListadoRecetas()
        adapter.submitList(listaRecetas)

        adapter.onItemClickListener = {receta ->
            navegarDetalle(receta)
        }

    }

    private fun navegarDetalle(receta: Recetas) {
        val intent = Intent(this, RecetaDetalleActivity:: class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }

    private fun getListadoRecetas(): MutableList<Recetas> {
        return mutableListOf(
            Recetas(1, "Torta chajá",dificultadReceta.DIFICULT,paisReceta.URUGUAY,"ING01","REC01",8,45,"https://www.paulinacocina.net/wp-content/uploads/2022/03/postre-chaja.jpg"),
            Recetas(2, "Tacos al Pastor",dificultadReceta.MEDIUM,paisReceta.MEXICO,"ING02","REC02",10,20,"https://www.paulinacocina.net/wp-content/uploads/2023/02/receta-de-tacos-al-pastor-800x450.jpg"),
            Recetas(3, "Empanadas Salteñas",dificultadReceta.EASY,paisReceta.ARGENTINA,"ING03","REC03",30,50,"https://www.paulinacocina.net/wp-content/uploads/2022/01/empanadas-saltenas-al-horno.jpg"),
            Recetas(4, "Chipá",dificultadReceta.VERYEASY,paisReceta.PARAGUAY,"ING04","REC04",20,45,"https://www.paulinacocina.net/wp-content/uploads/2015/09/IMG_20150818_091913-e1441771762765.jpg"),
            Recetas(5, "Sopa Paraguaya",dificultadReceta.EASY,paisReceta.PARAGUAY,"ING05","REC05",8,50,"https://www.paulinacocina.net/wp-content/uploads/2015/05/sopa-paraguaya-play.jpg"),
            Recetas(6, "Alfajores Marplatenses",dificultadReceta.ISVERIDIFICUL,paisReceta.ARGENTINA,"ING06","REC06",12,40,"https://www.paulinacocina.net/wp-content/uploads/2022/06/receta-de-alfajor-artesanal.jpg"),
            Recetas(7, "Chipa Guazú",dificultadReceta.EASY,paisReceta.PARAGUAY,"ING07","REC07",12,40,"https://www.paulinacocina.net/wp-content/uploads/2023/05/chipa-guazu-receta.jpg"),
            Recetas(8, "Arepa Colombiana",dificultadReceta.VERYEASY,paisReceta.COLOMBIA,"ING08","REC08",20,40,"https://www.paulinacocina.net/wp-content/uploads/2017/03/video.png"),
            Recetas(9, "Arepa Venezolana",dificultadReceta.VERYEASY,paisReceta.VENEZUELA,"ING09","REC09",12,30,"https://www.paulinacocina.net/wp-content/uploads/2022/05/arepas-venezolanas-receta.jpg"),
            Recetas(10, "Cebiche de Pejerrey",dificultadReceta.MEDIUM,paisReceta.PERU,"ING10","REC10",3,30,"https://www.paulinacocina.net/wp-content/uploads/2016/02/P1190432-e1454632225219.jpg"),
            Recetas(11, "Bandeja Paisa",dificultadReceta.ISVERIDIFICUL,paisReceta.COLOMBIA,"ING11","REC11",4,45,"https://www.paulinacocina.net/wp-content/uploads/2023/04/bandeja-paisa-calorias-800x450.jpg"),
            Recetas(12, "Burritos",dificultadReceta.MEDIUM,paisReceta.MEXICO,"ING12","REC12",6,20,"https://www.paulinacocina.net/wp-content/uploads/2022/01/burritos.jpg"),
            Recetas(13, "Tostada de Cebiche",dificultadReceta.MEDIUM,paisReceta.ECUADOR,"ING13","REC13",6,60,"https://www.paulinacocina.net/wp-content/uploads/2023/07/tostada-de-ceviche.jpg"),
            Recetas(14, "Tequeños",dificultadReceta.MEDIUM,paisReceta.VENEZUELA,"ING14","REC14",35,90,"https://www.paulinacocina.net/wp-content/uploads/2021/10/tequen%CC%83os-venezolanos.jpg"),
            Recetas(15, "Humita en olla",dificultadReceta.DIFICULT,paisReceta.ARGENTINA,"ING15","REC15",6,50,"https://www.paulinacocina.net/wp-content/uploads/2022/04/receta-de-humita-en-olla.jpg"),
            Recetas(16, "Feijoada",dificultadReceta.DIFICULT,paisReceta.BRASIL,"ING16","REC16",5,180,"https://www.paulinacocina.net/wp-content/uploads/2022/04/feijoada-tradicional-brasilena.jpg"),
            Recetas(17, "Alfajores de Maicena",dificultadReceta.DIFICULT,paisReceta.ARGENTINA,"ING17","REC17",30,90,"https://www.paulinacocina.net/wp-content/uploads/2019/07/alf-1024x576.png"),
            Recetas(18, "Colación de Dulce de Leche",dificultadReceta.DIFICULT,paisReceta.ARGENTINA,"ING18","REC18",50,90,"https://www.paulinacocina.net/wp-content/uploads/2019/09/colasiones-cordobesas-2okok.jpg"),
            Recetas(19, "Ajiaco",dificultadReceta.DIFICULT,paisReceta.COLOMBIA,"ING19","REC19",5,180,"https://www.paulinacocina.net/wp-content/uploads/2013/09/1-P1040849.jpg"),
            Recetas(20, "Locro",dificultadReceta.MEDIUM,paisReceta.ARGENTINA,"ING20","REC20",4,180,"https://www.paulinacocina.net/wp-content/uploads/2016/05/LOCRO-PLAY.jpg"),

            )
    }
}