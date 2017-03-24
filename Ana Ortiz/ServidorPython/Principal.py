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
"""#***************** METODOS AVL *****************#
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
    depto = str(request.form['depto'])
    empresa = str(request.form['empresa'])
    mt.insertar(str(usuario), str(contraseña), str(nombre), str(depto), str(empresa))
    return "Usuario insertado con exito!"   

@app.route('/graficarMatriz',methods=['POST']) 
def graficarMatriz():
    mt.graficar()
    return "Matriz Graficada" 
#***********************************************#"""

#***************** METODOS AVL *****************#
	
"""avlT.insertarAVL("hoja","fdjkdf")	
avlT.insertarAVL("libro","dsfsda")	
avlT.insertarAVL("escritorio","dfddf")	
avlT.insertarAVL("casa","oerjsd")	
avlT.insertarAVL("banco","kljfdi")	
print ("Articulo ingresado con exito!")
print ("*****************************")
avlT.graficarAVL()
print ("Arbol Graficado!")
print ("*****************************")
#avlT.eliminarAVL("3")
#print ("Nodo eliminado")
#print ("*****************************")
#avlT.graficarAVL()"""

mt.insertar("aom", "a1415", "Ana", "gerencia", "alo")
mt.insertar("sdom", "56dsf", "Samuel", "ventas", "dfkj")
mt.insertar("ieri", "dsf", "Esdf", "compras", "alo")
mt.graficar()
mt.buscar("alo", "gerencia")
mt.verificarUsuario("aom", "alo", "gerencia")
#***********************************************#

if __name__ == "__main__":
	print("Servidor iniciado...")
	#app.run(debug=True, host='192.168.0.100')
