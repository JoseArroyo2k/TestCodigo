import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testcodigo.R

class MainActivity : AppCompatActivity() {

    private val miLista = mutableListOf<String>() // Declaración de la lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Manejo de variables y condicionales
        val number = 10
        if (number > 0) {
            println("El número es positivo")
        } else {
            println("El número es cero o negativo")
        }

        // Bucles (For loop)
        for (i in 1..5) {
            println(i)
        }

        // Operaciones matemáticas simples
        val suma = 5 + 3
        val resta = 10 - 4

        println("La suma es: $suma")
        println("La resta es: $resta")

        // Trabajando con funciones y parámetros
        val resultado = sumaDosNumeros(8, 12)
        println("El resultado de la función es: $resultado")

        // Uso de Intent para pasar datos entre Activities
        val intent = Intent(this, OtraActivity::class.java)
        intent.putExtra("dato", "Este es un dato enviado a la otra Activity")
        startActivity(intent)

        // Manejo de la lista
        val botonAgregar = findViewById<Button>(R.id.boton_agregar)
        botonAgregar.setOnClickListener {
            agregarElementoALista() // Llama a la función al presionar el botón
        }

        val botonImprimir = findViewById<Button>(R.id.boton_imprimir)
        botonImprimir.setOnClickListener {
            imprimirLista() // Llama a la función al presionar el botón
        }
    }

    private fun sumaDosNumeros(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    // Función que agrega un elemento a la lista
    private fun agregarElementoALista() {
        val nuevoElemento = "Elemento ${miLista.size + 1}" // Genera un nuevo elemento
        miLista.add(nuevoElemento) // Agrega el nuevo elemento a la lista
    }

    // Función que imprime el contenido de la lista
    private fun imprimirLista() {
        println("Contenido de la lista:")
        for (elemento in miLista) {
            println(elemento) // Imprime cada elemento de la lista
        }
    }
}

class OtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otra)

        // Recibiendo datos de la Activity anterior
        val datoRecibido = intent.getStringExtra("dato")
        println("Dato recibido: $datoRecibido")

        // Uso de ciclo de vida de Activity (ejemplo de onResume)
        override fun onResume() {
            super.onResume()
            // Acciones al retomar esta Activity
        }
    }
}
