/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

/* 
let num1 = 10;
let num2 = 20;
console.log(Math.max(num1, num2));
 */

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

/* let num = 6;
if (num != 5) {
  console.log("not equal");
} */

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

/* let num = 15;
if (num % 5 == 0) {
  console.log("divisibile per 5");
} */

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/*
 let num1 = 4;
let num2 = 4;
if (num1 == 8 || num2 == 8) {
  console.log("uno dei due numeri è uguale a 8");
} else if (num1 + num2 == 8) {
  console.log("la somma dei due numeri è uguale ad 8");
}
 */

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* let totalShoppingCart = 60;
if (totalShoppingCart <= 50) {
  totalShoppingCart += 10;
}
console.log(
  "L'ammontare totale che deve essere addebitato all'utente per il checkout è: " +
    totalShoppingCart
); */

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

/* let totalShoppingCart = 60;
let scontoDel20 = (20 / 100) * totalShoppingCart;
let prezzoScontato = totalShoppingCart - scontoDel20;

if (prezzoScontato <= 50) {
  prezzoScontato += 10;
}
console.log(
  "L'ammontare totale che deve essere addebitato all'utente per il checkout è: " +
    prezzoScontato
); */

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/*
 let num1 = 10;
let num2 = 15;
let num3 = 5;

if (num1 < num2) {
  let temp = num1;
  num1 = num2;
  num2 = temp;
}

if (num1 < num3) {
  let temp = num1;
  num1 = num3;
  num3 = temp;
}

if (num2 < num3) {
  let temp = num2;
  num2 = num3;
  num3 = temp;
}
console.log("num1: " + num1);
console.log("num2: " + num2);
console.log("num3: " + num3); 
*/

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/*
 let num = 5;
 let string = "ciao";
if (typeof string == "number") {
  console.log("E' un numero");
} else {
  console.log("Non è un numero");
} 
*/

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* let num = 11;

if (num % 2 == 0) {
  console.log(num + " è pari");
}
if (num % 2 != 0) {
  console.log(num + " è dispari");
} */

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
*/

/*
 let val = 7;
if (val < 5) {
  console.log("Meno di 5");
} else if (val < 10) {
  console.log("Meno di 10");
} else {
  console.log("Uguale a 10 o maggiore");
}
 */

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

/*
 const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};
me.city = "Toronto";
console.log(me); 
*/

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/*
 const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};

delete me.lastName;
console.log(me);
 */

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/*
 const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};
me.skills.pop();
console.log(me);
 */

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/*
 let arr = [];
for (let i = 0; i < 10; i++) {
  arr[i] = i + 1;
}
console.log(arr); 
*/

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/*
 let arr = [];
for (let i = 0; i < 10; i++) {
  arr[i] = i + 1;
}
arr[arr.length - 1] = 100;
console.log(arr); 
*/
