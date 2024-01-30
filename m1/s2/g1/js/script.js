let anni = prompt("Quanti anni hai?");

if (anni >= 18 && anni <= 120) {
  document.write("Sei maggiorenne");
} else if (anni > 120) {
  document.write("Sei antico");
} else {
  document.write("Sei minorenne");
}
