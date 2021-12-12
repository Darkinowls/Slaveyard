function search() {

    let input = document.getElementsByClassName("search_input");

    console.log(input);

    let filter = [];
    for (let i = 0 ; i < input.length; i++){
        filter[i] = input[i].value;
    }

    let table = document.getElementById("myTable");
    let div = table.getElementsByTagName("div");
    for (let i = 1; i < div.length; i++) {
        let h5 = div[i].getElementsByTagName("h5");
        let bools = [];

        for (let j = 0; j < filter.length && filter; j++) {
           bools[j] = checkInRow(filter[j], h5)
        }

        let checker = arr => arr.every(v => v === true);

        if (checker(bools)) {
            div[i].style.display = "";
            continue;
        }

        div[i].style.display = "none";
    }
}


function checkInRow(filter, h5) {

    for (let k = 0 ; k < h5.length - 2 ; k++){
        if ((h5[k].textContent || h5[k].innerText).indexOf(filter) > -1) {
            return true;
        }
    }
    return false;
}


