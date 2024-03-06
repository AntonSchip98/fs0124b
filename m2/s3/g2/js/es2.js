// ESERCIZIO 2:
let h1 = document.querySelector("h1");
let seconds = 0;

function timer() {
  setInterval(() => {
    seconds++;
    h1.innerText = sessionStorage.getItem("timer");

    sessionStorage.setItem("timer", seconds.toString());
  }, 1000);
}

const startTimer = () => {
  if (sessionStorage.getItem("timer") !== null) {
    seconds = sessionStorage.getItem("timer");
    h1.innerText = seconds;
  }
  timer();
};
startTimer();
