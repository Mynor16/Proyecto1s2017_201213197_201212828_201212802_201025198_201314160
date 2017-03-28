class NodoAVL(object):
	def __init__(self, idNode, nombre, descripcion, rentado):
		self.idNode = idNode
		self.nombre = nombre
		self.descripcion = descripcion
		self.rentado = rentado
		self.fe = 0
		self.hijoIzq = None
		self.hijoDer = None
	
	def getID(self):
		return self.idNode

	def getNombre(self):
		return self.nombre

	def getDescripcion(self):
		return self.descripcion

	def getDisponibilidad(self):
		return self.rentado