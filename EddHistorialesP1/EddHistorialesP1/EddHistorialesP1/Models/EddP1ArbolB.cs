using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EddHistorialesP1.Models
{
    public class EddP1ArbolB
    {
        EddP1PaginaArbolB P = new EddP1PaginaArbolB();
        EddP1PaginaArbolB xr = new EddP1PaginaArbolB();
        EddP1PaginaArbolB xIz = new EddP1PaginaArbolB();
        EddP1PaginaArbolB xDer = new EddP1PaginaArbolB();
        nodoArbolB x;
        int cuentaPaginas = 0;
        string salida = "";
        string imps = "";
        Boolean vacia = false;
        Boolean existe = false;

        //inseta un nuevo nodo en el arbol B
        public void insertar(nodoArbolB clave)
        {
            ingresar(clave, P);
        }

        //metodo auxiliar que inserta el nuevo nodo en el arbol B
        public void ingresar(nodoArbolB clave, EddP1PaginaArbolB raiz)
        {
            empujar(clave, raiz);
            if (vacia)
            {
                P = new EddP1PaginaArbolB();
                P.idPagina = cuentaPaginas;
                cuentaPaginas++;
                P.cuenta = 1;
                P.claves[0] = x;
                P.ramas[0] = raiz;
                P.ramas[1] = xr;
                //System.Diagnostics.Debug.WriteLine("inserción de nodo en la raiz con id: "+P.idPagina);

            }
            System.Diagnostics.Debug.WriteLine("inserción correcta de nodo :) -> " + raiz.idPagina + "." + clave.idT);//+P.claves[0].idT);
        }

        //empuja los elementos previos
        public void empujar(nodoArbolB clave, EddP1PaginaArbolB raiz)
        {
            int k = 0;
            existe = false;
            if (vacio(raiz))
            {
                vacia = true;
                x = clave;
                xr = null;
            }
            else
            {
                k = buscarNodo(clave, raiz);
                if (existe)
                {
                    System.Diagnostics.Debug.WriteLine("no se encontro repetida la clave");
                    vacia = false;
                }
                else
                {
                    empujar(clave, raiz.ramas[k]);
                    if (vacia)
                    {
                        if (raiz.cuenta < 4)
                        {
                            vacia = false;
                            insertaHoja(x, raiz, k);
                        }
                        else
                        {
                            vacia = true;
                            dividirN(x, raiz, k);
                        }
                    }
                }
            }
        }

        //incerta una nueva clave en la pagina actual
        public void insertaHoja(nodoArbolB clave, EddP1PaginaArbolB raiz, int k)
        {
            System.Diagnostics.Debug.WriteLine("incertando nodo en la pagina " + raiz.idPagina);
            int i = raiz.cuenta;
            while (i != k)
            {
                raiz.claves[i] = raiz.claves[i - 1];
                System.Diagnostics.Debug.WriteLine("trasladando clave " + (i) + " de la rama " + raiz.idPagina + " a la posición " + (i - 1) + " de la nueva pagina " + raiz);
                raiz.ramas[i + 1] = raiz.ramas[i];
                System.Diagnostics.Debug.WriteLine("trasladando clave " + (i + 1) + " de la rama " + raiz.idPagina + " a la posición " + (i) + " de la nueva pagina " + raiz);


                i--;
            }
            raiz.claves[k] = clave;
            System.Diagnostics.Debug.WriteLine("se incertó la clave " + raiz.claves[k].idT + " en la posición " + k + "de la pagina " + raiz.idPagina);
            raiz.ramas[k + 1] = xr;
            raiz.cuenta = ++raiz.cuenta;
        }

        //dividir pagina
        public void dividirN(nodoArbolB clave, EddP1PaginaArbolB raiz, int k)
        {
            System.Diagnostics.Debug.WriteLine("dividiendo pagina " + raiz.idPagina);
            int pos = 0;
            int posmda = 0;
            if (k <= 2)
            {
                posmda = 2;
            }
            else
            {
                posmda = 3;
            }
            EddP1PaginaArbolB xDer = new EddP1PaginaArbolB();
            xDer.idPagina = cuentaPaginas;
            cuentaPaginas++;
            pos = posmda + 1;
            while (pos != 5)
            {
                System.Diagnostics.Debug.WriteLine("trasladando clave " + (pos - 1) + " de la rama " + raiz.idPagina + " a la posición " + (pos - posmda - 1) + " de la nueva pagina " + xDer.idPagina);
                xDer.claves[(pos - posmda) - 1] = raiz.claves[pos - 1];
                xDer.ramas[pos - posmda] = raiz.ramas[pos];
                pos++;
            }
            xDer.cuenta = 4 - posmda;
            raiz.cuenta = posmda;
            if (k <= 2)
            {
                insertaHoja(clave, raiz, k);
            }
            else
            {
                insertaHoja(clave, xDer, (k - posmda));
            }
            x = raiz.claves[raiz.cuenta - 1];
            xDer.ramas[0] = raiz.ramas[raiz.cuenta];
            raiz.cuenta = raiz.cuenta--;
            xr = xDer;
        }

        public Boolean vacio(EddP1PaginaArbolB raiz)
        {
            return (raiz == null || raiz.cuenta == 0);
        }

        public int buscarNodo(nodoArbolB clave, EddP1PaginaArbolB actual)
        {
            int j = 0;
            if (int.Parse(clave.idT) < int.Parse(actual.claves[0].idT))
            {
                existe = false;
                j = 0;
            }
            else
            {
                j = actual.cuenta;
                while (int.Parse(clave.idT) < int.Parse(actual.claves[j - 1].idT) && j > 1)
                    --j;
                existe = (clave.idT == actual.claves[j - 1].idT);
            }
            System.Diagnostics.Debug.WriteLine("se encontró el espacio en la posición " + j + "de la pagina " + actual.idPagina);
            return j;
        }

        #region EliminarNodo
        public void EliminarNodo(String codigo)
        {
            var tempraiz = this.P;
            this.P = null;
            if (!String.IsNullOrEmpty(codigo)) EliminarNodo(codigo, tempraiz);
        }

        private void EliminarNodo(String codigo, EddP1PaginaArbolB raiz)
        {
            if (raiz != null)
            {
                for (int i = 0; i < raiz.claves.Count(); i++)
                    if (!raiz.claves[i].Equals(codigo)) this.insertar(raiz.claves[i]);
                for (int i = 0; i < raiz.ramas.Count(); i++)
                    EliminarNodo(codigo, raiz.ramas[i]);
            }
        }

        #endregion

        //*******************************************************************************************************
        void eliminar(nodoArbolB clave)
        {
            if (vacio(P))
            {
                System.Console.WriteLine("no hay elementos");
            }
            else
                Eliminara(P, clave);
        }

        public void Eliminara(EddP1PaginaArbolB Raiz, nodoArbolB clave)
        {
            try
            {
                EliminarRegistro(Raiz, clave);
            }
            catch (Exception e)
            {
                existe = false;
            }
            if (!existe)
                System.Diagnostics.Debug.WriteLine("no se encontró el elemento");
            else
            {
                if (Raiz.cuenta == 0)
                    Raiz = Raiz.ramas[0];
                P = Raiz;
                System.Diagnostics.Debug.WriteLine("eliminación exitosa");
            }
        }

        //Elimina el registro
        public void EliminarRegistro(EddP1PaginaArbolB raiz, nodoArbolB c)
        {
            int pos = 0;
            nodoArbolB sucesor;
            if (vacio(raiz))
                existe = false;
            else
            {
                pos = buscarNodo(c, raiz);
                if (existe)
                {
                    if (vacio(raiz.ramas[pos - 1]))
                        Quitar(raiz, pos);
                    else
                    {
                        Sucesor(raiz, pos);
                        EliminarRegistro(raiz.ramas[pos], raiz.claves[pos - 1]);
                    }
                }
                else
                {
                    EliminarRegistro(raiz.ramas[pos], c);
                    if ((raiz.ramas[pos] != null) && (raiz.ramas[pos].cuenta < 2))
                        Restablecer(raiz, pos);
                }
            }
        }

        //Busca el sucesor
        public void Sucesor(EddP1PaginaArbolB raiz, int k)
        {
            EddP1PaginaArbolB q = raiz.ramas[k];
            while (!vacio(q.ramas[0]))
                q = q.ramas[0];
            raiz.claves[k - 1] = q.claves[0];
        }

        //Combina para formar una pagina
        public void Combina(EddP1PaginaArbolB raiz, int pos)
        {
            int j;
            xDer = raiz.ramas[pos];
            xIz = raiz.ramas[pos - 1];
            xIz.cuenta++;
            xIz.claves[xIz.cuenta - 1] = raiz.claves[pos - 1];
            xIz.ramas[xIz.cuenta] = xDer.ramas[0];
            j = 1;
            while (j != xDer.cuenta + 1)
            {
                xIz.cuenta++;
                xIz.claves[xIz.cuenta - 1] = xDer.claves[j - 1];
                xIz.ramas[xIz.cuenta] = xDer.ramas[j];
                j++;
            }
            Quitar(raiz, pos);
        }

        //Mueve a la derecha
        public void MoverDer(EddP1PaginaArbolB raiz, int pos)
        {
            int i = raiz.ramas[pos].cuenta;
            while (i != 0)
            {
                raiz.ramas[pos].claves[i] = raiz.ramas[pos].claves[i - 1];
                raiz.ramas[pos].ramas[i + 1] = raiz.ramas[pos].ramas[i];
                --i;
            }
            raiz.ramas[pos].cuenta++;
            raiz.ramas[pos].ramas[1] = raiz.ramas[pos].ramas[0];
            raiz.ramas[pos].claves[0] = raiz.claves[pos - 1];
            raiz.claves[pos - 1] = raiz.ramas[pos - 1].claves[raiz.ramas[pos - 1].cuenta - 1];
            raiz.ramas[pos].ramas[0] = raiz.ramas[pos - 1].ramas[raiz.ramas[pos - 1].cuenta];
            raiz.ramas[pos - 1].cuenta--;
        }

        //Mover a la izquierda
        public void MoverIzq(EddP1PaginaArbolB raiz, int pos)
        {
            int i;
            raiz.ramas[pos - 1].cuenta++;
            raiz.ramas[pos - 1].claves[raiz.ramas[pos - 1].cuenta - 1] = raiz.claves[pos - 1];
            raiz.ramas[pos - 1].ramas[raiz.ramas[pos - 1].cuenta] = raiz.ramas[pos].ramas[0];
            raiz.claves[pos - 1] = raiz.ramas[pos].claves[0];
            raiz.ramas[pos].ramas[0] = raiz.ramas[pos].ramas[1];
            raiz.ramas[pos].cuenta--;
            i = 1;
            while (i != raiz.ramas[pos].cuenta + 1)
            {
                raiz.ramas[pos].claves[i - 1] = raiz.ramas[pos].claves[i];
                raiz.ramas[pos].ramas[i] = raiz.ramas[pos].ramas[i + 1];
                i++;
            }
        }

        //Quita el elemento
        public void Quitar(EddP1PaginaArbolB raiz, int pos)
        {
            int j = pos + 1;
            while (j != raiz.cuenta + 1)
            {
                raiz.claves[j - 2] = raiz.claves[j - 1];
                raiz.ramas[j - 1] = raiz.ramas[j];
                j++;
            }
            raiz.cuenta--;
        }

        //Restablece el nodo
        public void Restablecer(EddP1PaginaArbolB raiz, int pos)
        {
            if (pos > 0)
            {
                if (raiz.ramas[pos - 1].cuenta > 2)
                    MoverDer(raiz, pos);
                else
                    Combina(raiz, pos);
            }
            else
            {
                if (raiz.ramas[1].cuenta > 2)
                    MoverIzq(raiz, 1);
                else
                    Combina(raiz, 1);
            }
        }
    }
}