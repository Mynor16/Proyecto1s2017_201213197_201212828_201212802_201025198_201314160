from graphviz import Source
from .NodoAVL import NodoAVL

import hashlib
import time

class AVL(object):
	def __init__(self):
		self.raiz = None
		self.h = False
		self.grafo = ""
#******************************************************#
#********************* ROTACIONES *********************#
	def rotacionIzquierda(self, n, n1):
		n.hijoIzq = n1.hijoDer
		n1.hijoDer = n
		if n1.fe == -1:
			n.fe = 0
			n1.fe = 0
		else:
			n.fe = -1
			n1.fe = 1
		return n1

	def rotacionDerecha(self, n , n1):
		n.hijoDer = n1.hijoIzq
		n1.hijoIzq = n
		if n1.fe == 1:
			n.fe = 0
			n1.fe = 0
		else:
			n.fe = 1
			n1.fe = -1
		return n1

	def rotacionDobleIzquierda(self, n, n1):
		n2 = n1.hijoDer
		n.hijoIzq = n2.hijoDer
		n2.hijoDer = n
		n1.hijoDer = n2.hijoIzq
		n2.hijoIzq = n1
		if n2.fe == 1:
			n1.fe = -1
		else:
			n1.fe = 0
		if n2.fe == -1:
			n.fe = 1
		else:
			n.fe = 0
		n2.fe = 0
		return n2

	def rotacionDobleDerecha(self, n, n1):
		n2 = n1.hijoIzq
		n.hijoDer = n2.hijoIzq
		n2.hijoIzq = n
		n1.hijoIzq = n2.hijoDer
		n2.hijoDer = n1
		if n2.fe == 1:
			n.fe = -1
		else:
			n.fe = 0
		if n2.fe == -1:
			n1.fe = 1
		else:
			n1.fe = 0
		n2.fe = 0
		return n2
#******************************************************#
#********************** INSERCIÓN *********************#
	def insertar(self, idNode, nombre, descripcion, raiz):
		if raiz == None:
			raiz = NodoAVL(idNode, nombre, descripcion)
			self.h = True
		elif idNode < raiz.idNode:
			raiz.hijoIzq = self.insertar(idNode, nombre, descripcion, raiz.hijoIzq)
			if self.h == True:
				if raiz.fe == 1:
					raiz.fe = 0
					self.h = False
				elif raiz.fe == 0:
					raiz.fe = -1
				elif raiz.fe == -1:
					n1 = raiz.hijoIzq
					if n1.fe == (-1):
						raiz = self.rotacionIzquierda(raiz, n1)
					else:
						raiz = self.rotacionDobleIzquierda(raiz, n1)
					self.h = False
		elif idNode > raiz.idNode:
			raiz.hijoDer = self.insertar(idNode, nombre, descripcion, raiz.hijoDer)
			if self.h == True:
				if raiz.fe == 1:
					n1 = raiz.hijoDer
					if n1.fe == 1:
						raiz = self.rotacionDerecha(raiz, n1)
					else:
						raiz = self.rotacionDobleDerecha(raiz, n1)
					self.h = False
				elif raiz.fe == 0:
					raiz.fe = 1
				elif raiz.fe == -1:
					raiz.fe = 0
					self.h = False
		else:
			print ("Clave repetida")
		return raiz

	def insertarAVL(self, nombre, descripcion):
		#*************** ID RANDOM ***************#
		i = hashlib.md5(str(time.time()).encode())
		str_i = i.hexdigest()
		idNode = str_i[:15]
		#print (idNode + "\t")
		#*****************************************#
		self.h = False
		self.raiz = self.insertar(idNode, nombre, descripcion, self.raiz)
		#print (idNode + "--" + nombre)
		self.enOrden(self.raiz)
#******************************************************#
#********************** BÚSQUEDA **********************#
	def buscar(self, idNode, raiz):
		if raiz == None:
			print ("Nodo no existe")
		elif raiz.idNode == idNode:
			print ("Nodo: " + idNode + "--" + raiz.getNombre() + " encontrado")
		elif raiz.idNode < idNode:
			self.buscar(idNode, raiz.hijoDer)
		else:
			self.buscar(idNode, raiz.hijoIzq)

	def buscarAVL(self, idNode):
		self.raiz = self.buscar(idNode, self.raiz)
#******************************************************#
#******************** MODIFICACIÓN ********************#
	def modificar(self, idNode, descA, raiz):
		if raiz == None:
			print ("Nodo no existe")
		elif raiz.idNode == idNode:
			print ("Nodo Encontrado: " + idNode + "--" + raiz.getDescripcion())
			raiz.descripcion = descA
			print ("Nodo Modificado: " + idNode + "--" + raiz.getDescripcion())
		elif raiz.idNode < idNode:
			self.modificar(idNode, descA, raiz.hijoDer)
		else:
			self.modificar(idNode, descA, raiz.hijoIzq)

	def modificarAVL(self, idNode, descA):
		self.modificar(idNode, descA, self.raiz)
#******************************************************#
#********************* ELIMINACIÓN ********************#
	def eliminar(self, idNode, raiz):
		if raiz == None:
			print ("Nodo no existe")
		elif idNode < raiz.idNode:
			raiz.hijoIzq = self.eliminar(idNode, raiz.hijoIzq)
			if self.h == True:
				raiz = self.equilibrar1(raiz)
		elif idNode > raiz.idNode:
			raiz.hijoDer = self.eliminar(idNode, raiz.hijoDer)
			if self.h == True:
				raiz = self.equilibrar2(raiz)
		else:
			q = raiz
			if q.hijoIzq == None:
				raiz = q.hijoDer
				self.h = True
			elif q.hijoDer == None:
				raiz = q.hijoIzq
				self.h = True
			else:
				raiz.hijoIzq = self.reemplazar(q, q.hijoIzq)
				if self.h:
					raiz = self.equilibrar1(raiz)
			q == None		
		return raiz

	def eliminarAVL(self, idNode):
		self.h = False
		self.raiz = self.eliminar(idNode, self.raiz)
		self.enOrden(self.raiz)

	def reemplazar(self, n, actual):
		if actual.hijoDer != None:
			actual.hijoDer = self.reemplazar(n, actual.hijoDer)
			if self.h:
				actual = self.equilibrar2(actual)
		else:
			n.idNode = actual.idNode
			n = actual
			actual = actual.hijoIzq
			self.h = True
		return actual

	def equilibrar1(self, n):
		if n.fe == -1:
			n.fe = 0
		elif n.fe == 0:
			n.fe = 1
			self.h = False
		elif n.fe == 1:
			n1 = n.hijoDer
			if n1.fe >= 0:
				if n1.fe == 0:
					self.h = False
				n = self.rotacionDerecha(n, n1)
			else:
				n = self.rotacionDobleDerecha(n, n1)
		return n

	def equilibrar2(self, n):
		if n.fe == -1:
			n1 = n.hijoIzq
			if n1.fe <= 0:
				if n1.fe == 0:
					self.h = False
				n = self.rotacionIzquierda(n, n1)
			else:
				n = self.rotacionDobleIzquierda(n, n1)
		elif n.fe == 0:
			n.fe = -1
			self.h = False
		elif n.fe == 1:
			n.fe = 0
		return n
#******************************************************#
#********************* RECORRIDOS *********************#
	def preOrden(self, nodo):
		if nodo != None:
			print(nodo.idNode + ",")
			self.preOrden(nodo.hijoIzq)
			self.preOrden(nodo.hijoDer)
	
	def enOrden(self, nodo):
		if nodo != None:
			self.enOrden(nodo.hijoIzq)
			print("--" + nodo.idNode + ",")
			self.enOrden(nodo.hijoDer)

	def postOrden(self, nodo):
		if nodo != None:
			self.postOrden(nodo.hijoIzq)
			self.postOrden(nodo.hijoDer)
			print(nodo.idNode + ",")
#******************************************************#
#********************** GRAFICAR **********************#
	def graficarNodo(self, nodo):
		if nodo != None:
			i = nodo.getID()
			self.grafo += "\"" + str(i) + "\"[label=\"<f0> Izq|<f1>"
			#self.grafo += "ID: " + nodo.getID() 
			self.grafo += "ID: " + nodo.getID() + "\\nNombre: " + nodo.getNombre() + "\\nDescripcion: " + nodo.getDescripcion()
			self.grafo += "|<f2> Der\", style=fille]; \n"

			if nodo.hijoIzq != None:
				idIzq = nodo.hijoIzq.getID()
				self.grafo += "\"" + str(i) + "\":f0 -> "
				self.grafo += "\"" + idIzq + "\":f1 ;\n"
				self.graficarNodo(nodo.hijoIzq)

			if nodo.hijoDer != None:
				self.grafo += "\"" + str(i) + "\":f2 -> " 
				idDer = nodo.hijoDer.getID()
				self.grafo += "\"" + idDer + "\":f1 ;\n"
				self.graficarNodo(nodo.hijoDer)

	def graficarAVL(self):
		self.grafo = "digraph G {node[shape=record, height=0.1];\n"
		self.grafo += "{ \n"

		if self.raiz == None:
			self.grafo += "arbolvacio [label = \"Arbol Vacio\",shape=record];\n"
		else:
			self.graficarNodo(self.raiz)
		
		self.grafo += "} \n"
		self.grafo += "labelloc=\"t\";\nlabel=\" AVL ARTICULOS ACTIVOS\";}"
		print(self.grafo)
		src = Source(self.grafo)
		src.format = "png"
		src.render('test-output/AVLTree', view = True)
#******************************************************#