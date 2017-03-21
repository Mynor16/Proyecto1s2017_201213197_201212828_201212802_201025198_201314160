from .NodoAVL import NodoAVL
from graphviz import Source

import hashlib
import time

class AVL(object):

	def __init__(self):
		self.raiz = None
		self.grafo = ""

	def buscar(self, idNode):
		nodo = self.raiz
		if self.raiz == None:
			return None
		elif nodo.id == idNode:
			return str(nodo.id) + " -- " + str(nodo.nombre)
		elif nodo.id < idNode:
			return self.buscar(idNode, nodo.hijoDer)
		else:
			return self.buscar(idNode, nodo.hijoIzq)

#**** METODO PARA OBTENER EL FACTOR DE EQUILIBRIO ****#
	def getFE(self, nodo):
		if nodo == None:
			return (-1)
		else:
			return nodo.fe

#********************* ROTACIONES *********************#
	def rotacionIzquierda(self, nodo):
		aux = nodo.hijoIzq
		nodo.hijoIzq = aux.hijoDer
		aux.hijoDer = nodo
		nodo.fe = max(self.getFE(nodo.hijoIzq), self.getFE(nodo.hijoDer)) + 1
		aux.fe = max(self.getFE(aux.hijoIzq), self.getFE(aux.hijoDer)) + 1
		return aux

	def rotacionDerecha(self, nodo):
		aux = nodo.hijoDer
		nodo.hijoDer = aux.hijoIzq
		aux.hijoIzq = nodo
		nodo.fe = max(self.getFE(nodo.hijoIzq), self.getFE(nodo.hijoDer)) + 1
		aux.fe = max(self.getFE(aux.hijoIzq), self.getFE(aux.hijoDer)) + 1
		return aux

	def rotacionDobleIzquierda(self, nodo):
		nodo.hijoIzq = self.rotacionDerecha(nodo.hijoIzq)
		temp = self.rotacionIzquierda(nodo)
		return temp

	def rotacionDobleDerecha(self, nodo):
		nodo.hijoDer = self.rotacionIzquierda(nodo.hijoDer)
		temp = self.rotacionDerecha(nodo)
		return temp
#******************************************************#	

	def insertarAVL(self, nodo, subAr):
		nuevoPadre = subAr
		if nodo.id < subAr.id:
			if subAr.hijoIzq == None:
				subAr.hijoIzq = nodo
			else:
				subAr.hijoIzq = self.insertarAVL(nodo, subAr.hijoIzq)
				if (self.getFE(subAr.hijoIzq) - self.getFE(subAr.hijoDer)) == 2:
					if nodo.id < subAr.hijoIzq.id:
						nuevoPadre = self.rotacionIzquierda(subAr)
					else:
						nuevoPadre = self.rotacionDobleIzquierda(subAr)
		elif nodo.id > subAr.id:
			if subAr.hijoDer == None:
				subAr.hijoDer = nodo
			else:
				subAr.hijoDer = self.insertarAVL(nodo, subAr.hijoDer)
				if (self.getFE(subAr.hijoDer) - self.getFE(subAr.hijoIzq)) == 2:
					if nodo.id > subAr.hijoDer.id:
						nuevoPadre = self.rotacionDerecha(subAr)
					else:
						nuevoPadre = self.rotacionDobleDerecha(subAr)
		else:
			print("Nodo Duplicado")
			return "Nodo Duplicado"

		if (subAr.hijoIzq == None) and (subAr.hijoDer != None):
			subAr.fe = subAr.hijoDer.fe + 1
		elif (subAr.hijoDer == None) and (subAr.hijoIzq != None):
			subAr.fe = subAr.hijoIzq.fe + 1
		else:
			subAr.fe = max(self.getFE(subAr.hijoIzq), self.getFE(subAr.hijoDer)) + 1
		return nuevoPadre

	def insertar(self, nombre, descripcion):
		i = hashlib.md5(str(time.time()).encode())
		str_i = i.hexdigest()
		idstr = str_i[:15]
		print (idstr)
		nuevo = NodoAVL(idstr, nombre, descripcion)
		if self.raiz == None:
			self.raiz = nuevo
		else:
			self.raiz = self.insertarAVL(nuevo, self.raiz)

	def eliminarAVL(self, nodo, subAr):
		nuevoPadre = subAr
		if nodo.id < subAr.id:
			subAr.hijoIzq = self.eliminar(nodo, subAr.hijoIzq)
		elif nodo.id > subAr.id:
			subAr.hijoDer = self.eliminar(nodo, subAr.hijoDer)
		else:
			if subAr.hijoIzq == None:
				if subAr.hijoDer == None:
					temp = self.raiz
					self.raiz = None
				else:
					temp = subAr.hijoDer
					self.raiz = temp
				del temp
			elif subAr.hijoDer == None:
				if subAr.hijoIzq == None:
					temp = self.raiz
					self.raiz = None
				else:
					temp = subAr.hijoIzq
					self.raiz = temp
				del temp
			else:
				temp = subAr.hijoDer
				while temp.hijoIzq:
					temp = temp.hijoIzq
					subAr.id = temp.id
					subAr.hijoDer = self.eliminar(nodo, temp.hijoDer.id)
			if self.raiz:
				subAr.fe = self.raiz.fe
				if (self.getFE(subAr.hijoDer) - self.getFE(subAr.hijoIzq)) > 1:
					if  self.getFE(subAr.hijoIzq) > 0:
						nuevoPadre = self.rotacionDerecha(subAr)
					else:
						nuevoPadre = self.rotacionDobleDerecha(subAr)
				elif (self.getFE(subAr.hijoIzq) - self.getFE(subAr.hijoDer)) > 1:
					if self.getFE(subAr.hijoDer) < 0:
						nuevoPadre = self.rotacionIzquierda(subAr)
					else:
						nuevoPadre = self.rotacionDobleIzquierda(subAr)
		if (subAr.hijoIzq == None) and (subAr.hijoDer != None):
			subAr.fe = subAr.hijoDer.fe + 1
		elif (subAr.hijoDer == None) and (subAr.hijoIzq != None):
			subAr.fe = subAr.hijoIzq.fe + 1
		else:
			subAr.fe = max(self.getFE(subAr.hijoIzq), self.getFE(subAr.hijoDer)) + 1
		return nuevoPadre

	def eliminar(self, id):
		nodo = self.raiz
		if self.raiz == None:
			return "Arbol vacio"
		else:
			self.eliminarAVL(nodo, self.raiz)
			
#********************* RECORRIDOS *********************#
	def preOrden(self, nodo):
		if nodo != None:
			print(nodo.id + ",")
			self.preOrden(nodo.hijoIzq)
			self.preOrden(nodo.hijoDer)
	
	def enOrden(self, nodo):
		if nodo != None:
			self.preOrden(nodo.hijoIzq)
			print(nodo.id + ",")
			self.preOrden(nodo.hijoDer)

	def postOrden(self, nodo):
		if nodo != None:
			self.preOrden(nodo.hijoIzq)
			self.preOrden(nodo.hijoDer)
			print(nodo.id + ",")
#******************************************************#

#********************** GRAFICAR **********************#
	def graficarNodo(self, nodo):
		if nodo != None:
			i = nodo.getID()
			self.grafo += "\"" + str(i) + "\"[label=\"<f0> Izq|<f1>"
			self.grafo += "ID: " + nodo.getID() + "\\nNombre: " + nodo.getNombreArticulo()
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