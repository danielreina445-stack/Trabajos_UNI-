nombres = []
for i in range(10):
        nombre= input("Ingrese un nombre: ")
        nombres.append(nombre)
lista_original= nombres.copy()
for i in range(10):
        for j in range(9):
                if nombres[j] > nombres[j + 1]:
                        aux=nombres[j]
                        nombres[j]=nombres[j + 1]
                        nombres[j + 1]=aux
diccionario= {
        "Sin ordenar": lista_original,
        "Ordenado": nombres
}
print("Lista sin ordenar:", lista_original)
print("Lista ordenada:", nombres)
print("diccionario:", diccionario)
