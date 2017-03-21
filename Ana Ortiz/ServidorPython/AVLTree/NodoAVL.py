class NodoAVL(object):
	def __init__ (self, id, nombre, descripcion):
		self.id = id
		self.nombre = nombre
		self.descripcion = descripcion
		self.fe = 0
		self.hijoIzq = None
		self.hijoDer = None

	def getID(self):
		return self.id

	def getNombreArticulo(self):
		return self.nombre

	def getDescripcion(self):
		return self.descripcion