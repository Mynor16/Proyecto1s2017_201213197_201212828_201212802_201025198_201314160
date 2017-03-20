class Nodo1:
	def __init__(self):
		print ("Constructor de Nodo1")
		self.dato= "null"
		self.Siguiente= Nodo1
	def getDato(self):
		return self.dato
	def setDato(self, dato):
		self.dato=dato
	def setSiguiente(self,nodo):
		self.Siguiente = nodo
	def getSiguiente(self):
		return self.Siguiente
class Nodo2:
    	"""docstring for Nodo2"""
	def __init__(self):
		print("Constructor de Nodo2")
		self.dato = 'null'
		self.Derecha= Nodo2
		self.Izquierda= Nodo2
		self.Arriba=  Nodo2
		self.Abajo= Nodo2
		self.Le = "null"
		self.Co = 'null'
		self.Nombres = ListaSimple()
	def getDato(self):
		return self.dato
	def setDato(self, dato):
		self.dato=dato
	def getDerecha(self):
		return self.Derecha
	def getIzquierda(self):
		return self.Izquierda
	def getArriba(self):
		return self.Arriba
	def getAbajo(self):
		return self.Abajo
	def setDerecha(self,nodo):
		self.Derecha=nodo
	def setIzquierda(self,nodo):
		self.Izquierda=nodo
	def setArriba(self,nodo):
		self.Arriba=nodo
	def setAbajo(self,nodo):
		self.Abajo=nodo
class Matriz:
    	"""docstring for Matriz"""
	def __init__(self):
		print("Constructor de Matriz")
		self.Cabeza =Nodo2
	def Eliminar(self,correo,letra,dato):
		print("llego al metodo eliminar")
		aux=self.Cabeza.getAbajo()
		while aux!=Nodo2:
			if aux.getDato()==letra:
				print(str(letra)+" "+aux.getDato())
				aux2=aux
				while aux2!=Nodo2:
					if aux2.Co==correo:
						print(correo+" "+aux2.Co)
						if aux2.getDato()==dato:
							if aux2.getArriba()!=Nodo2 and aux2.getAbajo()!=Nodo2 and aux2.getDerecha()!=Nodo2 and aux2.getIzquierda()!=Nodo2:
								print("llego")
								aux2.getArriba().setAbajo(aux2.getAbajo())
								aux2.getAbajo().setArriba(aux2.getArriba())
								aux2.getIzquierda().setDerecha(aux2.getDerecha())
								aux2.getDerecha().setIzquierda(aux2.getIzquierda())
								aux2=None
								break
								print("2")
								pass
							if aux2.getArriba()!=Nodo2 and aux2.getAbajo()==Nodo2 and aux2.getDerecha()==Nodo2 and aux2.getIzquierda()!=Nodo2 and aux2.getArriba().dato==correo and aux2.getIzquierda().dato==letra:
								print"nodo unico"
								auxcor=aux2.getArriba()
								auxler=aux2.getIzquierda()
								if auxcor.getDerecha()==Nodo2:
									auxcor.getIzquierda().setDerecha(Nodo2)
									auxcor=None
								else:
									auxcor.getDerecha().setIzquierda(auxcor.getIzquierda())
									auxcor.getIzquierda().setDerecha(auxcor.getDerecha)
									auxcor=None
									pass
								auxler.getArriba().setAbajo(Nodo2)
								auxler=None
								aux2=None
								break
								pass
						else:
							pass
						pass
					aux2=aux2.getDerecha()
					pass
				pass
			aux=aux.getAbajo()
			pass
	def VerPorDominio(self,correo):
		tx=""
		aux = self.Cabeza
		while correo!=aux.getDato():
			aux=aux.getDerecha()
			pass
		tx= str(tx)+ "rank = same {  \n"
		while aux.getAbajo()!=Nodo2:
			tx= str(tx)+aux.Le+aux.Co+"[shape=box,label=\""+aux.getDato()+"\"] \n"
			tx= str(tx)+aux.getAbajo().Le+aux.getAbajo().Co+"[shape=box,label=\""+aux.getAbajo().getDato()+"\"] \n"
			tx= str(tx)+aux.Le+aux.Co+"->"+aux.getAbajo().Le+aux.getAbajo().Co+" \n"
			tx= str(tx)+aux.getAbajo().Le+aux.getAbajo().Co+"->"+aux.Le+aux.Co+" \n"
			if aux.getAbajo().Nombres.Vacia==1:
				tx= str(tx)+aux.getAbajo().Le+aux.getAbajo().Co+"->"+aux.getAbajo().Nombres.Cabeza.dato+"\n"
				tx= str(tx)+"subgraph "+aux.getAbajo().getDato()+"{ \n"
				tx= str(tx)+aux.getAbajo().Nombres.Datosgrafica()+"\n"
				tx= str(tx)+"}\n"
				pass
			aux=aux.getAbajo()
			pass
		tx=str(tx)+"} \n"
		return tx
	def VerPorLetra(self,letra):
		tx=""
		aux = self.Cabeza
		while aux.getDato()!=letra:
			aux= aux.getAbajo()
			pass
		tx= str(tx)+ "rank = same {  \n"
		while aux.getDerecha()!=Nodo2:
			tx= str(tx)+aux.Le+aux.Co+"[shape=box,label=\""+aux.getDato()+"\"] \n"
			tx= str(tx)+aux.getDerecha().Le+aux.getDerecha().Co+"[shape=box,label=\""+aux.getDerecha().getDato()+"\"] \n"
			tx= str(tx)+aux.Le+aux.Co+"->"+aux.getDerecha().Le+aux.getDerecha().Co+" \n"
			tx= str(tx)+aux.getDerecha().Le+aux.getDerecha().Co+"->"+aux.Le+aux.Co+" \n"
			if aux.getDerecha().Nombres.Vacia==1:
				tx= str(tx)+aux.getDerecha().Le+aux.getDerecha().Co+"->"+aux.getDerecha().Nombres.Cabeza.dato+"\n"
				tx= str(tx)+"subgraph "+aux.getDerecha().getDato()+"{ \n"
				tx= str(tx)+aux.getDerecha().Nombres.Datosgrafica()+"\n"
				tx= str(tx)+"}\n"
				pass
			aux=aux.getDerecha()
			pass
		tx=str(tx)+"} \n"
		return tx
	def VerMatriz(self):
		tx=""
		aux=self.Cabeza
		while aux!=Nodo2:
			tx= str(tx)+ "rank = same {  \n"
			aux2=aux
			lado=0
			letra=aux2.getDato()
			while aux2.getDerecha()!=Nodo2:         #letras recorrer a la derecha
				sig=aux2.getDerecha()
				#sigar=sig.getArriba()
				tx=str(tx)+letra+str(aux2.Co)+"[shape=box,label=\""+aux2.getDato()+"\"] \n"
				tx=str(tx)+letra+str(sig.Co)+"[shape=box,label=\""+sig.getDato()+"\"] \n"
				#tx=str(tx)+sigar.Le+str(lado+1)+"[shape=box,label=\""+sigar.getDato()+"\"] "
				tx=str(tx)+letra+str(aux2.Co)+"->"+letra+str(sig.Co)+" \n"
				tx=str(tx)+letra+str(sig.Co)+"->"+letra+str(aux2.Co)+" \n"
				#tx=str(tx)+sigar.Le+str(lado+1)+"->"+letra+str(lado+1)+" "
				#tx=str(tx)+letra+str(lado+1)+"->"+sigar.Le+str(lado+1)+" "
				aux2=aux2.getDerecha()
				lado=lado+1
				pass
			tx=str(tx)+"} \n"
			aux=aux.getAbajo()
			pass
		auxl=self.Cabeza
		ladol=0
		while auxl!=Nodo2:
			auxl2=auxl
			while auxl2.getAbajo()!=Nodo2:
				sigl=auxl2.getAbajo()
				tx=str(tx)+auxl2.Le+str(auxl2.Co)+"->"+sigl.Le+str(auxl2.Co)+" \n"
				tx=str(tx)+sigl.Le+str(auxl2.Co)+"->"+auxl2.Le+str(auxl2.Co)+" \n"
				auxl2=auxl2.getAbajo()
				pass
			pass
			ladol=ladol+1
			auxl=auxl.getDerecha()		
		return tx
	def AddNodo(self,correo,letra,dato):
		if self.Cabeza== Nodo2:
			self.Cabeza=Nodo2()
			self.Cabeza.setDato("lMMl")
			self.Cabeza.Le="lMMl"
			self.Cabeza.Co="lMMl"
			nuevo = Nodo2()
			nuevo.Co=correo
			nuevo.Le=letra
			nuevo.setDato(dato)
			nuevocorreo = Nodo2()
			nuevocorreo.setDato(correo)
			nuevocorreo.Le="lMMl"
			nuevocorreo.Co=correo
			nuevoletra= Nodo2()
			nuevoletra.setDato(letra)
			nuevoletra.Le=letra
			nuevoletra.Co="lMMl"
			self.Cabeza.setAbajo(nuevoletra)
			nuevoletra.setArriba(self.Cabeza)
			self.Cabeza.setDerecha(nuevocorreo)
			nuevocorreo.setIzquierda(self.Cabeza)
			nuevocorreo.setAbajo(nuevo)
			nuevo.setArriba(nuevocorreo)
			nuevoletra.setDerecha(nuevo)
			nuevo.setIzquierda(nuevoletra)
		else:
			aux = self.Cabeza
			llave = "0"
			paquete=Nodo2
			while llave == "0":	
				auxgua=aux
				if aux.getAbajo()==Nodo2:						#si la letra no existe se crea y se sigue
					nuevor = Nodo2()
					print("nodooputo0")
					nuevor.setDato(letra)
					nuevor.Le=letra
					nuevor.Co="lMMl"
					auxgua.setAbajo(nuevor)
					nuevor.setArriba(auxgua)
					aux=self.Cabeza
					pass
				aux= aux.getAbajo()
				if aux.dato>letra:								#agregar letra nueva en medio
					llave="1"
					auxar=aux.getArriba()
					nuevo=Nodo2()
					print("nodoo1")
					nuevo.setDato(letra)
					nuevo.Le=letra
					nuevo.Co="lMMl"
					auxar.setAbajo(nuevo)
					nuevo.setArriba(auxar)
					nuevo.setAbajo(aux)
					aux.setArriba(nuevo)
					aux=nuevo
					pass
				if aux.dato==letra:								#si es igual letra se empieza a recoorrer a derecha
					llave="1"
					auxder=aux
					llaveder="0"
					while llaveder=="0":
						if auxder.getDerecha() == Nodo2:			# Si ya no hay nodo a la derecha se crea uno
							nuevo = Nodo2()
							paquete=nuevo
							print("nodoo2")
							nuevo.setDato(dato)
							nuevo.Co=correo
							nuevo.Le=letra
							auxder.setDerecha(nuevo)
							nuevo.setIzquierda(auxder)			#falta
							llaveder="1"
						else:
							auxder=auxder.getDerecha()
							print("busqueda del co")
							if auxder.Co==correo:				#ya existe el nodo y se agrega el dato a la cola
								print("se agrego dato a la lista")
								auxder.Nombres.AddNodo(dato)
								llaveder="1"					#falta reslver no se manda indice
								pass
							if auxder.Co > correo:				#Para insertar el nodo en medio
								auxderaux=auxder.getIzquierda()
								nuevo= Nodo2()
								paquete=nuevo
								print("nodoo3")
								nuevo.setDato(dato)
								nuevo.Co=correo
								nuevo.Le=letra
								nuevo.setDerecha(auxder)
								auxder.setIzquierda(nuevo)
								auxderaux.setDerecha(nuevo)
								nuevo.setIzquierda(auxderaux)
								llaveder="1"
								pass
							pass
						pass
					pass
				pass #Pass del primer while
			aux2 = self.Cabeza
			llave2 = "0"
			while llave2 == "0":
				if aux2.getDerecha()==Nodo2:
					nuevor = Nodo2()
					print("paso 0")
					nuevor.setDato(correo)
					nuevor.Le="lMMl"
					nuevor.Co=correo
					aux2.setDerecha(nuevor)
					nuevor.setIzquierda(aux2)
					aux2=self.Cabeza
					pass
				aux2=aux2.getDerecha()
				if aux2.dato>correo:
					llave2="1"
					auxiz=aux2.getIzquierda()
					nuevo=Nodo2()
					print("Paso 1")
					nuevo.setDato(correo)
					nuevo.Co=correo
					nuevo.Le="lMMl"
					auxiz.setDerecha(nuevo)
					nuevo.setIzquierda(auxiz)
					nuevo.setDerecha(aux2)
					aux2.setIzquierda(nuevo)
					aux2=nuevo
					pass
				if aux2.dato==correo:
					llave2="1"
					auxab=aux2
					llaveab="0"
					while llaveab=="0":					#
						if auxab.getAbajo()==Nodo2:
							print("Paso 2")
							if paquete!=Nodo2:
								auxab.setAbajo(paquete)
								paquete.setArriba(auxab)
								pass
							llaveab="1"
						else:
							auxab=auxab.getAbajo()
							print("busqueda")
							if auxab.Le>letra:
								auxabaux=auxab.getArriba()
								print("Paso 3")
								if paquete!=Nodo2:
									paquete.setAbajo(auxab)
									auxab.setArriba(paquete)
									auxabaux.setAbajo(paquete)
									paquete.setArriba(auxabaux)
									pass
								llaveab="1"
								pass
							pass
						pass
					pass
				pass #Pass del segudo while
			pass
class ListaSimple:
    			"""docstring for ListaSimple"""
			def __init__(self):
				print("Constructor de Lista Simple")
				self.Cabeza = Nodo1
				self.Largo = 0
				self.Vacia = 0
			def Datosgrafica(self):
				aux = self.Cabeza
				texto=""
				if aux.Siguiente == Nodo1:
					texto=aux.getDato()
				else:
					while aux.Siguiente!=Nodo1:
						texto =str(texto) + str(aux.getSiguiente().getDato()) + " -> " + str(aux.getDato()) + ";\n"
						print(aux.getDato(),"->",aux.getSiguiente().getDato())
						aux=aux.getSiguiente()
						pass
					pass
				return texto
			def Vaciaka (self):
				return self.Vacia
			def Buscar(self, datobusqueda):
				contador =0
				aux = self.Cabeza
				encontrado = "false"
				while contador != self.Largo:
					contador+=1
					auxcontador=contador
					if aux.getDato() == datobusqueda:
						auxcontador=contador
						contador = self.Largo
						encontrado="true"
						pass
					aux= aux.getSiguiente()
					pass	
				if encontrado=="false":
					auxcontador="false"
					pass
				if encontrado=="true":
					auxcontador-=1
					pass
				return auxcontador
			def Eliminar(self, index):
				if 1==1:
					if index=="0":
						self.Cabeza= self.Cabeza.getSiguiente()
					else:
						aux=self.Cabeza
						for x in xrange(1,int(index)):
							aux = aux.getSiguiente()
							pass
						nod = aux.getSiguiente()
						aux.setSiguiente(nod.getSiguiente())
						pass
					self.Largo-=1
					pass
			def AddNodo(self,dato):
				nuevo = Nodo1()
				nuevo.setDato(dato)
				self.Largo+=1
				if self.Vaciaka()==1:
					"""print("llena")"""
					aux = self.Cabeza
					while aux.Siguiente != Nodo1:
						aux= aux.getSiguiente()
						pass
					aux.setSiguiente(nuevo)
					pass
				if self.Vaciaka()==0:
					"""print("vacia")"""
					self.Vacia=1
					self.Cabeza=nuevo
					pass
from flask import Flask, request, Response
app = Flask("EDD_codigo_ejemplo")
@app.route('/agregaramatriz',methods=['POST']) 
def hellobfdf():
	parametro = str(request.form['empresa'])
	parametro2 = str(request.form['departamento'])
	parametro3 = str(request.form['usuario'])
	matriz.AddNodo(parametro,parametro2,parametro3)
	return "Se ha Agreagdo un nuevo dato a la matriz ((" + str(parametro3)+ "))"
@app.route('/Vermatriz',methods=['POST']) 
def helloladdd():
	parametro = str(request.form['dato'])
	gato = matriz.VerMatriz()
	return str(gato)
@app.route("/e")
def hellof():
	return "Hello World2!"
if __name__ == "__main__":
      matriz = Matriz()
      app.run(debug=True, host='192.168.43.165')
            #app.run(debug=True, host='0.0.0.0')
      #app.run(debug=True, host='192.168.0.21')