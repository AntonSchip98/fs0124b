/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* I data type sono i differenti tipi di formato che possono essere assegnati ad una variabile in JavaScript, i principali datatype sono 3:
- String : possono essere parole singole, frasi o sentenze (insieme di caratteri) e devono essere racchiuse tra apici o doppi apici ("" / '');
- Numeri : sono valori numerici, li indichiamo inserendo semplicemente il valore numerico da noi desiderato ( 5, 10, 10.5, ...);
- Boolean : i valori boleani sono 2 valori precisi, che posso essere true (indica se un determinato parametro è vero) oppure false (indica se un determinato parametro è falso);
Poi possiamo avere anche altri 2 data type che sono Array ed Object*/

/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

// let myName = "Antonio";

/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

/* 
let num1 = 12;
let num2 = 20;
let somma = num1 + num2; 
*/

/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

/* let x = 12; */

/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

/* 
let myName = "Antonio";
myName = "Schipani";
const myNewName = "Antonio";
myNewName = "Schipani"; 
*/

/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

/*
let x = 12;
x -= 4;
console.log(x); 
*/

/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

/*
let name1 = "jhon";
let name2 = "Jhon";
console.log(name1 == name2);
console.log(name1.toLowerCase == name2.toLowerCase);
 */
