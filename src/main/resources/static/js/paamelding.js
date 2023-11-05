console.log(document)

document.querySelector("form").addEventListener("submit", function(event) {
    var pass = document.querySelector("[name='passord']").value;
    var passRepeat = document.querySelector("[name='passordRepetert']").value;

    // if (pass !== passRepeat) {
    //     alert("Passwords don't match!");
    //     event.preventDefault(); // prevent form from submitting
    // }
});

