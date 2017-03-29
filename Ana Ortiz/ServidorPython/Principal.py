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
mt.insertar("aom", "a1415", "Ana", "gerencia", "alo")
mt.insertar("sdom", "56dsf", "Samuel", "ventas", "dfkj")
mt.insertar("ieri", "dsf", "Esdf", "compras", "alo")
mt.graficar()
mt.buscar("alo", "gerencia")
mt.verificarUsuario("aom", "a1415", "alo", "gerencia")
mt.verificarUsuario("sdfd", "sdfd", "dfd", "sdf")
mt.insertarAVLMatriz("aom", "alo", "gerencia", "lapiz", "lapiz mongol hb")
mt.insertarAVLMatriz("aom", "alo", "gerencia", "borrador", "borrador maped")
mt.insertarAVLMatriz("aom", "alo", "gerencia", "cuaderno", "cuaderno en blanco")
mt.insertarAVLMatriz("sdom", "dfkj", "ventas", "laptop", "laptop asus")
mt.graficarAVLMatriz("aom", "alo", "gerencia")
mt.graficarAVLMatriz("sdom", "dfkj", "ventas")
print("***********************XML***************************")
mt.crearXML()
#***********************************************#

if __name__ == "__main__":
	print("Servidor iniciado...")
	#app.run(debug=True, host='192.168.0.100')

"""#***************** METODOS AVL *****************#
@app.route('/insertarAVL',methods=['POST']) 
def insertarAVL():
	usuario = str(request.form['user'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
    articulo = str(request.form['nombre'])
    descripcion = str(request.form['desc'])
    mt.insertarAVLMatriz(str(usuario), str(empresa), str(depto), str(articulo), str(descripcion))
    return "Articulo insertado con exito!"

@app.route('/eliminarAVL',methods=['POST']) 
def eliminarAVL():
	usuario = str(request.form['user'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
    idArt = str(request.form['id'])
    mt.eliminarAVLMatriz(str(usuario), str(empresa), str(depto), str(idArt))
    return "Articulo eliminado con exito!"

@app.route('/modificarAVL',methods=['POST']) 
def modificarAVL():
	usuario = str(request.form['user'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
    idArt = str(request.form['id'])
    descripcion = str(request.form['desc'])
    respuesta = mt.modificarAVLMatriz(str(usuario), str(empresa), str(depto), str(idArt), str(descripcion))
    return respuesta

@app.route('/cambiarEstadoAVL',methods=['POST']) 
def cambiarEstadoAVL():
	usuario = str(request.form['user'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
    idArt = str(request.form['id'])
    respuesta = mt.modificarAVLMatriz(str(usuario), str(empresa), str(depto), str(idArt))
    return respuesta

@app.route('/graficarAVL',methods=['POST'])
def graficarAVL():
	usuario = str(request.form['user'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
	respuesta = mt.graficarAVLMatriz(str(usuario), str(empresa), str(depto))
    return respuesta
#***********************************************#

#************ METODOS  MATRIZ  ************#
@app.route('/insertarMatriz',methods=['POST']) 
def insertarMatriz():
    usuario = str(request.form['user'])
    password = str(request.form['password'])
    nombre = str(request.form['name'])
    depto = str(request.form['depto'])
    empresa = str(request.form['empresa'])
    mt.insertar(str(usuario), str(contraseña), str(nombre), str(depto), str(empresa))
    return "Usuario insertado con exito!"   

@app.route('/verificarUsuario',methods=['POST']) 
def verificarUsuario():
    usuario = str(request.form['user'])
    password = str(request.form['password'])
    empresa = str(request.form['empresa'])
    depto = str(request.form['depto'])
    respuesta = mt.verificarUsuario(str(usuario), str(password), str(empresa), str(depto))
    return respuesta

@app.route('/graficarMatriz',methods=['POST']) 
def graficarMatriz():
    respuesta = mt.graficar()
    return respuesta

@app.route('/archivoXML',methods=['POST']) 
def archivoXML():
    respuesta = mt.crearXML()
    return respuesta
#***********************************************#"""