# Google Chart Class

Esta clase busca ser una interfaz para facilitar la utilización de las Google Chart desde Android.

# Cómo usar

Para poder utilizar nuestro Chart deberemos editarlo tanto desde Android con Java cómo desde Web con JavaScript.

Comenzaremos por encontrar una Google Chart que nos guste dentro de la API de Google:
https://developers.google.com/chart/interactive/docs/gallery

## Parte de Android

En la clase Chart (situada dentro del paquete charts), deberemos adaptar los atributos de la misma para nuestras necesidades. Los constructores los dejaremos tal y cómo estan para que la clase en sí funcione cómo un WebView, y editaremos el método "create(...)" para poder crear nuestro Chart sin ningún problema.

Seguidamente, podremos encontrar una inner class llamada WebAppInterface. Editaremos y adaptaremos esta inner class para crear los getters que utilizaremos desde JavaScript más adelante y así recuperar la información de Android desde JavaScript. Para hacer esto precisaremos de la ayuda del campo llamado "tag" que tenemos ya creado en esta clase. 

En la parte gráfica con xml, crearemos nuestro chart con un objeto Chart  tal y como podemos encontrar en el ejemplo, y lo personalizaremos cómo a un objeto más, asignando una ID un ancho y un largo.

En la clase donde vayamos a crear el chart, crearemos un objeto Chart y lo enlazaremos con el chart que hemos creado gráficamente en el xml.

Una vez hecho esto, podremos utilizar el método create(...) que hemos creado en la clase Chart.

Hay que recordar que se deben facilitar los permisos de INTERNET al menos en el manifest.

## Parte de JavaScript

Cuando se abra el archivo HTML que contiene lo necesário para editar el JavaScript, se podrá observar que creamos el chart con el código que nos ha proporcionado Google con su galeria de charts en su API. 

Las partes que nos interesan editar son las variables "data" y "options".

La variable "data" es la variable donde utilizaremos la inner class para añadir los campos que necesitamos. Lo haremos llamando al getter del chart correspondiente, utilizando su Tag (por esta razón cada Chart tiene su propio Tag), que en este caso es "Android".

Con estos getters vamos a recuperar toda la información que necesitaremos, que en principio suelen ser los nombres de los campos y sus respectivos valores.

La variable "options" es una variable donde podemos añadirle o quitarle opciones, en mi clase encontrareis que le añado el título del Chart, y su tamaño en ancho y largo, todo recogido desde android con los getters de la inner class. 

En los ejemplos esto se hace desde html, pero me gusta más poder editarlo desde java para que sea adaptable a todos los dispositivos.

Por último, la variable "chart" que no necesitamos editarla en un principio, busca el elemento con la id del chart en el html y le dibuja con la función "draw" nuestro chart con sus datos y sus opciones.

### Parte de HTML

Para utilizar nuestro chart en una web tan solo tenemos que crear un <div> con la id del chart especificada en el JavaScript asociado a la misma página web.
