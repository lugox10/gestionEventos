package com.ias.gestioneventos.configuracionCors;
import java.time.LocalDateTime;


//ESTA ES UNA CLASE GENERICA PARA EL MANEJO DE ERRORES Y RESPUESTAS DE LA API,
// AQUI PUEDES CONFIGURAR ATRIBUTOS PARA QUE SEAN MOSTRADOS EN LA RESPUESTA DE LA API
public class ResponseWrapper<T> {
    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ResponseWrapper(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now(); // Asignar automáticamente el tiempo actual
    }

    // Getters y setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
           //-------------------------------------------
         /* |            Response Wrapper             |
            |-----------------------------------------|
            | **Definición:**                         |
            | El Response Wrapper es un patrón de     |
            | diseño utilizado en aplicaciones web,   |
            | especialmente en APIs, para encapsular  |
            | la respuesta enviada al cliente. Incluye|
            | componentes como el estado de la        |
            | respuesta (éxito o error), un mensaje   |
            | contextual y los datos reales devueltos.|
            |                                         |
            | **Ventajas:**                           |
            | 1. **Consistencia:** Ofrece un formato  |
            | uniforme para todas las respuestas,     |
            | facilitando su manejo en el cliente.    |
            | 2. **Manejo de Errores:** Permite       |
            | incluir mensajes de error claros,       |
            | mejorando la comprensión de los         |
            | problemas.                              |
            | 3. **Flexibilidad:** Se puede adaptar   |
            | para incluir información adicional o    |
            | metadatos (ej. paginación).            |
            | 4. **Facilita la Mantenibilidad:**      |
            | Centraliza la lógica de respuesta,      |
            | simplificando el código en los          |
            | controladores.                          |
            |                                         |
            | **Desventajas:**                        |
            | 1. **Sobrecarga:** Puede aumentar el    |
            | tamaño de las respuestas si se incluye   |
            | información adicional innecesaria.      |
            | 2. **Complejidad Adicional:**           |
            | Introduce una capa extra en la lógica de |
            | respuesta que puede ser innecesaria     |
            | para aplicaciones simples.              |
            | 3. **Rendimiento:** En algunos casos,   |
            | la encapsulación adicional puede causar  |
            | latencias.                              |
            |                                         |
            | **Similitudes con Otros Sistemas de     |
            | Respuestas:**                           |
            | - **DTO (Data Transfer Object):**       |
            | Ambos transportan datos, pero el DTO se |
            | enfoca en la estructura de datos,       |
            | mientras que el Response Wrapper         |
            | incluye estado y mensajes.              |
            | - **Error Handling Middleware:**        |
            | Ambos manejan errores, pero el Response  |
            | Wrapper se aplica a todas las respuestas.|
            | - **Estructuras de Respuesta de APIs    |
            | RESTful:** Muchas APIs utilizan         |
            | estructuras de respuesta similares que   |
            | incluyen metadatos y errores.           |
            |                                         |
            | **Competidores:**                       |
            | 1. **Estructuras de Respuesta HTTP      |
            | Estándar:** Algunas aplicaciones envían  |
            | datos directamente sin encapsulación.    |
            | 2. **GraphQL:** Permite a los clientes  |
            | especificar exactamente lo que necesitan,|
            | lo que puede hacer innecesario el       |
            | Response Wrapper.                       |
            | 3. **Protocol Buffers o gRPC:**        |
            | Utilizan métodos de serialización       |
            | eficientes y pueden no requerir un      |
            | Response Wrapper.                       |
            | 4. **Frameworks de Respuesta Personalizada:|
            | Algunos frameworks ofrecen métodos de    |
            | respuesta que pueden competir en         |
            | funcionalidad.                          |
            |                                         |
            | **Resumen:**                            |
            | Un Response Wrapper es una herramienta   |
            | útil en el diseño de APIs que ayuda a   |
            | mantener la consistencia y claridad en  |
            | las respuestas. Sin embargo, debe ser   |
            | utilizado según las necesidades          |
            | específicas de la aplicación.           |
            -------------------------------------------*/


}
