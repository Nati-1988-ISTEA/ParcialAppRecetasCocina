package com.example.parcialapprecetascocina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class RecetaDetalleActivity : AppCompatActivity() {
    private lateinit var nameDA: TextView
    private lateinit var fotoDA: ImageView
    private lateinit var countryDA: TextView
    private lateinit var banderinDA: ImageView
    private lateinit var dificultad: TextView
    private lateinit var porciones: TextView
    private lateinit var tiempo: TextView
    private lateinit var btnVolver: Button
    private lateinit var detalle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receta_detalle)

        val receta = intent.getParcelableExtra<Recetas>("receta")

        nameDA = findViewById(R.id.nombreRecetaDA)
        nameDA.text = receta?.nombre

        fotoDA = findViewById(R.id.imagenRecetaDA)
        Glide.with(this)
            .load(receta?.fotografia)
            .centerCrop()
            .into(fotoDA)

        countryDA = findViewById(R.id.paisRecetaDA)
        countryDA.text = receta?.pais.toString()


        banderinDA = findViewById(R.id.banderitaRecetaDA)
        val banderita = when (receta?.pais) {
            paisReceta.ARGENTINA -> R.drawable.arg
            paisReceta.BRASIL -> R.drawable.brz
            paisReceta.COLOMBIA -> R.drawable.col
            paisReceta.ECUADOR -> R.drawable.ecu
            paisReceta.MEXICO -> R.drawable.mex
            paisReceta.PARAGUAY -> R.drawable.par
            paisReceta.PERU -> R.drawable.per
            paisReceta.URUGUAY -> R.drawable.uru
            else -> R.drawable.ven
        }

        banderinDA.setImageResource(banderita)

        val dif = when (receta?.dificultad) {
            dificultadReceta.VERYEASY -> "Dificultad: Teikirisi ⭐"
            dificultadReceta.EASY -> "Dificultad: Kids Game ⭐⭐"
            dificultadReceta.MEDIUM -> "Dificultad: Fifty Fifty ⭐⭐⭐"
            dificultadReceta.DIFICULT -> "Dificultad: Pro-level ⭐⭐⭐⭐"
            else -> "Dificultad: Is Very Dificul ⭐⭐⭐⭐⭐"
        }

        dificultad = findViewById(R.id.dificultadRecetaDA)
        dificultad.text = dif

        porciones = findViewById(R.id.porcionesRecetaDA)
        porciones.text = "Porciones: " + receta?.porciones.toString() + " \uD83C\uDF7D️"

        tiempo = findViewById(R.id.tiempoRecetaDA)
        tiempo.text = "Tiempo Preparación: " + receta?.tiempo.toString() + " \uD83D\uDD57"

        /*btnVolver = findViewById(R.id.botonVolverDA)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }*/

        // ELEMENTOS DE LLENADO DE LAS RECETAS

        val ingredientesLista = listOf(
            "100 gr. de harina 0000\n" +
                    "2 huevos\n" +
                    "150 gr. de azúcar \n" +
                    "250 gr. de dulce de leche repostero\n" +
                    "1 lata de durazno en almíbar\n" +
                    "250 cc. de crema de leche\n" +
                    "250 gr. de merengue\n" +
                    "Esencia de vainilla",

            "Ingredientes para el adobo\n" +
                    "Pasta de achiote\n" +
                    "Jugo de Piña \n" +
                    "Dientes de ajo \n" +
                    "Orégano \n" +
                    "Vinagre blanco \n" +
                    "Comino molido \n" +
                    "Pimienta negra\n" +
                    "Clavo de olor \n" +
                    "Sal\n" +
                    "Chiles Guajillo \n" +
                    "Ingredientes para los tacos\n" +
                    "10 tortillas\n" +
                    "250 grs de carne\n" +
                    "1 cebolla morada mediana\n" +
                    "2 dientes de ajo\n" +
                    "Orégano\n" +
                    "Chile seco (a gusto)\n" +
                    "Sal y pimienta\n" +
                    "Cilantro\n" +
                    "Aceite neutro",

            "500 gr. de carne (nalga, cuadrada, bola de lomo o molida sin grasa)\n" +
                    "250 gramos de cebolla \n" +
                    "250 gramos de papas\n" +
                    "¼ pimentón rojo\n" +
                    "3 huevos hervidos\n" +
                    " 60 gramos de grasa de vaca",

            "1/2 taza de agua\n" +
                    "1/2 taza de leche\n" +
                    "1/4 de taza de aceite de maiz/girasol\n" +
                    "1 cucharada de sal\n" +
                    "1 taza de harina\n" +
                    "1 taza de fécula de mandioca (se pueden sustituir por fécula de maicena)\n" +
                    "1 huevo\n" +
                    "150 gramos de queso rallado",

            "300g. de harina de maíz (la amarilla fina, no polenta)\n" +
                "1/2 lt. de leche\n" +
                "3 cebollas grandes\n" +
                "4 huevos\n" +
                "400g. de queso que se derrita (cremoso, mozzarella, etc.)\n" +
                "1 cdita. de orégano\n" +
                "Sal, pimienta, aceite",

            "20 gr. de chocolate (cobertura o cacao en polvo).\n" +
                "100 gr. de harina 0000.\n" +
                "2 gr. de polvo de hornear.\n" +
                "¼  cucharada de bicarbonato.\n" +
                "35 gr. de azúcar impalpable.\n" +
                "1 yema de huevo.\n" +
                "50 gr. de manteca (o margarina).\n" +
                "350 gr. de dulce de leche repostero para el relleno.\n" +
                "200 gr. de chocolate semiamargo para la cobertura. ",

            "4 tazas de maíz o choclo fresco rallado \n" +
                "2 tazas de queso fresco rallado o cortado pequeño\n" +
                "1 cebolla grande picada finamente\n" +
                "4 huevos\n" +
                "1 taza de leche\n" +
                "4 cucharadas de manteca derretida\n" +
                "Sal y pimienta a gusto\n" +
                "1 pizca de nuez moscada (opcional)",

            "500 gr de maíz blanco pisado (se consigue en cualquier dietética)\n" +
                    "Sal\n" +
                    "Aceite de oliva\n" +
                    "Queso\n" +
                    "Rellenos varios",

            "3 tazas agua tibia o caliente\n" +
                    "2 tazas de harina precocida de Maíz\n" +
                    "1 cdita. de Sal\n" +
                    "1 cdita. de Aceite de oliva",

            "3 pejerreyes, frescos y limpios\n" +
                "\n" +
                "3 limones\n" +
                "\n" +
                "1 ají amarillo licuado o 1 cda. de pasta de ají amarillo \n" +
                "\n" +
                "1 puntita de putaparió u otro chile picante\n" +
                "\n" +
                "Media Cebolla morada\n" +
                "\n" +
                "Cilantro\n" +
                "\n" +
                "Sal y pimienta",

            "500 g de carne picada cocida\n" +
                "1 taza de arroz cocido\n" +
                "1 taza de frijoles rojos (porotos) cocidos\n" +
                "4 plátanos maduros\n" +
                "4 chorizos\n" +
                "4 morcillas\n" +
                "4 huevos\n" +
                "4 arepas\n" +
                "2 aguacates en rodajas\n" +
                "Aceite\n" +
                "Sal y pimienta a gusto",

            "100 g de harina de trigo de todo uso\n" +
                    "50 ml de agua templada\n" +
                    "2 g de sal",

            "250 gr de camarones frescos, pelados y desvenados\n" +
                "Jugo de 4-5 limones\n" +
                "1 tomate grande, picado en cubitos\n" +
                "1 cebolla morada pequeña, picada finamente\n" +
                "1 chile jalapeño o serrano, picado finamente \n" +
                "Un puñado de cilantro fresco, picado\n" +
                "Sal a gusto\n" +
                "Tostadas de maíz\n" +
                "Aguacate en rodajas \n" +
                "Salsa picante ",

            "350 g de harina de trigo\n" +
                    "80 g de manteca\n" +
                    "1 huevo\n" +
                    "1 cucharadita de azúcar\n" +
                    "2 cucharaditas de sal\n" +
                    "300 g de queso duro blanco, llanero\n" +
                    "Aceite de oliva suave para freír\n" +
                    "Agua (½ taza)",

            "12 choclos\n" +
                "2 cebollas de verdeo\n" +
                "1 pimiento morrón rojo\n" +
                "1 cebolla\n" +
                "1 tomate \n" +
                "1 calabaza pequeña\n" +
                "Hierbas frescas a gusto\n" +
                "400 gr de queso fresco\n" +
                "1 cucharada de azúcar\n" +
                "Sal\n" +
                "Pimienta\n" +
                "Nuez moscada\n" +
                "½ taza de aceite de oliva",

            "250 gr de frijoles negros\n" +
                "110 gr de costillas de cerdo\n" +
                "90 gr de tocino o panceta ahumada\n" +
                "50 gr de longaniza ahumada\n" +
                "Condimento:\n" +
                "\n" +
                "1 Cebolla mediana picada\n" +
                "Cebolla de verdeo picada\n" +
                "2 hojas de laurel\n" +
                "1 ½ dientes de ajo picados\n" +
                "Comino\n" +
                "Aceite de oliva\n" +
                "Sal ",

            "150 g de maicena\n" +
                "100 g de harina 0000\n" +
                "80 g de azúcar\n" +
                "100 g de manteca\n" +
                "2 yemas de huevo\n" +
                "1 cucharadita de polvo para hornear\n" +
                "Esencia de vainilla\n" +
                "Dulce de leche\n" +
                "Coco rallado",

            "250G. harina 0000\n" +
                "-4 yemas\n" +
                "-50g. manteca\n" +
                "-1 cda. alcohol\n" +
                "-1 pizca sal\n" +
                "-75g. agua\n" +
                "-dulce de leche\n" +
                "\n" +
                "Para la cobertura:\n" +
                "-1 clara\n" +
                "-250g. de azúcar impalpable\n" +
                "-1 chorro de limón",
        "2 Pechugas de pollo (o pollo troceado)\n" +
                "1 Kg. de papas de diferentes tipos\n" +
                "1 Ramito de perejil\n" +
                "1 Ramito de cilantro\n" +
                "1 Cdita. de estragón\n" +
                "1 Choclo (maiz)\n" +
                "Alcaparras\n" +
                "Crema de leche\n" +
                "Sal\n" +
                "Para acompañar\n" +
                "\n" +
                "1 Palta (aguacate)\n" +
                "4 Pocillos de arroz blanco cocido",

        "250g. de porotos blancos\n" +
                "250g. de maíz blanco partido\n" +
                "1 chorizo colorado\n" +
                "1 chorizo criollo\n" +
                "Cuerito de cerdo\n" +
                "Pechito de cerdo\n" +
                "Falda\n" +
                "200g. de panceta\n" +
                "3 cebollas\n" +
                "2 cebollas de verdeo\n" +
                "1 puerro\n" +
                "1/2 calabaza\n" +
                "1/2 morrón rojo (para la salsita)\n" +
                "Condimentos: sal, pimienta, comino, pimentón, ají molido, orégano",
            )

        val detalleRecetaLista = listOf(

            "Preparar un bizcochuelo. Para esto, batir los 2 huevos y 100 gr. de azúcar hasta lograr una mezcla consistente. Por último incorporar los 100 gr. de harina con movimientos envolventes.\n" +
                    "Colocar la mezcla en un molde enmantecado y enharinado.\n" +
                    "Introducir el bizcochuelo en el horno a 180 °C. Hornear por 30 o 40 minutos. Una vez frío dividirlo en 3 capas.\n" +
                    "Para hacer crema chantilly: Batir la crema junto con 50 g de azúcar y la esencia de vainilla hasta montarla.\n" +
                    "Separar los duraznos y el almíbar se puede utilizar para remojar las capas de la torta chajá. \n" +
                    "Para rellenar el postre chajá primero se coloca una capa de dulce de leche repostero y sobre esta romper un poco del merengue.\n" +
                    "Colocar arriba la segunda capa de bizcochuelo y mojar un poco con el almíbar. Ahora incorporar una parte de la crema chantilly, reservando un poco para el final. Por encima de la crema colocar la mitad de duraznos cortados en rodajas.\n" +
                    "Para la última capa de bizcochuelo se repite el mismo procedimiento y se coloca la crema restante. Romper el resto de merengue para cubrir la torta por la superficie y decorar con el resto de los duraznos.\n" +
                    "Refrigerar por al menos 3 horas.",

            "En una ollita colocar los chiles y cubrir con agua. Hervir durante 15 minutos o hasta que estén suaves. Colar y dejar enfriar. \n" +
                    "Por otro lado, en una licuadora colocar los chiles junto con el jugo de piña, el vinagre con las especias y la pasta de achiote. Licuar hasta que se forme una salsa suave. Pasar la salsa por un colador o tamiz hasta obtener una textura suave. Probar y corregir sal si es necesario.\n" +
                    "En un bowl grande colocar la salsa y los filetes de carne (previamente condimentados con sal y pimienta). La carne debe marinar en esta salsa durante 4 hrs mínimo o si es posible toda la noche.\n" +
                    "Originalmente este plato se hace en el rostizador vertical, intercalando la carne con algunas rodajas de cebolla y piña. Ya cocida la carne, colocarla en una sartén caliente para darle ese sabor y dorar como lo hacen en las taquerías en México. Sin el rostizador vertical, también se podría cocinar al horno o en una sartén.\n" +
                    "Ya con el relleno listo. Preparar las tortillas calientes, cubrir con la cebolla picada, el cilantro, la piña y por último una salsa de su elección.",

            "Picar bien chiquito la cebolla, los pimientos.\n" +
                    "Para el relleno, sofreír toda la cebolla picada en la grasa bien caliente. Cuando comience a dorarse, añadir el pimentón picado y mezclar por 5 minutos.\n" +
                    "Cuando la cebolla cristalice, agregar las especias: el comino (no puede faltar), el pimentón rojo molido, la pimienta blanca.\n" +
                    "Cocinar las papas cortadas en cubos pequeños, en agua hirviendo, solo por 5 minutos.\n" +
                    "Revuelto todo, agregar la carne bien cortada. Mezclar todo y dejar que la carne se cocine a fuego bajo por 15 minutos. Agregar las papas y continuar. Retirar del fuego minutos antes de terminar la cocción y dejar enfriar.\n" +
                    "Mientras precalentar el horno a 250 °C.\n" +
                    "Agregar la cebolla de verdeo picada y los huevos duros picados justo antes de armar las empanadas. \n" +
                    "(No es necesario armar un guiso con esto, simplemente con una cuchara hay que tomar un poco de cada ingrediente y así ir armando las empanadas.)\n" +
                    "Cocinar en horno a 250 °C durante unos 12 minutos o freír en abundante grasa.",

            "Primero pre calentás el horno a 180°.\n" +
                    "Ponés a hervir el agua con la leche, la sal y el aceite. Apenas empiece a hervir apagás el fuego y añadis la fécula de una, se hace un engrudo tremendo pero vos seguí mezclando con una cuchara de madera.\n" +
                    "Dejás que se enfrie un toque (podés pasar la mezcla a un bowl si querés hacerlo más rápido) y le agregás el huevo. Se va a hacer un quilombo de nuevo, pero vos mezclá. (si el gordo te dice mezclá, mezclá)\n" +
                    "Por último le añadís el queso, unis todo y  untandote un poco de aceite en las manos, empezás a hacer las bolitas.\n" +
                    "Podés hacerlas más grandes para que sean tipo el “pao de queijo” brasilero o más chiquitas para los chipá clásicos.\n" +
                    "Los ponés en una fuente para horno, dejando espacio entre ellos porque crecen, y los horneás durante unos 20 o 25 minutos, o hasta que los veas bien dorados.\n" +
                    "Los dejás enfriar un toque (sí podés) y listo, a disfrutar de la receta de chipá caseros!",

            "Cortar la cebolla en tiras finas y rehogarlas en un poco de aceite. Que no lleguen a ponerse transparentes del todo, sino desaparecerán dentro de la sopa.\n" +
                    "Batir en un bol los huevos. Una vez que estén unidos agregar la leche. Seguir batiendo.\n" +
                    "Incorporar la harina de maíz, unir con batidor hasta que esté completamente integrada. Es fácil y no quedarán grumos.\n" +
                    "Incorporar las cebollas rehogadas y salpimentar.\n" +
                    "Agregar el queso, cortado en cubitos y unir bien sin que se rompa (quizás es mejor hacerlo con cuchara en esta parte).\n" +
                    "Colocar la preparación en una fuente apta para horno apenas untada con aceite.\n" +
                    "Llevar a horno moderado unos 30 minutos o hasta que veas la sopa paraguaya dorada por arriba.\n" +
                    "Dejar entibiar y cortar en cuadrados.",

            "Tamizar la harina sobre una superficie lisa. Luego por arriba agregar el polvo de hornear y el bicarbonato. Por último incorporar el azúcar tamizada y el chocolate (en caso de utilizar chocolate en polvo). Mezclar los ingredientes con las manos y luego formar una corona.\n" +
                    "En el centro sumar las 3 yemas y con la ayuda de las manos integrarlo todo de a poco. \n" +
                    "Por otro lado derretir la manteca junto con el chocolate (si es que utilizamos chocolate cobertura). Agregar esto a la preparación e ir uniéndolo con las manos. Cuando se logre una masa uniforme, envolverla en papel film e intentar aplastarla estirando un poco con las manos o con un palo de amasar. Llevar a la heladera por 10 minutos.\n" +
                    "Pasado el tiempo se debe sentir una masa más unificada y firme. Retirar el papel film y colocar la masa sobre una superficie lisa enharinada, con la ayuda de un palo de amasar estirar la masa de 1 cm de grosor y cortarla en porciones del tamaño y forma deseado.\n" +
                    "Colocar las tapas sobre una fuente para horno y llevarlas al congelador por 15 minutos. En este momento precalentar el horno a 180°.\n" +
                    "Pasado el tiempo hornear las tapitas controlando su cocción, por 10 minutos máximo.",

            "Precalentar el horno a 180°C y aceitar un molde. Saltear la cebolla en una sartén con aceite, hasta que esté transparente y tierna.\n" +
                    "En un recipiente grande, mezclar el maíz o choclo rallado, con la cebolla salteada, y la manteca derretida. Integrar bien. Incorporar los huevos, la leche, la nuez moscada y salpimentar a gusto. Mezclar bien. Agregar el queso fresco y mezclar nuevamente.\n" +
                    "Verter la mezcla en el molde asegurándose de distribuirla de manera pareja. Llevar a horno durante aproximadamente 40/45 minutos, o hasta que la preparación esté dorada en la parte superior y firme al tacto.\n" +
                    "Retirar y dejar enfriar durante unos minutos antes de cortarlo en porciones individuales.",

            "Lavar los granos de maíz blanco pisado y ponerlos a remojar en un bol o recipiénte hondo, llenándolo de agua hasta que todos los granos estén sumergidos. Lo dejamos reposar así durante toda la noche o al menos durante 10 horas (para los que alguna vez prepararon alguna receta de locro, es el mismo procedimiento).\n" +
                    "Luego de esas 10 horas de remojo, enjuagar nuevamente los granos de maíz y colocarlos en una olla con agua, que vamos a llevar a hervir durante 1 hora y media o dos aproximadamente (hasta que esté bien tierno). Si se evapora el agua vamos agregando.\n" +
                    "Ahora vamos a colar el maíz. Aquí está el único secreto de ésta receta de arepas colombianas: deben dejar que el maíz esté bien seco! Se tiene que ir toda el agua que tengan, para ésto vamos a colarlos varios minutos, revolver y dejar colándo de nuevo. Una vez que estén colados los vamos a pasar a un plato y volver a dejarlos reposar varios minutos, tienen que estár 100% secos.\n" +
                    "Con una procesadora o mixer vamos a triturar el maíz. En colombia ésto se hace con un “molino“, pero como la mayoría no tenemos ese artefacto vamos a hacerlo con la procesadora. Van a ver que a medida que lo procesan se va formando una especie de pasta o puré.\n" +
                    "Dado que la masa debe estar lo más fina posible para que las arepas queden con buena consistencia, luego de procesar el maíz vamos a pisar el puré obtenido con un pisapapas (de forma similar a como hacemos el puré tradicional). Repetir varias veces hasta que la masa quede lisa.\n" +
                    "Agregar sal y un buen chorro de aceite de oliva. Mi cuñada colombiana en ésta parte le agrega queso rallado, pero es opcional. Ya tenemos la masa lista!\n" +
                    "Reservar a un lado un bol o recipiente con agua. Vamos a utilizar el agua para mojarnos las manos mientras vamos armando las arepas, y el agua evitará que la masa se nos pegue.\n" +
                    "Armar las arepas dándole una forma similar a la de una hamburguesa (puede variar a su gusto). Si quieren rellenarlas con queso, simplemente agregan en el medio una pequeña feta de queso. Éstas arepas se pueden congelar antes de cocinarse, así que éste es el momento perfecto para meterlas en el freezer si querés guardar algunas. Se cocinan super rápido, yo las uso para el desayuno!\n" +
                    "Para cocinarlas, las llevamos a la plancha o si no tienen pueden hacerlo en una sartén. Si las arepas están congeladas, esperar unas 7-8 minutos antes de darlas vueltas (no intentarlo antes porque se rompen). Cocinarlas vuelta y vuelta hasta que estén bien doradas de los dos lados.\n" +
                    "Otro dato: si no las rellenaron crudas y quieren comerlas rellenas, pueden abrirlas al medio con un cuchillo y rellenarlas a su gusto. En el video pueden ver cómo las rellené con pollo.",

            "En un recipiente colocar el agua junto con la sal y el aceite de oliva. Mezclar e ir agregando la harina de a poco mientras se continúa removiendo.\n" +
                    "Una vez incorporada toda la masa comenzar a mezclar con las manos mientras la harina va absorbiendo el líquido. Si es necesario agregar un poco más de harina y la textura final tiene que ser parecida a un puré de papa moldeable. Cuando se logre la consistencia deseada dejar en reposo por 10 minutos.\n" +
                    "Pasado el tiempo, con la ayuda de las manos agarrar bolas de la masa para comenzar a darles forma redondeada y luego plana. Repetir este proceso con toda la masa.\n" +
                    "Calentar una sartén con un poco de aceite en la base y cuando esté caliente colocar de a una o dos las arepas. Cocinar a fuego medio por 5-7 minutos.\n" +
                    "Pasado el tiempo darlas vuelta y cocinar por 10 minutos más. Luego repetir el proceso de cocción con toda la masa.\n" +
                    "Ya estarán listas para rellenar y comer.",

            "Cortar el pejerrey en trozos chicos, de 2x1cm. más o menos. El pescado debe estar sin sus aletas duritas, ni cola ni cabeza y sobre todo muy fresco.\n" +
                    "\n" +
                    "Colocar el pescado en una fuente, salpimentar y agregar el ají amarillo licuado o la pasta de ají amarillo. \n" +
                    "\n" +
                    "La cebolla morada la van a cortar muy muy finamente. Agregar muy poquito de esta cebolla al pescado.\n" +
                    "\n" +
                    "Agregar también el chile picante súper picadito y un poquito de cilantro picado, mezclar todo bien.\n" +
                    "\n" +
                    "Incorporar finalmente el jugo de los limones y mezclar.\n" +
                    "\n" +
                    "Yo lo serví sobre una rodaja de batata cocida como suele hacerse. Al servirlo le agregás más cebolla por encima y más cilantro.",

            "Pelar los plátanos y cortarlos en rodajas gruesas. Freír en aceite hasta que estén dorados. Reservar.\n" +
                    "Freír los chorizos y las morcillas hasta que se doren. Reservar.\n" +
                    "Para hacer el hogao: en una sartén grande saltear la cebolla, el tomate y el ajo hasta que espesen y se forme una salsa. Mezclar el hogao con los porotos.\n" +
                    "En una sartén aparte, hacer los huevos fritos.\n" +
                    "Calentar las arepas en una plancha o sartén.\n" +
                    "Calentar la carne cocida, el arroz y los porotos. Salpimentar a gusto. \n" +
                    "En 4 bandejas, colocar todos los ingredientes: los porotos rojos, el arroz, los plátanos, el chorizo, la morcilla, la carne picada, la arepa, la palta y el huevo. ¡Servir caliente y a disfrutar!",

            "Mezclar la harina con la sal en un bol y añadir el agua, mezclando con una cuchara hasta que se empiece a formar una masa.\n" +
                    "Llevar la masa a una superficie plana y comenzar a amasar bien con las manos hasta conseguir una masa lisa.\n" +
                    "Dividirla en porciones de 50 gramos y formar bolitas.\n" +
                    "Con ayuda de un palo para amasar estirar cada bolita hasta formar una tortilla de unos 20 cm de diámetro.\n" +
                    "Calentar una sartén de fondo grueso a fuego alto y cuando consiga su máxima temperatura le bajas un poco para no quemarlas. Colocar una tortilla sobre la sartén caliente y cuando se levanten los bordes se da la vuelta. Cuando empieza a hincharse formando burbujas se vuelve a dar la vuelta por unos segundos más.\n" +
                    "A medida que van saliendo de la sartén deben quedar envueltas en un trapo de algodón para que se mantengan calentitas.",

            "Colocar en un bol los camarones cortados en trozos pequeños. Exprimir jugo de limón encima hasta que estén completamente cubiertos y dejar marinar durante unos 15-20 minutos en el refrigerador. \n" +
                    "Después de la marinación, los camarones deberían haber adquirido un color rosado y una textura firme. Escurrir el exceso de líquido y colocar los camarones en otro bol limpio. Agregar el tomate, la cebolla, el chile, el cilantro y una pizca de sal. Mezclar bien todos los ingredientes hasta que estén combinados.\n" +
                    "Probar el ceviche y rectificar los sabores agregando más sal o jugo de limón si es necesario. Tomar las tostadas de maíz y colocar una generosa cantidad de ceviche sobre cada una de ellas. Decorar las tostadas con rodajas de aguacate, cilantro picado y un poco de salsa picante. ",

            "En la mesada directamente hacer una corona con la harina y en el centro colocar la mantequilla en pomada, el huevo, sal y azúcar.\n" +
                    "Incorporar de a poco la harina desde los bordes; a la vez añadir agua templada de a poco. Controlar la cantidad de agua, ya que esto dependerá del tipo de harina que se use. \n" +
                    "Trabajar con las manos hasta conseguir una masa elástica y suave.\n" +
                    "Tapar y dejar reposar en la heladera por 45 minutos. Mientras tanto, cortar el queso duro en tiras o bastoncitos del tamaño deseado y reservar en la heladera.\n" +
                    "Espolvorear un poco de harina sobre la mesada y dividir la masa en varias bolitas pequeñas\n" +
                    "Con la ayuda de un palo de amasar estirar la masa y cortar en tiras iguales.\n" +
                    "Con esas tiras enrollar el queso cubriéndolo completamente y cerrar bien pegando los extremos con la masa.\n" +
                    "Calentar el aceite a fuego alto en un sartén para freír. Cuando el aceite esté caliente bajar el fuego a medio. \n" +
                    "Con cuidado, fríe los tequeños hasta que estén doraditos y crujientes. Al retirarlos secar con papel absorbente de cocina eliminando así el exceso de aceite\n" +
                    "Ya tenés lista la salsa en la que los vas a untar? Cuidado que son adictivos!",

            "Rallar los choclos o desgranarlos y luego mixearlos. Debe quedar como una crema. Reservar.\n" +
                    "Cocinar la calabaza y hacer un puré. Reservar.\n" +
                    "Calentar el aceite de oliva en una olla y agregar la cebolla y el pimiento morrón cortado bien pequeño. Cocinar hasta que la cebolla esté transparente. Agregar el tomate cortado en cubitos junto a la cebolla de verdeo cortada bien fina. Salpimentar y bajar el fuego a mínimo.\n" +
                    "Añadir los choclos triturados y cocinar por 5 minutos. Agregar el puré de calabaza, una cucharada de azúcar, salpimentar y condimentar a gusto.\n" +
                    "Cocinar a fuego bajo hasta que espese, unos 10 minutos más aproximadamente. En el caso que se seque mucho agregar un poco de leche.\n" +
                    "Una vez listo retirar del fuego y mezclar con queso fresco en cubos hasta que se derrita.\n" +
                    "Servir en cazuelas con verdeo o ciboulette por encima. ",

            "Cortar en cuadrados medianos las carnes y colocar en una olla con abundante agua caliente. Cocinar por 10 minutos.\n" +
                    "En otra olla colocar 1 cda. de aceite de oliva y en ese lugar rehogar las cebollas con una cda. de sal. A fuego fuerte por 8 minutos. Luego incorporar aquí los dientes de ajo, las hojas de laurel y 1 cdita de comino.\n" +
                    "Colocar los porotos remojados arriba de la cebolla y cubrir con 1 ½ de agua caliente. Cuando el agua hierva incorporar las carnes. Cocinar esto a fuego medio por 2 horas. Remover cuidadosamente cada un rato. \n" +
                    "Servir junto a la guarnición de preferencia.",

            "En un bol de su preferencia, vamos a poner la manteca (a temperatura ambiente), el azúcar y unas gotitas de esencia de vainilla. Vamos a mezclar todo hasta que esté bien incorporado. Pueden utilizar una batidora eléctrica o hacerlo a mano.\n" +
                    "Una vez que tengamos armada una especie de pomada, vamos a agregar las dos yemas de huevo y vamos a volver a batir.\n" +
                    "Llegó el momento de incorporar la harina y nuestra protagonista, la maicena. Si pueden hacerlo con un tamizado de por medio, mucho mejor. También vamos a agregar una pizca de polvo para hornear.\n" +
                    "Ahora sí, vamos a meter mano en el asunto. En el bol hasta que los ingredientes secos esté bastante incorporados con los húmedos y luego vamos a continuar en la mesada hasta que nos quede una masa bien homogénea.\n" +
                    "Vamos a dejar reposar nuestra masa unos 15 minutos aproximadamente.\n" +
                    "La técnica de los capos\n" +
                    "Pasado este tiempo, vamos a pasar al estirado de la masa. Para eso vamos a utilizar lo que en este canal nos gusta llamar: La técnica de los capos consiste en lo siguiente: Vamos a estirar una buena cantidad de papel film sobre la mesada. Por encima, colocamos nuestro bollo y luego por encima otra buena cantidad de papel film. Así, entre estas dos láminas, vamos a proceder a aplastar y estirar nuestra masa. Primero con las manos y luego con el palo de amasar hasta que esté bastante chatita.\n" +
                    "Retiramos la parte de arriba del film y con un cortante redondo (también pueden usar cosas similares como un vaso) procedemos a armar nuestras tapitas y a medida que lo vamos haciendo, las vamos colocando en un recipiente para horno. Tengan mucho cuidado al manipular las tapitas porque la masa es muy sensible y se pone a llorar por cualquier cosa. Van a ver que les sobra masa, en ese caso la vuelven a juntar, a estirar  y así sacan más alfajores de maicena.\n" +
                    "Antes de llevarlas al horno y mientras este se calienta, vamos a llevar la masa a la heladera unos minutos.\n" +
                    "Pasado este tiempo, las llevamos al horno 180º por aproximadamente 10 minutos. Tengan en cuenta que la temperatura del horno es muy importante para que no queden demasiado secos.\n" +
                    "Una vez que vean que las tapitas están doraditas, las vamos a sacar. Una vez que estén frías, armamos nuestros alfajores de maicena colocando dulce de leche repostero sobre una tapita y colocando otra por encima. Si lo desean, pueden agregarle el coco rallado por al rededor. ¡Y listo!",


            "1- En un bol volcamos la harina y le agregamos 4 yemas. Las claras las dejamos aparte.\n" +
                    "\n" +
                    "2- Agregamos la manteca pomada y una cucharada de alcohol etílico. También agregamos el agua tibia.\n" +
                    "\n" +
                    "3- Mezclamos hasta que se integre bien, y una vez que esté unido, lo bajamos a la mesada y comenzamos a amasarlo. Es necesario amasar este bollo durante 10 minutos. Esto es para que quede bien bien el punto. Pueden ir agregando harina para que no se pegue, pero no se zarpen.\n" +
                    "\n" +
                    "4- Una vez pasados los 10 minutos, van a tener un bollito hermoso y suavecito. La volvemos a meter en el bol, la tapamos con papel film y la llevamos a la heladera durante 30 minutos.\n" +
                    "\n" +
                    "5- Al salir de la heladera, colocamos un poquito de harina en la mesada y en el palo de amasar, y comenzamos a estirarla. Tiene que quedar bien bien finita.\n" +
                    "\n" +
                    "6- Ahora, con un vaso, vamos a ir cortando las tapitas de nuestra masa estirada. Si les sobra masa, la juntan, la vuelven a estirar y vuelven a cortar.\n" +
                    "\n" +
                    "7- Al tener todas las tapitas, lo que vamos a hacer es ir pinchando con un tenedor cada una mientas la estiramos un poquito para que quede con una forma más ovalada.\n" +
                    "\n" +
                    "8- Las colocamos en una plancha y las llevamos al horno 180º por 10 minutos. Cuando estén, las sacamos y vamos a dejarlas enfriar.\n" +
                    "\n" +
                    "9- Toca hacer el glasé: Es con una de las claras que reservamos al comienzo. La tenemos en un bol y ahí vamos a agregar un par de cucharadas del total de azúcar impalpable que tenemos. Vamos a batir levemente hasta que se una bien. Una vez unido, lo llevamos al microondas 10 segundos. Al sacarlo, volvemos a revolver y vamos a llevarlo otros 10  más al microondas. Al sacarlo, vamos a agregar el resto del azúcar y un poco de jugo de limón. Mezclamos y unimos bien. Es necesario, para poder bañar todas nuestras colaciones y que el merengue no se endurezca, mantenerlo a baño maría mientras arman estas golosinas argentinas.\n" +
                    "\n" +
                    "10- Con el merengue hecho y las galletitas ya frías, vamos a proceder al armado de estas golosinas: Agarramos galletita por galletita, las untamos con una buena cucharada de dulce de leche y las sumergimos en el merenque para que ésta las cubra. Pueden hacerlo en su totalidad o solamente media galletita. Dejan enfriar unos minutos ¡y listo! Si lo desean, también se le puede poner nuez.",

            "1) Trocear el pollo y salpimentar. Poner a hervir en agua salada. Cuando rompa el hervor, retirar con una espumadera la espuma que se forma arriba. Cocer el pollo hasta que esté tierno (unos 20 minutos). Retirar de la olla y reservar.\n" +
                    "2) Cortar las papas en rodajas de diferentes tamaños. Poner a hervir en el caldo de pollo. Agregar el choclo cortado en rodajas de unos 3 cm. Hervir a fuego bajo.\n" +
                    "3) Cuando las papas más grandes estén casi listas, retirar una taza y media de papas (tratar de que sean de las más finas) y triturar con mixer. Volver a la olla este puré e integrar. Esto es lo que dará al ajiaco colombiano el carácter espeso que suele darle la papa criolla.\n" +
                    "4) Picar el perejil, el cilantro y el estragón bien pequeños y agregar al caldo. Terminar de cocer unos 10-15 minutos más.\n" +
                    "5) Para servir el ajiaco colombiano, hacer lo siguiente: desmechar el pollo en tiras y poner en el fondo de la cazuela. agregar por encima la preparación espesa de la olla. Colocar un chorro de crema de leche por encima y una cucharada de alcaparras en el centro. Acompañar con arroz blanco y un trozo de palta.",

            "Preparar los ingredientes: Cortar las carnes como te indico en el video (en trozos pequeños), las verduras en rodajas bien bien finitas, la calabaza en cubos y una parte rallada y los porotos y el maíz remojados desde la noche anterior.\n" +
                    "Desgrasar: el chorizo y el cuerito en una olla y el chorizo colorado en otra. Llevarlos al fuego 10-15 minutos hasta que hierva. \n" +
                    "Integrar: en una olla caliente colocar la panceta para que largue su grasa, luego agregar la cebolla de verdeo, el puerro, sal, aceite de oliva y saltear todo. Una vez blandito agregar el chorizo colorado, los cueritos de cerdos, el chorizo, el maíz pisado blanco y los porotos blancos (ambos bien escurridos previamente) y agregar agua.  Es importante que el agua no sea la del remojo de los porotos y el maí. Tapar y dejar cocinar 1 hora y media en olla común (revolviendo de vez en cuando y viendo si le falta más agua) o 1/2 hora en olla a presión.\n" +
                    "Agregar: A la olla con todos los ingredientes agregarle la calabaza cortada en cubos, el pechito, la falda, los condimentos, un poco más de agua y revolver bien. Dejar nuevamente 1/2 hora en olla a presión o una hora y media mas en olla común. \n" +
                    "Preparar la salsita: picar el morrón, 1 cebolla de verdeo y 1 cebolla común bien bien finitos. Agregar ají molido (bastante si la queres más picante), pimentón y orégano. Cocinar a fuego bajo en bastante aceite de oliva hasta que esté bien blandita la cebolla.\n" +
                    "Espesar y servir: Agregarle al locro la calabaza rallada que separaste al principio y dejar 10 minutos mas. Pasado ese tiempo servir con la salsa encima y la parte verde de la cebolla de verdeo picada. Si te sobra, podes freezarlo.",
        )



        if(receta?.id != null){
            val posicion = receta.id.toInt()
            detalle = findViewById(R.id.detalleRecetaDA)
            detalle.text = "Ingredientes: \n" + ingredientesLista[posicion - 1].toString() + "\n \nPreparacion: \n" +  detalleRecetaLista[posicion - 1].toString()
            detalle.movementMethod = LinkMovementMethod.getInstance()
        }
        else
        {
            Toast.makeText(this, "Error receta", Toast.LENGTH_LONG).show()
        }

    }
}

/*
LINK RECETAS

1	https://www.paulinacocina.net/postre-torta-chaja/26050
2	https://www.paulinacocina.net/tacos-al-pastor-receta-original/28669
3	https://www.paulinacocina.net/receta-empanadas-saltenas/25274
4	https://www.paulinacocina.net/receta-de-chipa-caseros/8953
5	https://www.paulinacocina.net/receta-de-sopa-paraguaya/7132
6	https://www.paulinacocina.net/alfajor-artesanal/27258
7	https://www.paulinacocina.net/chipa-guazu/30586
8	https://www.paulinacocina.net/arepas-venezolanas/26894
9	https://www.paulinacocina.net/receta-arepas-colombianas-queso/10449
10	https://www.paulinacocina.net/receta-ceviche-de-pejerrey/9600
11	https://www.paulinacocina.net/bandeja-paisa-colombiana/30201
12	https://www.paulinacocina.net/burritos/25231
13	https://www.paulinacocina.net/tostada-de-ceviche/31497
14	https://www.paulinacocina.net/tequenos-venezolanos-de-queso/24759
15	https://www.paulinacocina.net/humita-en-olla/26534
16	https://www.paulinacocina.net/feijoada/26719
17	https://www.paulinacocina.net/alfajores-de-maicena-receta-facil-casera-y-deliciosa/20379
18	https://www.paulinacocina.net/golosinas-argentinas-colasiones-cordobesas/20555
19	https://www.paulinacocina.net/ajiaco-inmigrante/1521
20	https://www.paulinacocina.net/receta-de-locro-argentino/9829

*/