/*----------------------------------------------------------------------------
----------------------------------------- Area de Codigo de Usuario
----------------------------------------------------------------------------*/

//*** Importaciones 
//*** Paquetes 

package analizador;

import java_cup.runtime.*;
import java.util.ArrayList;


%%

%{

%}


/*----------------------------------------------------------------------------
----------------------------------------- Area de Opciones y Declaraciones
----------------------------------------------------------------------------*/

//*** Directivas

%public
%class lexico
%cupsym simbolo
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//*** Expresiones Regulares

digito = [0-9]
numero = ("-")?{digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*

//*** Estados

%state COMENT_SIMPLE
%state COMENT_MULTI

%%
/*-------------------------------------------------------------------
----------------------------------------- Area de Reglas Lexicas
-------------------------------------------------------------------*/

//*** Comentarios

<YYINITIAL> "/*"            {yybegin(COMENT_MULTI);}
<COMENT_MULTI> ["\n"]       {}
<COMENT_MULTI> [^"*/"]      {}
<COMENT_MULTI> "*/"         {yybegin(YYINITIAL);}

<YYINITIAL> "//"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]     {}
<COMENT_SIMPLE> "\n"        {yybegin(YYINITIAL);}


//*** simbolo


<YYINITIAL> ";"        {   System.out.println("Reconocido: <<"+yytext()+">>, puntoycoma");
                            return new Symbol(simbolo.puntoycoma, yycolumn, yyline, yytext());}

<YYINITIAL> ","        {   System.out.println("Reconocido: <<"+yytext()+">>, coma");
                            return new Symbol(simbolo.coma, yycolumn, yyline, yytext());}

<YYINITIAL> ">"         {   System.out.println("Reconocido: <<"+yytext()+">>, mayor");
                            return new Symbol(simbolo.mayor, yycolumn, yyline, yytext());}
                            
<YYINITIAL> "-"         {   System.out.println("Reconocido: <<"+yytext()+">>, guio");
                            return new Symbol(simbolo.guion, yycolumn, yyline, yytext());}

<YYINITIAL> {numero}        {   System.out.println("Reconocido: <<"+yytext()+">>, numero ");
                                return new Symbol(simbolo.numero, yycolumn, yyline, yytext());}

<YYINITIAL> {id}            {   System.out.println("Reconocido: <<"+yytext()+">>, id ");
                                return new Symbol(simbolo.id, yycolumn, yyline, yytext());}

[ \t\r\n\f]                 {/* ignore white space. */ }
 
.                           {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}