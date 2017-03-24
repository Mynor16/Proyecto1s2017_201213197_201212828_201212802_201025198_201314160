using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EddHistorialesP1.Models
{
    public class EddP1PaginaArbolB
    {
        public nodoArbolB[] claves;
        public EddP1PaginaArbolB[] ramas;
        public int cuenta = 0;
        public int idPagina = 0;
        public EddP1PaginaArbolB()
        {
            ramas = new EddP1PaginaArbolB[5];
            claves = new nodoArbolB[4];
        }
        public EddP1PaginaArbolB(nodoArbolB clave)
        {
            ramas = new EddP1PaginaArbolB[5];
            claves = new nodoArbolB[4];
            claves[0] = clave;
            cuenta++;
        }
        public Boolean estaVacia()
        {
            if (cuenta == 0) return true;
            else return false;
        }
        public Boolean estaLlena()
        {
            if (cuenta > 3) return true;
            else return false;
        }
        public void insertaOrdenado(nodoArbolB clave, int pos, EddP1PaginaArbolB ramaDerecha)
        {
            for (int i = cuenta; i > pos; i--)
            {
                claves[i] = claves[i - 1];
                ramas[i + 1] = ramas[i];
            }
            claves[pos] = clave;
            ramas[pos + 1] = ramaDerecha;
            cuenta++;
        }
    }
}