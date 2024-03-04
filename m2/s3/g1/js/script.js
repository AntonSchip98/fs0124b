// EXERCISE 1:
class User {
  constructor(_firstName, _lastName, _age, _location) {
    this.firstName = _firstName;
    this.lastName = _lastName;
    this.age = _age;
    this.location = _location;
  }

  ageComparator(i2) {
    if (!(i2 instanceof User)) {
      return "the property has to be instance of User";
    }
    if (this.age > i2.age) {
      return `${this.firstName} is ${this.age - i2.age} years older than ${
        i2.firstName
      }`;
    }
    if (i2.age > this.age) {
      return `${i2.firstName} is ${i2.age - this.age} years older than ${
        this.firstName
      }`;
    }
    if (this.age === i2.age) {
      return `${this.firstName} and ${i2.firstName} has the same age`;
    }
  }
}

let antonio = new User("Antonio", "Schipani", 25, "Calabria");
let beatrice = new User("Beatrice", "Riccio", 20, "Calabria");

// console.log(antonio.ageComparator(beatrice));

// EXERCISE 2:
class Pet {
  constructor(_petName, _ownerName, _species, _breed) {
    this.petName = _petName;
    this.ownerName = _ownerName;
    this.species = _species;
    this.breed = _breed;
  }

  static hasSameOwner(pet1, pet2) {
    if (!(pet1 instanceof Pet) || !(pet2 instanceof Pet)) {
      return "the property has to be instance of Pet";
    }
    if (pet1.ownerName === pet2.ownerName) {
      return `${pet1.petName} and ${pet2.petName} has the same owner, ${pet1.ownerName}`;
    } else {
      return `${pet1.petName} and ${pet2.petName} has not the same owner`;
    }
  }
}
const form = document.querySelector("#form");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const inputValues = document.querySelectorAll("input");
  let params = [];

  inputValues.forEach((el) => {
    params.push(el.value);
  });

  let newPet = new Pet(...params);

  const listContainer = document.querySelector(".list-container");
  const ul = document.createElement("ul");
  const li = document.createElement("li");

  listContainer.append(ul);
  li.textContent = `Name: ${newPet.petName}, Owner: ${newPet.ownerName}, Species: ${newPet.species}, Breed: ${newPet.breed}`;
  ul.append(li);
});

// let argo = new Pet("argo", "dario", "dog", "bastardino");
// let zen = new Pet("zen", "dario", "dog", "akita");
// console.log(Pet.hasSameOwner(argo, zen));
