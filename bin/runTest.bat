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
REM Ejecución de las pruebas
REM ---------------------------------------------------------
cd ..
java -classpath ./lib/huracanes.jar;./test/lib/huracanesTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.huracanes.test.SistemaMeteorologiaTest
java -classpath ./lib/huracanes.jar;./test/lib/huracanesTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.huracanes.test.SistemaMeteorologiaTest
cd bin