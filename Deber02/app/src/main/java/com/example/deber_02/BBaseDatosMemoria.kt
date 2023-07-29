package com.example.deber_02

class BBaseDatosMemoria {
    companion object{
        val arregloContenido = listOf <Contenido>(
            Pelicula("Babylon",
                "Babylon\" es una epopeya sobre ambición descomunal y exceso" +
                        " escandaloso que traza el ascenso y la caída de múltiples personajes " +
                        "en Los Ángeles, durante la década de 1920, una era de decadencia y depravación" +
                        " desenfrenada en los inicios de Hollywood.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/babylon.png",
                "3h 9min",
                "Comedia"),
            Pelicula("Flamin Hot",
                "Flamin’ Hot: El sabor que cambió la historia\" es la motivadora historia de Richard" +
                        " Montañez, el conserje de Frito Lay quien encausó su herencia mexicana americana para " +
                        "transformar los icónicos Cheetos Flamin’ Hot en una botana que revolucionaría la industria " +
                        "de los alimentos y se convertiría en un fenómeno de la cultura pop mundial.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/fh.png",
                "1h 38min",
                "Drama, Biografía"),
            Pelicula("Amsterdam",
                "Ámsterdam”, del aclamado director David O. Russell, es una epopeya criminal sobre tres amigos " +
                        "que se ven envueltos en una de las conspiraciones más asombrosas de la historia de Estados Unidos. " +
                        "Esta fascinante e intrincada historia entreteje hechos históricos con elementos ficticios para brindar " +
                        "una fascinante experiencia cinematográfica.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/amsterdam.png",
                "2h 15min",
                "Misterio, Drama, Comedia"),
            Pelicula("Cronica francesa",
                "Wes Anderson da vida a una selección de historias para la última edición de una revista estadounidense con " +
                        "sede en una ciudad francesa ficticia del siglo XX.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/cronica.png",
                "1h 48min",
                "Drama, Antología, Comedia"),
            Pelicula("Isla de perros",
                "Cuando todas las mascotas caninas de Ciudad Megasaki son exiliadas a una isla de basura, Atari Kobayashi un niño " +
                        "de 12 años, inicia una aventura en busca de su perro-guardia, Spots.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/isla.png",
                "1h 43min",
                "Drama, La aventurea de crecer, Ciencia Ficcion"),
            Pelicula("El fantastico SR.Zorro",
                "El Sr. y la Sra. Zorro llevan una vida hogareña feliz hasta que el Sr. Zorro vuelve a sus antiguos modos furtivos y planea" +
                        " el robo de pollos más grande que se haya visto en el mundo animal.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/zorro.png",
                "1h 28min",
                "Familiar, Comedia, Acción"),
            Pelicula("Un lugar en silencio",
                "Este thriller de terror relata la vida de una familia en un mundo postapocalíptico que se ve obligada a vivir en silencio mientras" +
                        " se esconde de unos monstruos que tienen audición ultrasensible.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/silencio.png",
                "1h 30min",
                "Terror, Ciencia Ficción, Suspenso"),
            Pelicula("AD Astra",
                "El astronauta Roy McBride (Brad Pitt) viaja a los confines del sistema solar para encontrar a su padre perdido y desentrañar un misterio " +
                        "que amenaza la supervivencia de nuestro planeta.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/astra.png",
                "2h 4min",
                "Drama, Ciencia Ficción"),
            Pelicula("Alien",
                "Dirigido por Ridley Scott, el clásico de ciencia ficción original sigue a Ripley (Sigourney Weaver) investigando un supuesto SOS en un planeta " +
                        "remoto y hace un aterrador descubrimiento.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/alien.png",
                "1h 57min",
                "Terror, Ciencia Ficción"),
            Pelicula("Margaux",
                "Un grupo de universitarios de último año celebra sus últimos días como estudiantes en una casa inteligente, pero el sistema de inteligencia artificial" +
                        " altamente avanzado de la casa, Margaux, comienza a asumir una identidad letal. Entonces, un fin de semana de fiesta se convierte en una pesadilla distópica" +
                        " cuando se dan cuenta de los planes de Margaux para eliminar a sus inquilinos.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/margaux.png",
                "1h 44min",
                "Terror"),
            Pelicula("Viejos",
                "Este es un thriller escalofriante y misterioso sobre una familia que, durante unas vacaciones tropicales, descubre que la playa donde se relajan durante unas horas " +
                        "les está haciendo envejecer de forma acelerada... lo que reduce toda su vida a solo un día.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/viejos.png",
                "1h 48min",
                "Terror, Suspenso"),
            Pelicula("Los croods 2",
                "¡La familia prehistórica está lista para otra gran aventura! Esta vez, los Croods enfrentan su mayor desafío: ¡otra familia! En busca de un nuevo hogar, los Croods descubren " +
                        "un paraíso creado por una sofisticada familia, con la cual intentan coexistir.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/croods2.png",
                "1h 35min",
                "Familiar, Comedia, Animación"),
            Pelicula("Los blancos no saben saltar",
                "En esta versión moderna de la icónica película, Jeremy, basquetbolista exestrella cuyas lesiones detuvieron su carrera, se une de mala gana a Kamal, un jugador que fue prometedor, " +
                        "pero arruinó su futuro en el deporte. Mientras equilibran relaciones tensas, presiones financieras y luchas internas, estos basquetbolistas callejeros, que aparentemente son polos opuestos, " +
                        "unen fuerzas en un último intento de vivir sus sueños.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/saltar.png",
                "1h 42min",
                "Deportes, Drama, Comedia"),
            Pelicula("Quasi",
                "Un jorobado desventurado anhela el amor, pero se encuentra en medio de una disputa asesina entre el Papa y el Rey de Francia cuando cada uno le ordena al jorobado que mate al otro.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/quasi.png",
                "1h 40min",
                "Comedia"),
            Pelicula("Rye Lane",
                "De la directora revelación Raine Allen-Miller, \"Rye Lane\" es una comedia romántica protagonizada por David Jonsson y Vivian Oparah que encarnan a Dom y Yas, dos veinteañeros que vienen de rupturas " +
                        "feas y que conectan durante el transcurso de un día ajetreado en el sur de Londres en el que se ayudan mutuamente a superar a sus ex de pesadilla y, posiblemente, a restablecer su fe en el amor.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/rye.png",
                "1h 23min",
                "Romance, Comedia Romantica"),
            Pelicula("30 noches con mi ex",
                "El Turbo\", luego de tres años separado de \"La Loba\", acepta, por pedido de la hija que tienen en común, convivir durante 30 días con su exmujer, que viene de una larga internación psiquiátrica. Entonces, " +
                        "esta nueva “vida en familia” hará que El Turbo y La Loba revivan los sentimientos de amor y despierte la ilusión de volver a estar juntos.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/30noches.png",
                "1h 35min",
                "Romance, Comedia"),
            Pelicula("500 dias con ella",
                "Una poco convencional comedia romántica sobre una mujer que no cree que el amor verdadero exista y el joven que se enamora de ella.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/500dias.png",
                "1h 35min",
                "Romance, Comedia Romantica, Drama, Comedia"),
            Pelicula("Un novio para mi mujer",
                "El Tenso no sabe cómo decirle a su mujer que se quiere separar, ya que ella vive malhumorada, pues absolutamente todo es motivo de protesta. Carlos, amigo del Tenso, le sugiere dar un giro al asunto y le propone recurrir " +
                        "al Cuervo Flores, un seductor irresistible que seducirá a su mujer hasta el enamoramiento.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Peliculas/novio.png",
                "1h 37min",
                "Romance, Comedia"),
            Serie("What we do in the shadows",
            "Una mirada a la vida diaria de cuatro vampiros que llevan cientos de años juntos. Tras la visita de su señor y líder oscuro, se les recuerda el objetivo de haber llegado a Nueva York un siglo atrás.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie1.png",
            4,
            40),
            Serie("The handmaid's tale",
                "La sociedad de Gilead, en medio de desastres medioambientales y una tasa de natalidad en picada, es gobernada por un régimen de fundamentalismo retorcido; Offred es una de las pocas mujeres fértiles que quedan y es una sierva en " +
                        "la casa del Comandante, una de la casta de mujeres obligadas a la servidumbre sexual como un último intento desesperado de repoblar el mundo.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie2.png",
                4,
            40),
            Serie("Bruna",
                "Antes de convertirse en la prostituta más famosa de Brasil, Bruna era solo una chica de clase media que soñaba con ser libre. Sin embargo, al mudarse fuera de la casa de sus padres, se adentra en un peligroso submundo lleno de sexo, drogas y violencia.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie3.png",
                4,
            32),
            Serie("Hillsong",
                "Serie documental que va más allá de los titulares sensacionalistas y tras bambalinas para examinar el largo patrón de Hillsong de encubrir la mala conducta para protegerse.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie4.png",
                1,
            4),
            Serie("911",
                "De los creadores Ryan Murphy, Brad Falchuk y Tim Minear, el drama procesal 9-1-1 explora las experiencias de alta presión de los policías, paramédicos y bomberos que se ven empujados a las situaciones más espantosas, chocantes y desgarradoras.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie5.png",
                6,
            60),
            Serie("Balao",
                "Los años 80 reunieron a una encantadora niña cantante, un niño tímido con una voz angelical, el heredero de un famoso ladrón y al hijo de una leyenda de la MPB, quienes formaron la banda infantil más importante de Brasil. 40 años después del apogeo, Simony, Tob, " +
                        "Mike y Jairzinho se reúnen para compartir sus recuerdos más intensos del fenómeno que marcó generaciones: Balão Mágico.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie6.png",
                1,
            3),
            Serie("Abbott Elementary",
                "Una comedia laboral que sigue a un grupo de profesores dedicados y apasionados —y a un director un poco sordo— mientras navegan por el sistema de escuelas públicas de Filadelfia. A pesar de las dificultades que tienen, están decididos a ayudar a sus alumnos a tener éxito en la vida," +
                        " y aunque estos increíbles servidores públicos puedan tener inferioridad numérica y de fondos, aman lo que hacen.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie7.png",
                2,
            26),
            Serie("Dropout",
                "Dinero. Romance. Tragedia. Engaño. De la mano de la productora ejecutiva Elizabeth Meriwether, The Dropout es la historia de Elizabeth Holmes (Amanda Seyfried) y Theranos, una increíble historia de ambición y fama que salió terriblemente mal. ¿Cómo es que la multimillonaria más joven del" +
                        " mundo lo perdió todo en un abrir y cerrar de ojos?",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie8.png",
                1,
            8),
            Serie("El oso",
                "Carmy, un joven chef de alta cocina, regresa a Chicago para administrar la tienda de sándwiches de su familia. Mientras lucha para transformar la tienda y a sí mismo, trabaja junto a un equipo tosco que finalmente se revela como su familia elegida.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie9.png",
                1,
            8),
            Serie("Bride & Prejudice",
                "En Bride & Prejudice, una pareja interconfesional de Baltimore, una pareja gay de Boston y una pareja interracial de Houston se esfuerzan por demostrarles a sus seres queridos que las diferencias de raza, religión y preferencia sexual no afectan su capacidad de amar.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie10.png",
                1,
            6),
            Serie("This is us",
            "Una serie refrescantemente honesta y provocativa que sigue un grupo único cuyos caminos se cruzan y las historias de vida se entrelazan de forma curiosa. THIS IS US es una comedia dramática inteligente y moderna que desafiará tus presunciones cotidianas sobre la gente que crees conocer.",
            "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie11.png",
            6,
            48),
            Serie("Alta fidelidad",
            "Una re-imaginación de la novela de 1995 de Nick Hornby, \"High Fidelity\" se centra en Rob, una dueña de una tienda de discos que recuerda las relaciones pasadas a través de la música y la cultura pop.",
            "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie12.png",
            1,
            10),
            Serie("Grey's Anatomy",
                "Los doctores se enfrentan diariamente a decisiones de vida o muerte.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie13.png",
                18,
            450),
            Serie("New Amsterdam",
                "Inspirado por Bellevue, el hospital público más antiguo de Estados Unidos, este drama sigue al brillante y encantador Dr. Max Goodwin, el nuevo director de \"New Amsterdam\". Él no se detendrá ante nada para darle un nuevo aliento a este hospital, el único en el mundo capaz de tratar a pacientes" +
                        " con ébola, prisioneros de Rikers y al presidente de los Estados Unidos, todo bajo un mismo techo.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie14.png",
                5,
            110),
            Serie("The resident",
                "The Resident es un show médico fuerte que se centra en los últimos años de formación de un joven médico que deja ver la verdad de lo que pasa realmente, tanto bueno como malo, en hospitales de todo el país.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie15.png",
                6,
            78),
            Serie("CSI: Cyber",
            "La agente especial Avery Ryan dirige la División de Delitos Cibernéticos del FBI, una unidad que se encuentra a la vanguardia de la lucha contra las actividades ilegales que comienzan en la mente, viven en línea y se desarrollan en el mundo real. Ella sabe cómo la tecnología actual permite a las personas esconderse en las sombras de Internet y cometer delitos de proporciones globales.",
            "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie16.png",
            2,
            28),
            Serie("Rescue me",
                "Tommy Gavin y los heroicos bomberos de la Compañía 62 de Nueva York luchan por superar la muerte de sus compañeros y sus propias tragedias personales tras el 11-S.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie17.png",
                6,
            80),
            Serie("Castle",
                "Rick Castle es uno de los autores de crímenes más exitosos del mundo. Pero cuando su estilo de vida de estrella de rock no es suficiente, este chico malo va en busca de nuevos problemas y los encuentra trabajando con la inteligente y hermosa detective Kate Beckett. A medida que resuelven un nuevo crimen cada semana, su camaradería crece. Juntos incluso podrían escribir un nuevo capítulo " +
                        "sobre resolución de crímenes.",
                "https://raw.githubusercontent.com/JoffreC/Imagenes/master/Series/serie18.png",
                8,
            178)
            )
        fun obtenerPeliculas():List<Pelicula>{
            val arr = arrayListOf<Pelicula>()
            arr.addAll(arregloContenido.filterIsInstance<Pelicula>())
            return arr
        }
        fun obtenerSeries():List<Serie>{
            val arr = arrayListOf<Serie>()
            arr.addAll(arregloContenido.filterIsInstance<Serie>())
            return arr
        }
    }
}