// Esercizi aggiuntivi (facoltativi) per D4

/* EXTRA 1
 Scrivi una funzione chiamata "checkArray" che riceve un array di numeri casuali (creati con la funzione "giveMeRandom") e per ogni elemento stampa in console
 se il suo valore è maggiore di 5 o no.
 La funzione deve inoltre ritornare la somma di tutti i valori maggiori di 5.
*/
function giveMeRandom(n) {
  let arrNum = [];
  for (let i = 0; i <= n - 1; i++) {
    arrNum[i] = Math.floor(Math.random() * 11);
  }
  return arrNum;
}

function checkArray(arr) {
  for (let el of arr) {
    if (el > 5) {
      console.log(el + " è  maggiore di 5");
    } else if (el === 5) {
      console.log(el + " è  uguale a 5");
    } else {
      console.log(el + " è  minore di 5");
    }
  }
}

/* EXTRA 2
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "shoppingCartTotal" che calcola il totale dovuto al negozio (tenendo conto delle quantità di ogni oggetto).
*/
const shoppingCart = [
  { id: 1, name: "a", price: 10, quantity: 2 },
  { id: 2, name: "b", price: 15, quantity: 1 },
  { id: 3, name: "c", price: 30, quantity: 3 },
];
function shoppingCartTotal(arr) {
  let total = 0;

  for (let el of arr) {
    total += el.price * el.quantity;
  }
  return total;
}

/* EXTRA 3
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "addToShoppingCart" che riceve un nuovo oggetto dello stesso tipo, lo aggiunge a "shoppingCart" e ritorna il nuovo numero totale degli elementi.
*/
const newObj = { id: 4, name: "d", price: 25, quantity: 4 };

function addToShoppingCart(newObj, arr) {
  arr.push(newObj);
  return arr.length;
}

/* EXTRA 4
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "maxShoppingCart" che riceve l'array "shoppingCart" e ritorna l'oggetto più costoso in esso contenuto.
*/
function maxShoppingCart(arr) {
  let maxPrice = arr[0];
  for (let el of arr) {
    if (el.price > maxPrice.price) maxPrice = el;
  }
  return maxPrice;
}

/* EXTRA 5
 Nel tuo eCommerce disponi di un'array di oggetti chiamato "shoppingCart". Ognuno di questi oggetti ha le seguenti proprietà: "price", "name", "id" e "quantity".
 Crea una funzione chiamata "latestShoppingCart" che riceve l'array "shoppingCart" e ritorna l'ultimo elemento.
*/
function latestShoppingCart(arr) {
  return arr[arr.length - 1];
}

/* EXTRA 6
 Crea una funzione chiamata "loopUntil" che riceve un numero intero come parametro con valore tra 0 e 9.
 La funzione è composta da un ciclo che stampa un numero casuale tra 0 e 9 finchè il numero casuale non è maggiore di x per tre volte di fila.
*/
function loopUntil(x) {
  if ((x) => 0 && x <= 9) {
    let i = 0;

    while (i < 3) {
      let randomNum = Math.floor(Math.random() * 10);
      console.log("Random number: " + randomNum);

      if (randomNum > x) {
        i++;
      } else {
        i = 0;
      }
    }
    console.log(
      "3 numeri consecutivi maggiori di " + x + " sono stati generati"
    );
  } else {
    console.log("il numero inserito deve esser compreso tra 0 e 9");
  }
}

/* EXTRA 7
Crea una funzione chiamata "average" che riceve un array come parametro e ne ritorna la media aritmetica. La funzione salta automaticamente i valori non numerici nell'array.
*/

let arr = [42, 15, 7, "ciao", 10, "case", 5, 18, "cane"];

function average(arr) {
  let sum = 0;
  let count = 0;
  for (let el of arr) {
    if (typeof el === "number") {
      count++;
      sum += el;
    }
  }
  return sum / count;
}

/* EXTRA 8
 Crea una funzione chiamata "longest" che trova la stringa più lunga all'interno di un array di stringhe fornito come parametro.
*/

const arrayStr = ["ciao", "mondo", "casa", "cane", "array", "stringhe"];

function longest(arr) {
  let str = arr[0];
  for (let el of arr) {
    if (el.length > str.length) {
      str = el;
    }
  }
  return str;
}

/* EXTRA 9
 Crea una funzione per creare un filtro anti-spam per la tua casella email. La funzione riceve un parametro stringa chiamato "emailContent", e torna un valore booleano.
 La funzione deve ritornare true se "emailContent" non contiene le parole "SPAM" o "SCAM".
*/
let emailContent = "casscasas SCAM";
function filtroAntiSpam(emailContent) {
  if (emailContent.includes("SCAM") || emailContent.includes("SPAM")) {
    return false;
  } else {
    return true;
  }
}

/* EXTRA 10
 Scrivi una funzione che riceve una data come parametro, e calcola il numero di giorni passati da quella data.
*/
let dataPassata = new Date("2024-01-29");

function howManyDays(pastDate) {
  let actualDate = new Date();
  let days = Math.floor((actualDate - pastDate) / (1000 * 60 * 60 * 24));
  return days;
}

/* EXTRA 11
 Scrivi una funzione chiamata "matrixGenerator" che riceve come parametri due numeri interi, "x" e "y".
 Il risultato deve essere una matrice di "x" volte "y", e i valori devono rispecchiare gli indici della posizione all'interno della matrice.
 Es.: x = 3, y = 2
 ["00","01","02"
 "10","11","12"]
*/
function matrixGenerator(x, y) {
  let matrix = [];
  for (let i = 0; i <= x; i++) {
    let riga = [];
    for (let j = 0; j <= y; j++) {
      riga.push("" + i + "" + j);
    }
    matrix.push(riga);
  }
  return matrix;
}
