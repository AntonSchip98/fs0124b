const apiKey =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGE4NTJkN2IxMTAwMTkwZTZkZjIiLCJpYXQiOjE3MDk4OTAxODEsImV4cCI6MTcxMTA5OTc4MX0.yiZeHOSSs45-l2pcM08ZnyxALMjy-L3POlgASv7Sya0";
const endPoint = "https://striveschool-api.herokuapp.com/api/product/";

const btnSave = document.querySelector("#save");
btnSave.addEventListener("click", (e) => {
  e.preventDefault();

  let name = document.querySelector("#name").value.trim();
  let description = document.querySelector("#description").value.trim();
  let brand = document.querySelector("#brand").value.trim();
  let imageUrl = document.querySelector("#imageUrl").value.trim();
  let price = document.querySelector("#price").value.trim();

  let product = {
    name,
    description,
    brand,
    imageUrl,
    price,
  };
  // impedisce la creazione se i campi non sono compilati
  if (!name || !price || !imageUrl) {
    alert("Assicurati di compilare tutti i campi.");
    e.preventDefault();
  } else {
    fetch("https://striveschool-api.herokuapp.com/api/product", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: apiKey,
      },
      body: JSON.stringify(product),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("prodotto caricato", data);
        location.href = "home.html";
      })
      .catch((err) => {
        console.log("errore", err);
      });
  }
});
