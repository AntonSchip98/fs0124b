window.addEventListener("scroll", function () {
  const navbar = document.querySelector("#nav-bar");
  const right = document.querySelector(".right-side");
  const navBtn = document.querySelector(".list button");
  let target = this.window.scrollY;

  if (target >= 300) {
    navbar.style.backgroundColor = "white";
    navBtn.style.backgroundColor = "green";
  } else {
    navbar.style.backgroundColor = "";
    navBtn.style.backgroundColor = "black";
  }

  if (target >= 800 && window.innerWidth > 1100) {
    right.classList.add("fixed");
  } else {
    right.classList.remove("fixed");
  }
});

// LOGICA PER L SVG DELLE M

const functionM = () => {
  const gElements = document.querySelectorAll(".svg g");
  // numero casuale tra un minimo(che sara 0) ed un massimo(che sara la lunghezza massima dell array gElements)
  function getRandomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  // funzione per far scomparire le m
  function fadeOut() {
    // funzion con intervallo che si ripete ogni 0.5 secondi per 5 secondi
    const fadeOutInterval = setInterval(() => {
      const randomIndex = getRandomNumber(0, gElements.length - 1);
      const gElement = gElements[randomIndex];

      // facciamo scomparire le m con l opacita 0
      gElement.style.opacity = 0;
    }, 30);

    // dopo 5 secondi, avvia la funzione fadeIn per far ricomparire le m
    setTimeout(() => {
      // con clear interval interrompo l intervallo della funzione fadeOutInterval
      clearInterval(fadeOutInterval);
      // avvio la funzione per far ricomparire le m
      fadeIn();
    }, 5000);
  }

  // stessa cosa di fadeOutM, ma fa ricomparire le m, quindi l opacity si settera ad 1
  function fadeIn() {
    const fadeInInterval = setInterval(() => {
      const randomIndex = getRandomNumber(0, gElements.length - 1);
      const gElement = gElements[randomIndex];

      gElement.style.opacity = 1;
      // imposto 10 perche non so il motivo ma le m scompaiono piu velocemente
    }, 10);

    setTimeout(() => {
      clearInterval(fadeInInterval);
      fadeOut();
    }, 5000);
  }
  fadeOut();
};
functionM();

// TOOLTIP
const tooltip = document.querySelectorAll(".tooltip");
tooltip.forEach((el) => {
  const tooltext = document.createElement("div");
  tooltext.classList.add("tooltext");
  const toolrow = document.createElement("div");
  toolrow.classList.add("tool-row");
  const imgElement = document.createElement("img");
  imgElement.src = "assets/imgs/image07.jpeg";
  const h5 = document.createElement("h5");
  h5.innerText = "Jerry Liu";
  const p = document.createElement("p");
  p.innerText = "Creator of Liam";
  const toolButton = document.createElement("div");
  toolButton.classList.add("tool-button");
  const toolP = document.createElement("p");
  toolP.innerText = "59.4K Followers";
  const button = document.createElement("button");
  button.innerText = "Follow";

  el.append(tooltext);
  tooltext.append(toolrow);
  toolrow.append(imgElement);
  toolrow.append(h5);
  tooltext.append(p);
  tooltext.append(toolButton);
  toolButton.append(toolP);
  toolButton.append(button);
});

console.log(tooltip);
