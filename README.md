# CHALLENGE ALURA FORO HUB

### El proyecto se encuentra en desarrollo completando los sigueintes pasos correspondientes al detalle especificado en el trello:

- Creación del repositorio en github.
- Creación del readme.
- configuración del entorno Java y Spring.
- Cración del diagrama base de datos (la clase principal).
- Creación de la base de datos y tabla en MySQL.
- Registro de un nuevo topico:
  - Con la creación del controller, del request en insomnia y todo lo necesario para el guardado del registro en la base de datos.
####
- Creación del metodo para mostrar los topicos donde: (Cada uno de estos tiene su propio HTTP Request)
  - Se creo uno para mostrar todos con una paginacacion de 3.
  - Otro para mostrar los primeros 10.
  - Otro para mostrar con filtro segun el año y curso.
####
- Detallando un topico terminado donde:
  - A la funcion para busqueda por id si ese id no exite arroja un mensaje personalizado y de lo contrario muestra el topico con todo lo solicitado.
#### 
- Creación del metodo para actualizar topico tomadno en cuenta la especificacion del trello.
  - Al metodo para poder actulizar un topico funciona igual que a "detallando un topico" donde en el caso de que la id no exista envia un mensaje personalizao y dicha id se debe de agregar a la Url como lo especifica el trello, ej: .../topicos/{id}
####
- Creación del metodo para realizar la eliminación de un topico.
- Creación del metodo para la autenticación con Spring security.
- Creación del metodo para la creación del TOKEN.
- Creación del metodo para la autenticacion con JWT.

--------
### Extras agregados al Foro Hub:

- Metodo para poder comentar topicos interactuando por la id de manera dinamica desde la misma url.
- Metodo para poder listar los comentarios por topico. (mostrar todos los comentarios que este tenga en la url: localhost......comentario/todos/{topicoId})