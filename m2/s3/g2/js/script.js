// ESERCIZIO 1:
const form = document.querySelector("#form");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const input = document.querySelector("input");
  const nameContainer = document.querySelector(".name-container");
  let p = nameContainer.querySelector("p");

  const action = e.submitter.value;

  if (action === "add") {
    if (input.value !== "") {
      localStorage.setItem("nome", input.value);

      if (nameContainer.innerHTML === "") {
        p = document.createElement("p");
        p.innerText = localStorage.getItem("nome");
        input.value = "";
        nameContainer.append(p);
      } else {
        p.innerText = localStorage.getItem("nome");
        input.value = "";
      }
    }
  } else if (action === "delete") {
    localStorage.removeItem("nome");
    if (!(nameContainer.innerHTML === "")) {
      p.remove();
    }
  }
});
