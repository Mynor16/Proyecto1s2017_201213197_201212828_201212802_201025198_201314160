from flask import Flask, request, Response

#********** IMPORTACIONES DE CLASES **********#

from AVLTree.AVL import AVL
from MatrizDispersa.Matriz import Matriz
#*********************************************#
app = Flask('Proyecto1_ServidorPython')

#********** INSTANCIAMIENTO DE CLASES **********#
avlT = AVL()
mt = Matriz()
#***********************************************#
#***************** METODOS AVL *****************#
	
avlT.insertar("libro","libro hola 123")	
avlT.insertar("libro","libro hola 123")	
avlT.insertar("libro","libro hola 123")	
avlT.insertar("libro","libro hola 123")	
avlT.insertar("libro","libro hola 123")	
print ("Articulo ingresado con exito!")
print ("*****************************")
avlT.graficarAVL()
print ("Arbol Graficado!")

mt.insertar("aom", "a1415", "Ana", "gerencia", "alo")
mt.graficar()
#***********************************************#

if __name__ == "__main__":
	print("Servidor iniciado...")
	#app.run(debug=True, host='127.0.0.1')
