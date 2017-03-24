using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EddHistorialesP1.Models
{
    public class EddP1PaginaArbolB
    {
        public nodoArbolB[] claves = new nodoArbolB[4];
        public EddP1PaginaArbolB[] ramas = new EddP1PaginaArbolB[5];
        public int cuenta = 0;
    }
}