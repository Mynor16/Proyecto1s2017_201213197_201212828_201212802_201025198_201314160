using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;

namespace EddHistorialesP1.Models
{
    public class ArbolB
    {
        EddP1PaginaArbolB raiz;
        int auxPos;
        nodoArbolB claveMedia;
        EddP1PaginaArbolB auxDe;
        int pagina = 0;
        bool Esta;
        String [] IDencontrados;
        int contador=0;

        public ArbolB()
        {
            raiz = new EddP1PaginaArbolB();
            auxDe = null;
        }

        private Boolean BuscarNodoEnPagina(nodoArbolB clave, EddP1PaginaArbolB raiz)
        {
            // VERIFICAMOS SI LA CLAVE ES MENOR A LA PAGINA PARA IR EN LA PRIMER PAGINA
            if (0 > string.Compare(clave.idT, raiz.claves[0].idT))
            {
                this.auxPos = 0;
                return false;
            }
            else
            {
                int limite = raiz.cuenta;
                //BUSCAMOS LA POSICION DONDE SE ENCUENTRA LA CLAVE O DONDE DEBERIA ESTAR
                while (0 > string.Compare(clave.idT, raiz.claves[limite - 1].idT))
                {
                    limite--;
                }
                this.auxPos = limite;
                //VALIDAMOS SI ES IGUAL A LA CLAVE
                if (clave.idT == raiz.claves[limite - 1].idT)
                {
                    return true;
                }
                return false;
            }
        }

        public void ingresar(nodoArbolB clave)
        {
            insertar(this.raiz, clave);
        }

        public void insertar(EddP1PaginaArbolB raiz, nodoArbolB clave)
        {
            // VERIFICAMOS SI LA PAGINA ESTA VACIA
            if (raiz.estaVacia())
            {
                raiz.insertaOrdenado(clave, 0, null);
            }
            else
            {
                //BUSCAMOS EL NODO EN LA PAGINA
                if (BuscarNodoEnPagina(clave, raiz))
                {
                    // Nodo repetido, no se puede ingresar
                    System.Diagnostics.Debug.WriteLine("nodo repetido");
                    // Agregar anuncio en ANDROID ;)
                }
                else
                {

                    // VERIFICACMOS SI EXISTEN RAMAS EN ESA POSICION
                    if (raiz.ramas[auxPos] == null)
                    {
                        //VERIFICAMOS SI LA PAGINA ESTA LLENA
                        if (raiz.estaLlena())
                        {
                            // DIVIDIMOS PAGINA
                            DividirPagina(clave, raiz);
                        }
                        else
                        {
                            //INSERTAMOS EN ESTA PAGINA
                            raiz.insertaOrdenado(clave, auxPos, null);
                            contador++;
                            //****** Inserccion completa
                        }
                    }
                    else
                    {
                        // MANDAMOS A INSERTAR EN LA PAGINA HIJA 
                        insertar(raiz.ramas[auxPos], clave);
                        contador++;
                        // VERIFICAMOS SI EN LA PAGINA HIJA HUBO UNA DIVISION DE PAGINA
                        if (claveMedia != null)
                        {
                            //BUSCAMOS LA POSICION DE LA CLAVE MEDIA DE LA PAGINA HIJA DIVIDIDA
                            BuscarNodoEnPagina(claveMedia, raiz);
                            //VERIFICAMOS SI LA PAGINA PADRE ESTA LLENA
                            if (raiz.estaLlena())
                            {
                                // DIVIDIMOS PAGINA PADRE
                                DividirPagina(claveMedia, raiz);
                            }
                            else
                            {
                                //INSERTAMOS EN LA PAGINA PADRE LA CLAVE MEDIA
                                raiz.insertaOrdenado(claveMedia, auxPos, auxDe);
                                claveMedia = null;
                                auxDe = null;
                                //****** Inserccion completa
                            }
                        }
                    }
                }
            }
        }

        private void DividirPagina(nodoArbolB clave, EddP1PaginaArbolB raiz)
        {

            EddP1PaginaArbolB auxdel = new EddP1PaginaArbolB();
            //VERIFICAMOS SI ARRASTRAMOS UNA PAGINA DERECHA DEBIDO A UNA DIVISION ANTERIOR
            if (auxDe == null)
            {
                auxdel.ramas[0] = null;
            }
            else
            {
                auxdel.ramas[0] = auxDe;
            }
            auxDe = auxdel;
            int posmedia = 0;
            if (auxPos <= 2)
            {
                //INSERTAMOS LAS ULTIMAS DOS CLAVES EN LA PAGINA DERECHA
                auxdel.insertaOrdenado(raiz.claves[2], 0, raiz.ramas[3]);
                auxdel.insertaOrdenado(raiz.claves[3], 1, raiz.ramas[4]);
                //INSERTAMOS LAS PRIMERAS DOS CLAVES EN LA PAGINA IZQUIERDA
                raiz.cuenta = 3;
                raiz.insertaOrdenado(clave, auxPos, null);
                raiz.cuenta = 2;
                //EXTRAEMOS LA CLAVEMEDIA
                claveMedia = raiz.claves[2];
            }
            else
            {
                //INSERTAMOS LAS ULTIMAS DOS CLAVES EN LA PAGINA DERECHA
                auxdel.insertaOrdenado(raiz.claves[3], 0, raiz.ramas[4]);
                EddP1PaginaArbolB rama = (auxPos == 4) ? null : raiz.ramas[3];
                auxdel.insertaOrdenado(clave, auxPos - 3, rama);
                //INSERTAMOS LAS PRIMERAS DOS CLAVES EN LA PAGINA IZQUIERDA
                raiz.cuenta = 2;
                claveMedia = raiz.claves[2];
                posmedia = 2;
            }
            // VERIFICAMOS SI LA PAGINA QUE SE DIVIDIO ES LA RAIZ PARA CREAR UNA NUEVA RAIZ
            if (raiz == this.raiz)
            {
                EddP1PaginaArbolB nuevaraiz = new EddP1PaginaArbolB();
                nuevaraiz.ramas[0] = raiz;
                nuevaraiz.insertaOrdenado(claveMedia, 0, auxdel);
                this.raiz = nuevaraiz;
                auxDe = null;
                claveMedia = null;
            }
        }




        public nodoArbolB BuscarNodo(string codigo)
        {
            return BuscarNodo(codigo, this.raiz);
        }

        public void buscarID(String n)
        {
            System.Diagnostics.Debug.WriteLine("busacando coinsidencias con el usuario "+ n);
            IDencontrados = new string[contador];
            pagina = 0;
            buscarID(this.raiz, n);
        }

        private void buscarID(EddP1PaginaArbolB raiz, String n)
        {
            int k = 0;
            if (raiz != null)
            {
                int j = 0;
                int f = 1;
                while (j < raiz.cuenta)
                {
                    System.Diagnostics.Debug.WriteLine("comparando " + n + " con " + raiz.claves[j].nameUser);
                    if (n == raiz.claves[j].nameUser)
                    {
                        IDencontrados[k] = raiz.claves[j].nameUser;
                        System.Diagnostics.Debug.WriteLine("los datos coinsiden");
                        k++;
                    }
                    f += 2;
                    j++;
                }
                j = 0;
                f = 0;
                while (j <= raiz.cuenta)
                {
                    if (raiz.ramas[j] != null)
                    {

                        buscarID(raiz.ramas[j], n);
                    }
                    f += 2;
                    j++;
                }
            }
            int x =0;
            while (IDencontrados[x] != null)
            {
                System.Console.WriteLine(IDencontrados[k]);
            }
        }


        private nodoArbolB BuscarNodo(string codigo, EddP1PaginaArbolB raiz)
        {
            //SI LA PAGINA ES NULA LA CLAVE NO EXISTE
            if (raiz == null)
            {
                return null;
            }
            else
            {
                // VERIFICAMOS SI LA CLAVE ES MENOR A LA PAGINA PARA IR A BUSCAR A LA PRIMER PAGINA
                if (0 > string.Compare(codigo, raiz.claves[0].idT))
                {
                    return BuscarNodo(codigo, raiz.ramas[0]);
                }
                else
                {
                    int limite = raiz.cuenta;
                    //BUSCAMOS LA POSICION DONDE SE ENCUENTRA LA CLAVE O LA PAGINA DONDE ESTA
                    while (0 > string.Compare(codigo, raiz.claves[limite - 1].idT))
                    {
                        limite--;
                    }
                    //VALIDAMOS SI ES IGUAL A LA CLAVE
                    if (codigo == raiz.claves[limite - 1].idT)
                    {
                        return raiz.claves[limite - 1];
                    }
                    // SINO ES IGUAL NOS VAMOS A LA PAGINA CORRESPONDIENTE
                    return BuscarNodo(codigo, raiz.ramas[limite]);
                }
            }
        }

        #region EliminarNodo
        public void EliminarNodo(String codigo)
        {
            var tempraiz = this.raiz;
            this.raiz = new EddP1PaginaArbolB();
            if (!String.IsNullOrEmpty(codigo)) EliminarNodo(codigo, tempraiz);
        }
        private void EliminarNodo(String codigo, EddP1PaginaArbolB raiz)
        {
            if (raiz != null)
            {
                for (int i = 0; i < raiz.claves.Count(); i++)
                    if (raiz.claves[i] != null)
                        if (!raiz.claves[i].idT.Equals(codigo)) this.ingresar(raiz.claves[i]);
                contador--;
                for (int i = 0; i < raiz.ramas.Count(); i++)
                    EliminarNodo(codigo, raiz.ramas[i]);
            }
        }

        #endregion


        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*

        public void Graficar(String nombre)
        {
            pagina = 0;
            try
            {//C:\Users\Mynor\Documents\visual studio 2013\Projects\EddHistorialesP1\EddHistorialesP1\Models
                //C:\EDD
                System.IO.StreamWriter fp = new System.IO.StreamWriter(@"C:\\EDD\\" + nombre + ".dot");
                string lineas = "digraph g {\n node [shape = record]; \n" + ToGraphvizCabecera(nombre) + "}";
                System.Diagnostics.Debug.WriteLine(lineas);
                fp.WriteLine(lineas);
                fp.Close();
                ProcessStartInfo startInfo = new ProcessStartInfo(@"C:\\Program Files (x86)\\Graphviz2.38\\bindot.exe");
                startInfo.Arguments = "-Tpng " + "C:\\EDD\\" + nombre + ".dot" + " -o C:\\graficaArbolB.png";

                Process.Start(startInfo);
                //fin intento d graficar
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
                System.Diagnostics.Debug.WriteLine(e.TargetSite);
            }
        }

        public String ToGraphvizCabecera(String n)
        {
            String texto = "";
            pagina = 0;
            texto += ToGraphvizCabecera(this.raiz, n);
            return texto;
        }

        private String ToGraphvizCabecera(EddP1PaginaArbolB raiz, String n)
        {
            String texto = "";
            if (raiz != null)
            {
                int j = 0;
                int f = 1;
                texto = n + "p" + this.pagina + " [label=\"<f0> -  ";
                while (j < raiz.cuenta)
                {
                    texto += "|<f" + f + "> " + "ID_T: " + raiz.claves[j].idT + "\\n ID_User: " + raiz.claves[j].nameUser + "\\n ID_P: " + raiz.claves[j].idP + "\\n Empresa: " + raiz.claves[j].EmpresaUser + "\\n Depto: " + raiz.claves[j].deptUser + "\\n Fecha_Renta:" + raiz.claves[j].fechaRenta + "\\n Periodo:" + raiz.claves[j].periodoRenta + "\\n Rentado: " + raiz.claves[j].rentado + " |<f" + (f + 1) + "> -";
                    f += 2;
                    j++;
                }
                j = 0;
                texto += "\"];\n";
                int yo = pagina;
                f = 0;
                while (j <= raiz.cuenta)
                {
                    if (raiz.ramas[j] != null)
                    {

                        this.pagina += 1;
                        texto += n + "p" + yo + ":f" + f + " -> " + n + "p" + this.pagina + ";\n";
                        texto += ToGraphvizCabecera(raiz.ramas[j], n);
                    }
                    f += 2;
                    j++;
                }
            }
            return texto;
        }
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*

    }
}