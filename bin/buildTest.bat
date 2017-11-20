@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n7_huracanes
REM Autor: Juan Camilo Cortés M. - 21-ago-2008
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

REM ---------------------------------------------------------
REM Asegura la creación de los directorios classes y lib en test
REM ---------------------------------------------------------

cd ../test
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directorio test/source
REM ---------------------------------------------------------

cd source

javac -classpath ../../lib/huracanes.jar;../lib/junit.jar -d ../classes/ uniandes/cupi2/huracanes/test/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ../classes

jar cf ../lib/huracanesTest.jar uniandes/* -C ../data .

cd ../../bin

pause