#Alumno: Facundo Armando
#Materia: Algoritmos y Estructura De Datos I
#Comision: C2
#Año: 2024


#Ejercicios 12 y 13 de la Practica 1:
#(a) (λx.x + 2) 3
suma = (lambda x : x+2)
print(suma(3))

#(b) (λx. − x) 7
opuesto = (lambda x : -x)
print(opuesto(7))

#(c) (λx.λy.x ∗ y) 5 2
multiplicacion = (lambda x, y : x * y)
print(multiplicacion(5,2))

#(d) (λx.xx)(λx.xx)
multiplicacion2 = (lambda x: (x) (x)) (lambda x: (x) (x))

#------------------------------------------------------------------------------------------------------------------------------------------------------------#

#Ejercicios 12 y 13 de la Practica 1 (OTRA FORMA DE RESOLVERLOS):
#(a) (λx.x + 2) 3
#suma = (lambda x : x+2)(3)

#(b) (λx. − x) 7
#opuesto = (lambda x : -x)(7)

#(c) (λx.λy.x ∗ y) 5 2
#multiplicacion = (lambda x: (lambda y : x * y)) (5)(2)

#(d) (λx.xx)(λx.xx)
#multiplicacion2 = (lambda x: (x) (x)) (lambda x: (x) (x))