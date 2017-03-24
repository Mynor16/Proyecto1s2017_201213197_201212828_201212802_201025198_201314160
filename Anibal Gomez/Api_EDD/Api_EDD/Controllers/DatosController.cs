using Api_EDD.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;



namespace Api_EDD.Controllers
{
    public class DatosController : ApiController
    {

        Datos[] datos = new Datos[] 
        

        { 
            new Datos { Id = 1, Cadena = "Tomato Soup" }, 
            new Datos { Id = 2, Cadena = "Yo-yo"}, 
            new Datos { Id = 3, Cadena = "Hammer" }
 
        };

        public IEnumerable<Datos> GetAllProducts()
        {
            return datos;
        }

        public IHttpActionResult GetProduct(int id)
        {
            var dato = datos.FirstOrDefault((p) => p.Id == id);
            if (dato == null)
            {
                return NotFound();
            }
            return Ok(dato);
        
        }


    }
}
