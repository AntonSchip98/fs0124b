const tabellone = document.querySelector("#tabellone-container");
const estraiBtn = document.querySelector(".extractBtn");
const tabellina = document.querySelector("#tabellina-container");

//array contente i numeri da 1 a 90 che all estrazione andranno elimintai
const arrCaselle = [];
for (let i = 1; i < 91; i++) {
  arrCaselle.push(i);
}
// funzione per creare la tabella
const createTable = () => {
  for (let i = 1; i < 91; i++) {
    const numberDiv = document.createElement("div");
    numberDiv.classList.add("number");
    numberDiv.classList.add(`number-${i}`);
    numberDiv.innerText = i;
    tabellone.append(numberDiv);
  }
};

createTable();

// array contenente 24 numeri randomici della tabellina
const arrTabellina = [];
while (arrTabellina.length < 24) {
  const randomNumber = Math.floor(Math.random() * 90) + 1;
  if (!arrTabellina.includes(randomNumber)) {
    arrTabellina.push(randomNumber);
  }
}
// funzione per creare la tabellina
const createTabellina = () => {
  arrTabellina.forEach((el) => {
    const numberTabellina = document.createElement("div");
    numberTabellina.classList.add("miniNumber");
    numberTabellina.classList.add(`miniNumber-${el}`);
    numberTabellina.innerText = el;
    tabellina.append(numberTabellina);
  });
};

createTabellina();

// evento al bottone per estrarre il numero casuale
estraiBtn.addEventListener("click", function () {
  if (arrCaselle.length != 0) {
    //generiamo un index casuale per ricavare dall'array un
    // numero casuale da 0 a alla lunghezza dell array(che ad ogni
    // estrazione dimnuirà di uno)
    const randomIndex = Math.floor(Math.random() * arrCaselle.length);
    const randomNumber = arrCaselle[randomIndex];

    //con un template litreal selezionerò il div con la classe che ha in se il
    //numero randomico
    const extractedDiv = document.querySelector(`.number-${randomNumber}`);
    extractedDiv.style.backgroundColor = "yellow";

    if (arrTabellina.includes(randomNumber)) {
      const extractedDivTabellina = document.querySelector(
        `.miniNumber-${randomNumber}`
      );
      extractedDivTabellina.style.backgroundColor = "yellow";
    }

    //eliminiamo il numero estratto dall array
    arrCaselle.splice(randomIndex, 1);
    //   console.log(randomNumber);
    //   console.log(arrCaselle.length);
  } else {
    const p = document.createElement("p");
    p.innerText = "La tombola è finita";
    p.append("main");
    p.classList.add("title");
    tabellone.remove();
  }
});
