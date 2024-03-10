export const apiKey =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGE4NTJkN2IxMTAwMTkwZTZkZjIiLCJpYXQiOjE3MDk4OTAxODEsImV4cCI6MTcxMTA5OTc4MX0.yiZeHOSSs45-l2pcM08ZnyxALMjy-L3POlgASv7Sya0";
export let endPoint = "https://striveschool-api.herokuapp.com/api/product/";

// GET
export async function getCall(url) {
  const res = await fetch(url, {
    method: "GET",
    headers: {
      Authorization: apiKey,
    },
  });
  const product = await res.json();
  return product;
}

// POST
export async function postCall(dati) {
  try {
    const response = await fetch(endPoint, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: apiKey,
      },
      body: JSON.stringify(dati),
    });

    if (!response.ok) {
      throw new Error("Errore nella richiesta");
    }

    const risposta = await response.json();
    return risposta;
  } catch (errore) {
    console.error("Si è verificato un errore:", errore);
    throw errore;
  }
}

// PUT
export async function putCall(url, obj) {
  try {
    const response = await fetch(url, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: apiKey,
      },
      body: JSON.stringify(obj),
    });

    if (!response.ok) {
      throw new Error("Errore nella richiesta");
    }

    const risposta = await response.json();
    return risposta;
  } catch (errore) {
    console.error("Si è verificato un errore:", errore);
    throw errore;
  }
}

// DELETE
export async function deleteCall(url) {
  try {
    const response = await fetch(url, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: apiKey,
      },
    });

    if (!response.ok) {
      throw new Error("Errore nella richiesta");
    }

    const risposta = await response.json();
    return risposta;
  } catch (errore) {
    console.error("Si è verificato un errore:", errore);
    throw errore;
  }
}

export function generaClone() {
  let template = document.querySelector("#card-template");
  let clone = template.content.cloneNode(true);

  return clone;
}
