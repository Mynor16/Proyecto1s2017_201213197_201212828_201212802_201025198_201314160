class NodoListaNodos(object):
	def __init__ (self, listaUsuario, listaContraseña, listaNombre):
		self.arriba = None
		self.abajo = None
		self.izquierda = None
		self.derecha = None
		from .NodoIndice import NodoIndice
		self.padreX = None
		self.padreY = None
		self.listaUsuario = listaUsuario
		self.listaContraseña = listaContraseña
		self.listaNombre = listaNombre
		from AVLTree.AVL import AVL
		self.avlTree = AVL()


	def getPosX(self):
		return self.padreX.getIndice()

	def getPosY(self):
		return self.padreY.getIndice()

	def agregarUsuario(self, usuario):
		self.listaUsuario += '--' + usuario

	def agregarContraseña(self, contraseña):
		self.listaContraseña += '--' + contraseña

	def agregarNombre(self, nombre):
		self.listaNombre += '--' + nombre
	
	def getUsuario(self):
		return self.listaUsuario
	
	def getContraseña(self):
		return self.listaContraseña
	
	def getNombre(self):
		return self.listaNombre

	def getNAVL(self):
		return self.avlTree

	def insertarNodoAVL(self, nombre, descripcion):
		self.avlTree.insertar(nombre, descripcion)
		return nombre + " -- " + descripcion