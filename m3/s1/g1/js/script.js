// il costo è di 20 cent per minuto
var User = /** @class */ (function () {
    function User(credit, callNumber) {
        this.credit = credit;
        this.callNumber = callNumber;
    }
    User.prototype.chiamata = function (minutes) {
        var costoChiamata = minutes * 0.2;
        if (costoChiamata <= this.credit) {
            this.credit -= costoChiamata;
            this.callNumber += minutes;
        }
        else {
            console.log("Credito insufficiente per effettuare la chiamata.");
        }
    };
    User.prototype.ricarica = function (addBalance) {
        this.credit += addBalance;
    };
    User.prototype.chiamata404 = function () {
        return this.credit;
    };
    User.prototype.getNumeroChiamata = function () {
        return this.callNumber;
    };
    User.prototype.azzeraChiamate = function () {
        this.callNumber = 0;
    };
    return User;
}());
var antonio = new User(5, 10);
// antonio.ricarica(10);
// console.log(antonio.chiamata404());
// antonio.chiamata(4);
// console.log(antonio.getNumeroChiamata());
antonio.chiamata(30);
console.log(antonio);
//# sourceMappingURL=script.js.map