// il costo è di 20 cent per minuto

interface iSmartphone {
  // credito residuo sim
  credit: number;
  //   numero minuti chiamate effettuate
  callNumber: number;

  ricarica(addBalance: number): void;
  chiamata(minutes: number): void;
  chiamata404(): number;
  getNumeroChiamata(): number;
  azzeraChiamate(): void;
}

class User implements iSmartphone {
  credit: number;
  callNumber: number;

  constructor(credit: number, callNumber: number) {
    this.credit = credit;
    this.callNumber = callNumber;
  }

  chiamata(minutes: number): void {
    const costoChiamata = minutes * 0.2;
    if (costoChiamata <= this.credit) {
      this.credit -= costoChiamata;
      this.callNumber += minutes;
    } else {
      console.log("Credito insufficiente per effettuare la chiamata.");
    }
  }
  ricarica(addBalance: number): void {
    this.credit += addBalance;
  }
  chiamata404(): number {
    return this.credit;
  }
  getNumeroChiamata(): number {
    return this.callNumber;
  }
  azzeraChiamate(): void {
    this.callNumber = 0;
  }
}

let antonio = new User(5, 10);
// antonio.ricarica(10);
// console.log(antonio.chiamata404());
// antonio.chiamata(4);
// console.log(antonio.getNumeroChiamata());
antonio.chiamata(30);
console.log(antonio);
