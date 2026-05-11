const ProductsList = document.querySelectorAll(".ProductDiv");

let name = "";
let priceInCents = 0;
let quantity = "";
let category = "";

const teste = new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3});

for (let i = 0; i < ProductsList.length; i++){
    ProductsList[i].addEventListener("click", (e)=>{
        
        name = String(ProductsList[i].querySelector(":nth-of-type(1)").innerHTML);
        priceInCents = ProductsList[i].querySelector(":nth-of-type(2)").innerHTML;
        quantity = ProductsList[i].querySelector(":nth-of-type(3)").innerHTML;
        category = ProductsList[i].querySelector(":nth-of-type(4)").innerHTML;
        
        const Values = ValuesHandler(name, priceInCents, quantity, category);
        
        document.getElementById("ProductsContainerID").style.display = "none";

        Values[1] = ConvertCentsToReal(Values[1]);
        document.getElementById('ProductModalID').innerHTML = `${Values[0]}<br>${Values[1]}<br>${Values[2]}<br>${Values[3]}`;
        OpenModal();
    })
}

function ValuesHandler(name, price, quantity, category){
    
    const ArrayValues = [name, price, quantity, category];

    for (i = 0; i < ArrayValues.length; i++){
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("<b>", "");
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("<b ", "");
        ArrayValues[i] = String(ArrayValues[i]).replace(/id="priceID"/g, "");
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("</b>", "");
        ArrayValues[i] = String(ArrayValues[i]).replace(">", "");
    }

    return ArrayValues;
}

document.getElementById("ModalWindowID").addEventListener("click", (e)=>{
    if (e.target.id == 'ModalWindowID'){
        CloseModal();
    }
})

function OpenModal() {
    const modal = document.getElementById('ModalWindowID');
    modal.classList.add('open');
}

function CloseModal() {
    const modal = document.getElementById('ModalWindowID');
    document.getElementById("ProductsContainerID").style.display = "flex";
    modal.classList.remove("open");
}

function ConvertCentsToReal(Cents){
    let real = Number(Cents.replace(/[^0-9.]/g, ""));
    real = teste.format(Number(real / 100));
    console.log(real);
    return real;
}