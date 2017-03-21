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
@app.route('/insertarAVL',methods=['POST']) 
def insertarAVL():
	articulo = str(request.form['nombre'])
	descripcion = str(request.form['desc'])
	avlT.insertar(str(articulo), str(descripcion))
	return "Articulo insertado con exito!"

@app.route('/graficarAVL',methods=['POST'])
def graficarAVL():
	ls.graficarAVL()
	return "Lista Graficada" 
#***********************************************#

#************ METODOS  MATRIZ  ************#
@app.route('/insertarMatriz',methods=['POST']) 
def insertarMatriz():
	usuario = str(request.form['user'])
	contraseña = str(request.form['password'])
	nombre = str(request.form['name'])
	mt.insertar(str(usuario), str(contraseña), str(nombre))
	return "Usuario insertado con exito!"	

@app.route('/graficarMatriz',methods=['POST']) 
def graficarMatriz():
	mt.graficar()
	return "Matriz Graficada" 
#***********************************************#

#***************** METODOS AVL *****************#
	
# avlT.insertar("libro","libro hola 123")	
# avlT.insertar("libro","libro hola 123")	
# avlT.insertar("libro","libro hola 123")	
# avlT.insertar("libro","libro hola 123")	
# avlT.insertar("libro","libro hola 123")	
# print ("Articulo ingresado con exito!")
# print ("*****************************")
# avlT.graficarAVL()
# print ("Arbol Graficado!")

# mt.insertar("aom", "a1415", "Ana", "gerencia", "alo")#
#mt.graficar()
#***********************************************#

if __name__ == "__main__":
	print("Servidor iniciado...")
	app.run(debug=True, host='127.0.0.1')
