# Gestion-de-Aeropuertos
 
GESTIÓN DE AEROPUERTOS

                                                                            P13 Sergio Salgado, Jon Ibarreche


Resumen/Funcionalidad
	
    Programa que gestiona los aeropuertos a nivel europeo con interfaz tanto a nivel de usuario como de administrador. Es capaz de visualizar todos los aviones disponibles en cada aeropuerto además de una amplia variedad de opciones para ser capaz de saber los datos completos del vuelo, así como conocer los usuarios correspondientes.

    Por un lado, se le proporciona una buena experiencia al usuario debido a la interfaz cómoda y fácilmente entendible, puesto que cuenta con una diferenciación clara en cada uno de los apartados que el usuario deberá rellenar para comprar un vuelo. 

    Por otro lado, gracias al motor de búsqueda implementado, se podrán visualizar más vuelos en el menor tiempo posible. Cuenta con los horarios completos que cada Aerolínea proporciona a nuestra aplicación con el fin de llegar a satisfacer la demanda de vuelos en un periodo en particular.

    Además, disponemos de un método de pago totalmente seguro para efectuar de manera rápida el importe del billete deseado. 

	Finalmente, la aplicación es capaz de adaptarse a cualquier tipo de usuario ya que provee una gran variedad de opciones, destinos, horarios, fechas, funcionalidades, etc… Todo esto y más, siendo de libre acceso para el consumidor.

Producto Mínimo Viable

    1) Administrar los vuelos disponibles.
    2) Crear nuevos vuelos en función de las necesidades 
    3) Buscador de vuelos 
    4) Comprar billetes de avión.
    5) Visualizar datos del vuelo/usuario correspondiente

Características extras
    i)Comparar precio los vuelos disponibles 
    ii)Crear escalas en diferentes aeropuertos



Ideas de interfaz

    Ventana Login:
        Usuario/Contraseña
        Botón de Registro
        Botón de Inicio de sesión

    Ventanas del admin:
        Mapa Europa (parte izquierda)
        Visualizar datos de vuelos, etc… seleccionando desde el mapa un posición (en principio, seleccionando 1 país) 
        Lista de Aeropuertos/Vuelos
        Editar vuelos 

    Ventanas del usuario:
        Origen
        Destino
        Botón ida/ida-vuelta
    VentanaIDA
        Fecha Ida
    VentanaIDAyVUELTA
        Fecha Ida y Vuelta
        Botón “Buscar”


VENTANA LOGIN

	Ventana para que los usuarios puedan darse de alta en la aplicación. La información requerida es el Usuario y la contraseña. En función de si el usuario que inicia sesion es Administrador o no, se mostrará la ventana correspondiente. [Foto]



VENTANAS DEL ADMINISTRADOR

    Ventana Admin

        En la parte izquierda de la ventana se encontrarán las funcionalidades. Primero, habrá una lista desplegable (JComboBox) en la que se seleccionará el aeropuerto deseado, al pulsar en una de las opciones, el mapa se actual se actualizará. (Ej; Eliges la opción “Aeropuertos de España” y el mapa se actualiza y pasa a tener el mapa de España en un primer plano).

        La lista nos mostrará todos los vuelos del país seleccionado, con la información del vuelo.(aeropuerto origen, aeropuerto destino, fecha del vuelo, hora del vuelo y el número de pasajeros).En la parte de la derecha se encuentra el mapa de Europa. Se podrá actualizar en función de la opción de aeropuerto elegida en la parte de la izquierda. Debajo del mapa estarán los botones “Editar” y “Borrar”. 

    Ventana Editar

	    El botón “Editar” abre un ventana con los datos de los vuelos (Aeropuerto Origen, Aeropuerto destino, Fecha, Hora, Número de pasajeros), dentro habrá un botón “Pasajeros” que abre la Ventana Pasajeros. 

    Ventana Pasajeros 

        En esta ventana se visualizan los usuarios y donde se podrá cambiar la cantidad de equipaje, la clase de viaje (Económica, Business, Primera) y por último las 2 ventanas tienen un botón de “Guardar” para poder actualizar todos los cambios realizados anteriormente.



VENTANAS DEL USUARIO

    Ventana Inicio

        El usuario dispone de una ventana inicial donde buscar el vuelo idóneo y al mejor precio en base a sus condiciones de búsqueda. Aquí el usuario podrá seleccionar las opciones de búsqueda. En caso de que el vuelo sea simplemente de ida solo aparecerá una fecha de origen a rellenar, sin en el caso contrario selecciona que quiere un billete de ida y vuelta, aparecerán dos opciones, una para la fecha de ida y otra para la de vuelta. Una vez el usuario presione el botón buscar, se abrirá la ventana de búsqueda.

    Ventana Búsqueda
	
	    En la ventana de búsqueda se mostrará el billete que más se adecue a sus necesidades junto en el que verá además a que hora está disponible el vuelo. Lo único que tendría que hacer el usuario sería revisar los datos y darle a comprar para proceder al pago, para ello se abrirá la ventana pago de forma emergente.

    Ventana Pago

	    En esta ventana, el usuario introduce los datos necesarios para llevar a cabo la compra del billete. Es necesario introducir; Nombre, Apellidos, Numero de tarjeta, dia/mes de caducidad y CVV. A continuación con el botón “Pagar” se efectúa el pago al la cuenta bancaria.Una vez el pago se haya realizado correctamente se cerrará la ventana de pago y nos avisará de que la compra se ha realizado con éxito.



Base de datos
	
	    En cuanto a los elementos que componen la tabla de la base de datos que vamos a usar estan: id, idUsuario, origenVuelo, destinoVuelo, horaSalida, horaLlegada, aeropuertoOrigen, aeropuertoLlegada, claseVuelo, pasajerosVuelo
	
	    Empieza con la lectura de la BD, donde se lee un archivo de importación, el método privado lee un archivo que lo utiliza para importar. Después viene la escritura de BD, en el que se guarda dentro de la BD los elementos que deseamos. A continuación, se modifica la BD, se crean métodos para poder actualizar los datos de los vuelos y todos los mencionados. Por último está la eliminación de datos de la BD.

