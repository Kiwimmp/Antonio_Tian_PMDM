# Antonio_Tian_PMDM
## 1.Analisis de la estructura de proyecto

App Module: El módulo principal de la aplicación. Contiene todas las clases de código fuente, recursos y archivos relacionados con la aplicación.

res/ directory: Esta carpeta contiene todos los recursos de la aplicación, como diseños XML, imágenes, archivos de valores (strings, estilos, dimensiones, etc.).

src/ directory: Aquí se encuentra el código fuente de la aplicación, organizado en paquetes y clases. El código se divide en archivos .kt (Kotlin) y, en algunos casos, archivos .java si se usa código Java.

build.gradle: Archivo de configuración del módulo donde se definen las dependencias, versiones de Android y otras configuraciones relacionadas con el proyecto.

AndroidManifest.xml: Archivo de configuración principal de la aplicación, donde se especifican permisos, actividades y otros componentes.

Gradle Scripts: Archivos de configuración del sistema de compilación Gradle.

imagen aqui:



## 2.Analisi del ciclo de vida de y El problema de la perdida de estado

El ciclo de vida de una actividad en Android comprende varios estados, como ***onCreate, onStart, onResume, onPause, onStop, onRestart y onDestroy***. Cada uno de estos métodos se llama en momentos específicos del ciclo de vida de la actividad. Puedes sobrescribir estos métodos en tu clase de actividad para ejecutar código personalizado en respuesta a estos eventos.

La clase MainActivity es una de las actividades de tu aplicación. En Android, una actividad representa una pantalla con la que el usuario puede interactuar. Veamos los archivos y métodos relacionados con esta actividad:

***MainActivity.kt:*** Este es el archivo de código fuente de la actividad principal. Contiene la lógica de la actividad, incluyendo la creación de la interfaz de usuario, la gestión del contador y la implementación de métodos del ciclo de vida.

***activity_main.xml:*** Este archivo XML define la interfaz de usuario de la actividad. En este caso, muestra un TextView y tres botones (btResta, btReset y btAdd).

***onCreate:*** Este método se llama cuando la actividad se crea por primera vez. En este método, se configura la interfaz de usuario y se establece un listener para el botón btAdd.

***onSaveInstanceState:*** Este método se utiliza para guardar el estado de la actividad antes de que se destruya, por ejemplo, durante un cambio de orientación. En este caso, se guarda el valor del contador.

***onRestoreInstanceState:*** Este método se utiliza para restaurar el estado de la actividad después de que se haya recreado. Aquí, se recupera el valor del contador y se actualiza el TextView.

## 3.Solucion a perdida de estado

La pérdida de estado en la aplicación se debe a que no se gestiona adecuadamente el estado del contador cuando la actividad se destruye y vuelve a crearse, como en cambios de orientación de la pantalla. Para solucionar este problema, ya has implementado el uso de onSaveInstanceState y onRestoreInstanceState para guardar y restaurar el estado del contador cuando la actividad se recrea.
imagen aquí:


## 4.Ampliación de Funcionalidad con ***Reset*** y ***Resta***

`
// Botón Resta
        btResta.setOnClickListener {
            comptador--
            binding.textViewComptador.text = comptador.toString()
        }
`

`// Botón Reset
        btReset.setOnClickListener {
            comptador = 0
            binding.textViewComptador.text = comptador.toString()
        }`
        

## 5.Aplicar El View Binding

1. Habilita View Binding en build.gradle:

`
android {
    namespace = "com.ieseljust.pmdm.comptador"
    compileSdk = 33
    buildFeatures {
        viewBinding = true
    }
`

2.Importa la clase de vinculación en la acticidad:

`import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding
`

3.Declara una variable lateinit para la clase de vinculación:

`private lateinit var binding: ActivityMainBinding
`

4.Actualiza la configuración de layout:

`override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)`

5.Accede a los elementos de la interfaz a través de la clase de vinculación:

`binding.textViewComptador.text = comptador.toString()
binding.btAdd.setOnClickListener {
    comptador++
    binding.textViewComptador.text = comptador.toString()
}`


