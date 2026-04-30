El proyecto tiene una arquitectura simple, la app java sigue el MVC(Modelo,Vista,Controlador).

\-El modelo contiene clases como(Usuario,Producto) y luego tiene algo de lógica de los productos en la clase (GestionStock).

\-En resources están los archivos .fxml que contienen los paneles de la interfaz gráfica de la app. En resources también está el archivo datos.xml y esquema.xsd los cuales van a ser vinculados con el código para así poder trabajar con ellos y servir como “Base de datos”.

\-Los Controladores sirven para gestionar las acciones del usuario. Y contienen clases como (AdminControler, LoginController, UserController).

\-En Util hay dos clases XMLUtil sirve para trabajar con los datos(guardar datos, leerlos.) y DataHolder que sirve para la información que hay entre una pantalla y otra.

Las mejoras que hice y que corresponden a MPO son las siguientes. He separado todo por capas con las carpetas que he visto adecuadas, he separado la lógica de datos, de las pantallas, los modelos y todo esto para que así sea más fácil darte cuenta de los errores que se van teniendo y en caso de querer modificar algo en un futuro que se pueda hacer más fácil, también he usado la encapsulación en  los atributos de Usuario y Producto ya que los puse privados.También incorporé un sistema de validación con el archivo esquema.xsd para que el archivo datos.xml siempre tenga el formato que yo quiero.

