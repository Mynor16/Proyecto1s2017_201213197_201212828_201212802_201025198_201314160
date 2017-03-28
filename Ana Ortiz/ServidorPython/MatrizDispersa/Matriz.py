from graphviz import Source
from .ListaIndice import ListaIndice
from .NodoIndice import NodoIndice
from .NodoListaNodos import NodoListaNodos

class Matriz(object):
	def __init__(self):
		self.ejeX = ListaIndice()
		self.ejeY = ListaIndice()
		self.indice = ""
		self.userL = ""
		self.xml = ""

	def getNodoIndiceX(self, posX):
		nodoIndiceX = self.ejeX.buscar(posX)
		if nodoIndiceX == None:
			nodoIndiceX = NodoIndice(posX)
			self.ejeX.insertarIndice(nodoIndiceX)
		return nodoIndiceX

	def getNodoIndiceY(self, posY):
		nodoIndiceY = self.ejeY.buscar(posY)
		if nodoIndiceY == None:
			nodoIndiceY = NodoIndice(posY)
			self.ejeY.insertarIndice(nodoIndiceY)
		return nodoIndiceY
#**************************************************************************#
#************************* METODOS PARA LA MATRIZ *************************#
	#******************** INSERCIÓN ********************#
	def insertar(self, usuario, contraseña, nombre, departamento, empresa):
		posX = empresa
		posY = departamento
		
		nodoIndiceX = self.getNodoIndiceX(posX)
		nodoIndiceY = self.getNodoIndiceY(posY)
		nodo = self.buscar(posX, posY)
		if nodo == None:
			nodo = NodoListaNodos(usuario, contraseña, nombre)
			nodo.padreX = nodoIndiceX
			nodo.padreY = nodoIndiceY
			nodoIndiceX.listaNodos.insertarX(nodo)
			nodoIndiceY.listaNodos.insertarY(nodo)
		else:
			nodo.agregarUsuario(usuario)
			nodo.agregarContraseña(contraseña)
			nodo.agregarNombre(nombre)
	#******************** BÚSQUEDA ********************#
	def buscar(self, empresa, depto):
		tempY = self.ejeY.inicio
		while tempY != None:
			tempXinterno = tempY.listaNodos.inicio
			if tempY.getIndice() == depto:
				while tempXinterno != None:
					if tempXinterno.padreX.getIndice() == empresa:
						self.userL = tempXinterno
						#print("Nodo " + self.userL.getUsuario() + " encontrado")
						return tempXinterno
					else:
						print("Empresa no encontrada")
					tempXinterno = tempXinterno.derecha
			else:
				print("Departamento no encontrado")
			tempY = tempY.siguiente
		return None
	#******************** LOG IN ********************#
	def verificarUsuario(self, usuario, password, empresa, depto):
		self.buscar(empresa, depto)
		if ((usuario == self.userL.getUsuario()) and (password == self.userL.getContraseña())):
			print ("Usuario " + usuario + " correcto")
			return "True"
		else:
			print ("Usuario " + usuario + " incorrecto!")
			return "False"
	#******************** GRAFICAR ********************#
	def graficar(self):
		grafo = "digraph G {\n" + "rankdir = TB;\n" + "rank = min;\n" + "node[style=filled,shape=box, label=\"Inicio\", rankdir=UD];\n"

		tempX = self.ejeX.inicio
		tempXinterno = None
		tempY = self.ejeY.inicio

		j = 0;
		i = 0;

		while tempY != None:
			if tempY == self.ejeY.inicio:
				grafo += "\"" + str(i) + "," + str(j) + "\"[label=\"raiz\", style=filled];\n"
				i += 1
				while tempX != None:
					grafo += "\"" + str(i) + "," + str(j) + "\"[label=\""+tempX.getIndice()+"\", style=filled];\n"
					i += 1
					tempX = tempX.siguiente
				i = 0
				j += 1
			tempXinterno = tempY.listaNodos.inicio
			tempX = self.ejeX.inicio
			grafo += "\"" + str(i) + "," + str(j) + "\"[label=\""+tempY.getIndice()+"\", style=filled];\n"
			i += 1
			while tempX != None:
				if tempXinterno != None:
					if tempXinterno.padreX == tempX:
						grafo += "\"" + str(i) + "," + str(j) + "\"[label=\"Nombre: "+tempXinterno.getUsuario()+ "\nContraseña: " + tempXinterno.getContraseña() + "\nNombre: " + tempXinterno.getNombre() + "\", style=filled];\n"
						tempXinterno = tempXinterno.derecha
					else:
						grafo += "\"" + str(i) + "," + str(j) + "\"[label=\"no existe\", style=filled];\n"
				else:
					grafo += "\"" + str(i) + "," + str(j) + "\"[label=\"no existe\", style=filled];\n"
				i += 1
				tempX = tempX.siguiente
			i = 0
			j += 1
			tempY = tempY.siguiente
		print(str(i))
		print(str(j))
		tempX = self.ejeX.inicio
		while tempX != None:
			i += 1
			tempX = tempX.siguiente
		print(str(i))
		print(str(j))
		i += 1
		for y in range(0,j):
		    for x in range (0,i-1):
		        grafo += "\"" + str(x) + "," + str(y) + "\" -> \"" + str(x + 1) + "," + str(y) + "\"[constraint=false];\n"
		        grafo += "\"" + str(x + 1) + "," + str(y) + "\" -> \"" + str(x) + "," + str(y) + "\"[constraint=false];\n"
		        grafo += "{rank=same;\"" + str(x) + "," + str(y) + "\" \"" + str(x + 1) + "," + str(y) + "\"}\n"
		        grafo += "{rank=same;\"" + str(x + 1) + "," + str(y) + "\" \"" + str(x) + "," + str(y) + "\"}\n"

		for y in range(0,j-1):
		    for x in range (0,i):
		        grafo += "\"" + str(x) + "," + str(y) + "\" -> \"" + str(x) + "," + str(y + 1) + "\"[rankdir=UD];\n";
		        grafo += "\"" + str(x) + "," + str(y + 1) + "\" -> \"" + str(x) + "," + str(y) + "\"[rankdir=UD];\n";

		grafo += "labelloc=\"t\"; label=\" MATRIZ DISPERSA\";}"
		print(grafo)
		src = Source(grafo)
		src.format = "png"
		src.render('test-output/MatrizDispersa', view = True)
#**************************************************************************#
#************************** METODOS PARA EL AVL ***************************#
	#********************* INSERCIÓN **********************#
	def insertarAVLMatriz(self, usuario, empresa, depto, nombreA, descA):
		self.buscar(empresa, depto)
		if usuario == self.userL.getUsuario():
			self.userL.insertarNodoAVL(nombreA, descA)
			print("Nodo insertado en Matriz: " + nombreA + "--" + descA)
	#********************* ELIMINACIÓN ********************#
	def eliminarAVLMatriz(self, usuario, empresa, depto, idArt):
		self.buscar(empresa, depto)
		if usuario == self.userL.getUsuario():
			self.userL.eliminarNodoAVL(idArt)
			print("Nodo con ID: " + idArt + "eliminado")
	#******************** MODIFICACIÓN ********************#
	def modificarAVLMatriz(self, usuario, empresa, depto, idArt, descA):
		self.buscar(empresa, depto)
		if usuario == self.userL.getUsuario():
			self.userL.modificarNodoAVL(idArt, descA)
			print("Nodo Modificado: " + idArt + "--" + descA)
	#******************** DISPONIBILIDAD ********************#
	def disponibilidadAVLMatriz(self, usuario, empresa, depto, idArt):
		self.buscar(empresa, depto)
		if usuario == self.userL.getUsuario():
			self.userL.disponibilidadNodoAVL(idArt)
			print("Nodo Modificado: " + idArt)
	#********************** GRAFICAR **********************#
	def graficarAVLMatriz(self, usuario, empresa, depto):
		self.buscar(empresa,depto)
		if usuario == self.userL.getUsuario():
			self.userL.graficarAVLM()
#**************************************************************************#
	def crearXML(self):
			self.xml = "<users>\n"

			tempX = self.ejeX.inicio
			tempXinterno = None
			tempY = self.ejeY.inicio

			j = 0;
			i = 0;

			while tempY != None:
				if tempY == self.ejeY.inicio:
					self.xml += "<user>\n"
					i += 1
					while tempX != None:
						#xml += "\"" + str(i) + "," + str(j) + "\"[label=\""+tempX.getIndice()+"\", style=filled];\n"
						i += 1
						tempX = tempX.siguiente
					i = 0
					j += 1
				tempXinterno = tempY.listaNodos.inicio
				tempX = self.ejeX.inicio
				#xml += "\"" + str(i) + "," + str(j) + "\"[label=\""+tempY.getIndice()+"\", style=filled];\n"
				i += 1
				while tempX != None:
					if tempXinterno != None:
						if tempXinterno.padreX == tempX:
							self.xml += "<name>" + tempXinterno.getUsuario() + "</name>\n"
							tempXinterno = tempXinterno.derecha
						else:
							self.xml += " "
					else:
						self.xml += " "
					i += 1
					tempX = tempX.siguiente
				i = 0
				j += 1
				tempY = tempY.siguiente
			tempX = self.ejeX.inicio
			while tempX != None:
				i += 1
				tempX = tempX.siguiente
			i += 1
			
			self.xml += "</user>\n"
			self.xml += "</users>"
			print(self.xml)
			#src = Source(xml)
			#src.format = "png"
			#src.render('test-output/MatrizDispersa', view = True)