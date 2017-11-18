# HadoopProyects

Proyectos de hadoop en los que se puede ver claramente los pasos.
Empezamos con el proyecto típico de contar palabras

Principalmente tenemos 3 clases en Java:
1º Driver
2º Mapper
3º Reducer

El Driver será el encargado de ir llamando a las clases correspondientes y de que tipo de valores de entrada/salida espera

La clase mapper extenderá de  Mapper y deberemos decir el tipo de que son el par clave valor de entrada y de salida.
La clase reducer extenderá de Reducer y pasa como antes debemos decir que tipo son la clave valor de entrada y de salida.