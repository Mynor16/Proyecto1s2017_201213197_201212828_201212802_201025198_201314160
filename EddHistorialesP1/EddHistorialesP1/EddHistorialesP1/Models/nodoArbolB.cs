using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EddHistorialesP1.Models
{
    public class nodoArbolB
    {
        public String idT { get; set; } // id transacción
        public String idP { get; set; } // id del producto prestado
        public String nameUser { get; set; } // nombre del usuario que prestó el equipo
        public String EmpresaUser { get; set; } // empresa del usuario que prestó el equipo
        public String deptUser { get; set; } // departamento del usuario que prestó el equipo
        public String fechaRenta { get; set; } // fecha en que se prestó el equipo
        public int periodoRenta { get; set; } // teimpo que se tendrá el equipo prestado.
        public Boolean rentado { get; set; }// disponibilidad actualpara la renta

    }
}