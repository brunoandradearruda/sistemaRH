// Função para verificar a idade
function checkAge(input) {
    var dob = new Date(input.value);
    var today = new Date();
    var age = today.getFullYear() - dob.getFullYear();
    var m = today.getMonth() - dob.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
        age--;
    }
    if (age < 16) {
        alert("A idade do funcionário deve ser pelo menos 16 anos.");
        input.value = "";
    } else if (age > 75) {
        alert("A idade do funcionário não deve ser superior a 75 anos.");
        input.value = "";
    }
}

// Função para limitar o comprimento do ano
function limitYearLength(input) {
    var value = input.value;
    var year = value.split('-')[0];
    if (year.length > 4) {
        input.value = value.slice(0, -1);
    }
}
