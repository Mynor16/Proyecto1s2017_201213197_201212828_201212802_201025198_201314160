using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EddHistorialesP1.Models;


namespace EddHistorialesP1.Controllers
{
    public class EddTransactionsController : ApiController
    {
        
        nodoArbolB[] products = new nodoArbolB[] 
        { 
            new nodoArbolB{idT = "11", idP = "01", nameUser = "usuario1", EmpresaUser = "cocacola",deptUser="ventas",fechaRenta = "01/01/2017",periodoRenta = 3},
            new nodoArbolB{idT = "12", idP = "02", nameUser = "usuario2", EmpresaUser = "pepsi",deptUser="recursos humanos",fechaRenta = "02/01/2017",periodoRenta = 4},
            new nodoArbolB{idT = "13", idP = "03", nameUser = "usuario3", EmpresaUser = "tortrix",deptUser="sevicios",fechaRenta = "30/01/2017",periodoRenta = 7},
            new nodoArbolB{idT = "14", idP = "04", nameUser = "usuario4", EmpresaUser = "avon",deptUser="ventas",fechaRenta = "10/05/2017",periodoRenta = 15},
            new nodoArbolB{idT = "15", idP = "05", nameUser = "usuario5", EmpresaUser = "gallo",deptUser="recursos humanos",fechaRenta = "015/01/2017",periodoRenta = 2},
            new nodoArbolB{idT = "16", idP = "06", nameUser = "usuario6", EmpresaUser = "intel",deptUser="sevicios",fechaRenta = "16/06/2017",periodoRenta = 28},
            new nodoArbolB{idT = "17", idP = "07", nameUser = "usuario1", EmpresaUser = "cocacola",deptUser="ventas",fechaRenta = "01/01/2017",periodoRenta = 3},
            new nodoArbolB{idT = "18", idP = "08", nameUser = "usuario2", EmpresaUser = "pepsi",deptUser="recursos humanos",fechaRenta = "02/01/2017",periodoRenta = 4},
            new nodoArbolB{idT = "19", idP = "09", nameUser = "usuario3", EmpresaUser = "tortrix",deptUser="sevicios",fechaRenta = "30/01/2017",periodoRenta = 7},
            new nodoArbolB{idT = "20", idP = "10", nameUser = "usuario4", EmpresaUser = "avon",deptUser="ventas",fechaRenta = "10/05/2017",periodoRenta = 15},
            new nodoArbolB{idT = "21", idP = "11", nameUser = "usuario5", EmpresaUser = "gallo",deptUser="recursos humanos",fechaRenta = "015/01/2017",periodoRenta = 2},
            new nodoArbolB{idT = "22", idP = "12", nameUser = "usuario6", EmpresaUser = "intel",deptUser="sevicios",fechaRenta = "16/06/2017",periodoRenta = 28},
        };
        //public static EddP1ArbolB arbolB = new EddP1ArbolB();
        public static ArbolB arbolB = new ArbolB();

        public void llenaArbol()
        {
            /*arbolB.insertar(products[0]);
            arbolB.insertar(products[1]);
            arbolB.insertar(products[2]);
            arbolB.insertar(products[3]);
            arbolB.insertar(products[4]);
            arbolB.insertar(products[5]);
            arbolB.insertar(products[11]);
            arbolB.insertar(products[7]);
            arbolB.insertar(products[9]);
            arbolB.insertar(products[6]);
            arbolB.insertar(products[10]);
            arbolB.insertar(products[8]);*/
            arbolB.ingresar(products[0]);
            arbolB.ingresar(products[1]);
            arbolB.ingresar(products[2]);
            arbolB.ingresar(products[3]);
            arbolB.ingresar(products[4]);
            arbolB.ingresar(products[5]);
            arbolB.ingresar(products[11]);
            arbolB.ingresar(products[7]);
            arbolB.ingresar(products[9]);
            arbolB.ingresar(products[6]);
            arbolB.ingresar(products[10]);
            arbolB.ingresar(products[8]);
            arbolB.Graficar("ArbolBEDDnuevo");
            arbolB.EliminarNodo("17");
            arbolB.Graficar("ArbolBEDDNodoEliminado");
            return;
        }
        public IEnumerable<nodoArbolB> GetAllProducts()
        {
            return products;
        }

        public IHttpActionResult GetProduct(string id)
        {
            llenaArbol();
            var product = products.FirstOrDefault((p) => p.idT == id);
            if (product == null)
            {
                return NotFound();
            }
            System.Diagnostics.Debug.WriteLine("Se encontro el producto " + product.idT);
            return Ok(product);
        }
    }
}
