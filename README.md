#EJERCICIO PROPUESTO por ias-Arquitectura GestionEventos: este ejercicio fue realizado con java, spring boot, bd en h2.

#Este ejercico esta construido con el patron arquitectonico Modelo-Vista-Controlador (MVC),  repositorio de la vista => https://github.com/lugox10/gestion-Eventos-frontend (NO terminado) creada con Angular

#paradigma de programacion orientada a objetos(OOP).

#Se creo la estructura tratando de seguir los prinsipios de programacion SOLID y sus pilares fundamentales. Clean Arquitecture , Camelcase.

#Esta es la estructura: se crearon los paquetes Modelo,repositorio,servicio,controlador ,configuracionCcontolador.
#![estructura del proyecto](https://github.com/user-attachments/assets/4d6f1d77-b99e-4954-870f-4cb89e37ad1c)

#Clase "Evento" del paquete "modelos" 
#![clase evento](https://github.com/user-attachments/assets/d1cfb468-15cd-4b25-b29a-3e7538ad7f88)
#Clase Enum "TipoDeLugares" del paquete "modelos
#![clase enum TipoDeLugares](https://github.com/user-attachments/assets/a5ef4e22-0eb3-4c4c-9b89-9d89b6d13c9b)
#Clase Enum "TipoDeEventos" del paquete "modelos
#![clase enum TiposDe Eventos](https://github.com/user-attachments/assets/dd8c0c71-1f9a-405e-afb3-8b5bb0b91375)

#metodo CrearEvento() de la clase "EventoControlador" del paquete "controladores" guardando exitosamente ok (200)
#NOTA:CUANDO EL USUARIO DESDE LA VISTA DA SUS VALOSRES YA PROPUESTOS POR LOS ENUMS COMO SON TipoDeLugares y TipoDeEvento EL SISTEMA TE AGREGA AUTOMATICAMENTE ESOS VALORES MEDIANTE UNA BARRA DEPLEGABLE IMPLEMENTADA EL EL REPOSITORIO DEL FRONT-END
![metodo crearEvento](https://github.com/user-attachments/assets/9f57e8ba-a528-4891-b07d-b9dacd8cccdf)

#metodo obtenerTodosLosEventos() de la clase "EventoControlador" del paquete "controladores" listando los eventos guardados exitosamente ok (200)
#![LISTA DE EVENTOS REGISTRADOS](https://github.com/user-attachments/assets/ba11376c-ecaa-48dc-adc1-6ce735374945)

#NOTA:Esto es lo que llevo provado Hasta el momento. ya que actualice unas interfaces y repositorios que no seguian los lineamientos propuestos por el Dep de Arquitectura.
#gracias por las observaciones y recomendaciones, y ala espera de nuevos ejercicios y o requerimientos en este proyecto, mientras tratare de culminarlo o finalizarlo con las otras clases propuestas asi como las implementaciones de validaciones, jwt y docker 



