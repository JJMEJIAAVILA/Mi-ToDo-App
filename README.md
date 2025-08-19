# Mi Lista de Tareas 📝

Una aplicación de lista de tareas sencilla y eficiente para Android, creada para ayudarte a organizar tus actividades diarias. Con esta app, puedes añadir, eliminar y marcar tareas como completadas de forma rápida y fácil.

## 🌟 Características

* **Añadir Tareas:** Escribe una tarea y presiona "Agregar" para que se añada a la lista.
* **Gestión de Tareas:** Marca una tarea como completada usando el `CheckBox` y se tachará el texto para una referencia visual clara.
* **Eliminar Tareas:** Usa el botón "Eliminar" para borrar tareas que ya no necesitas.
* **Persistencia de Datos:** Las tareas se guardan de forma local usando una base de datos **SQLite**, por lo que se mantienen guardadas incluso si cierras la aplicación.
* **Diseño Sencillo y Limpio:** Una interfaz de usuario intuitiva que te permite concentrarte en lo que es importante: tus tareas.

## 🛠️ Tecnologías y Conceptos Aplicados

* **Tecnologías Utilizadas:**
    * **Kotlin:** Lenguaje principal de programación.
    * **Android Studio y SDK:** Entorno de desarrollo oficial y kit de desarrollo.
    * **SQLite:** Base de datos local.
    * **RecyclerView:** Para mostrar la lista de tareas.
    * **Git:** Utilizado como sistema de control de versiones.
* **Metodología y Arquitectura:**
    * **Patrones de Diseño:** Aplicados según la arquitectura del software por componente.
    * **Capas de la Aplicación:** El proyecto se estructura en capas (presentación, lógica de negocio y datos) para una mejor organización y mantenimiento.
    * **Componentes Reutilizables:** Se han creado componentes como `TaskAdapter` para la lista de tareas, promoviendo la reutilización de código.
* **Buenas Prácticas de Desarrollo:**
    * **División de Módulos:** El código se ha dividido en paquetes con nombres claros (`com.jhonjairo.mytodoapp.Task`, `com.jhonjairo.mytodoapp.TaskAdapter`, etc.).
    * **Codificación Limpia:** Se sigue una codificación clara y legible para facilitar la colaboración.

## 🗺️ Requisitos y Diagramas

* **Requisitos del Sistema:** Se debe conocer el funcionamiento de Android Studio y su SDK, y contar con un dispositivo virtual o físico para pruebas.
* **Diagrama de Clases:** (Se describe en el código fuente: `Task`, `TaskAdapter`, `TaskDatabaseHelper`, `MainActivity`).
* **Diagrama de Paquetes:** La estructura de paquetes es `com.jhonjairo.mytodoapp`, que contiene las clases principales y los componentes de la aplicación.
* **Mapa de Navegación:** El flujo es lineal: la aplicación abre la pantalla principal que contiene la lista de tareas y las opciones para agregar o eliminar.

## 🚀 Cómo Empezar

Si quieres probar la aplicación o contribuir al proyecto, sigue estos pasos:

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/JJMEJIAAVILA/Mi-ToDo-App.git](https://github.com/JJMEJIAAVILA/Mi-ToDo-App.git)
    ```
2.  **Abre en Android Studio:**
    Abre el proyecto en Android Studio. El IDE se encargará de sincronizar las dependencias de Gradle automáticamente.
3.  **Ejecuta la aplicación:**
    Conecta un dispositivo Android o usa un emulador, y haz clic en el botón `Run` (el triángulo verde) en la barra de herramientas.

## 🧑‍💻 Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras un error o tienes una idea para una nueva característica, no dudes en abrir un *issue* o enviar un *pull request*.