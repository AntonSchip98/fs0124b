let url = new URLSearchParams(location.search);
let id = url.get("id");

const apiKey =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGE4NTJkN2IxMTAwMTkwZTZkZjIiLCJpYXQiOjE3MDk4OTAxODEsImV4cCI6MTcxMTA5OTc4MX0.yiZeHOSSs45-l2pcM08ZnyxALMjy-L3POlgASv7Sya0";
let endPoint = `https://striveschool-api.herokuapp.com/api/product/${id}`;

document.addEventListener("DOMContentLoaded", function () {
  fetch(endPoint, {
    method: "GET",
    headers: {
      Authorization: apiKey,
    },
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);

      let nameEdit = document.querySelector("#name");
      let brandEdit = document.querySelector("#brand");
      let priceEdit = document.querySelector("#price");
      let imageUrlEdit = document.querySelector("#imageUrl");
      let descriptionEdit = document.querySelector("#description");

      nameEdit.value = data.name;
      brandEdit.value = data.brand;
      priceEdit.value = data.price;
      imageUrlEdit.value = data.imageUrl;
      descriptionEdit.value = data.description;
    });
});

// BOTTONE PER FARE L'UPDATE
const btnSave = document.querySelector("#save");
btnSave.addEventListener("click", (e) => {
  e.preventDefault();

  let nameEdit = document.querySelector("#name").value;
  let brandEdit = document.querySelector("#brand").value;
  let priceEdit = Number(document.querySelector("#price").value);
  let imageUrlEdit = document.querySelector("#imageUrl").value;
  let descriptionEdit = document.querySelector("#description").value;

  let product = {
    name: nameEdit,
    description: descriptionEdit,
    brand: brandEdit,
    imageUrl: imageUrlEdit,
    price: priceEdit,
  };

  fetch(endPoint, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: apiKey,
    },
    body: JSON.stringify(product),
  })
    .then((res) => res.json())
    .then((res) => {
      location.href = "home.html";
    });
});
// BOTTONE PER IL RESET DEL FORM(STESSA FETCH CALL, FARE UNA FUNZIONE)
const btnReset = document.querySelector("#reset");
btnReset.addEventListener("click", (e) => {
  let confirmDelete = confirm(
    "Le modifiche attuali andranno perse, sei sicuro di voler resettare?"
  );
  if (!confirmDelete) {
    e.preventDefault();
  } else {
    fetch(endPoint, {
      method: "GET",
      headers: {
        Authorization: apiKey,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);

        let nameEdit = document.querySelector("#name");
        let brandEdit = document.querySelector("#brand");
        let priceEdit = document.querySelector("#price");
        let imageUrlEdit = document.querySelector("#imageUrl");
        let descriptionEdit = document.querySelector("#description");

        nameEdit.value = data.name;
        brandEdit.value = data.brand;
        priceEdit.value = data.price;
        imageUrlEdit.value = data.imageUrl;
        descriptionEdit.value = data.description;
      });
  }
});

// BOTTONE PER IL DELETE DEL PRODOTTO:
const btnDelete = document.querySelector("#delete");
btnDelete.addEventListener("click", (e) => {
  let confirmDelete = confirm("Sei sicuro di voler cancellare?");

  if (!confirmDelete) {
    e.preventDefault();
  } else {
    e.preventDefault();
    fetch(endPoint, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: apiKey,
      },
    })
      .then((res) => res.json())
      .then((el) => {
        console.log("elemento eliminato" + el);
        location.href = "home.html";
      });
  }
});
